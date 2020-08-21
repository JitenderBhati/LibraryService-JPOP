package com.epam.book_service.api;

import com.epam.book_service.dto.BookDto;
import com.epam.book_service.model.Book;
import com.epam.book_service.service.BookService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BookController {
    private final BookService bookService;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public BookController(final BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_admin')")
    public ResponseEntity<List<Book>> getAllBooks() {
        log.info("Invoked /api/v1/books endpoint");
        List<Book> listOfBooks = this.bookService.getBooks();
        return ResponseEntity
                .status(listOfBooks.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK)
                .body(listOfBooks);
    }

    @GetMapping("{bookId}")
    @PreAuthorize("hasAuthority('read')")
    public ResponseEntity<Book> getBook(@PathVariable("bookId") final Long bookId) {
        log.info("Invoked /api/v1/books/{} endpoint", bookId);
        return ResponseEntity.status(HttpStatus.OK).body(this.bookService.getBook(bookId));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('create')")
    public ResponseEntity<String> addBook(@Valid @RequestBody final BookDto book) {
        log.info("Invoked /api/v1/books endpoint with parameter: {}", book);
        this.bookService.addBook(book);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Book Added Successfully");
    }

    @DeleteMapping("{bookId}")
    @PreAuthorize("hasAuthority('delete')")
    public ResponseEntity<String> deleteBook(@PathVariable("bookId") final Long bookId) {
        log.info("Invoked /api/v1/books/{} endpoint", bookId);
        this.bookService.deleteBook(bookId);
        return ResponseEntity.status(HttpStatus.OK).body("Book Deleted Successfully");
    }

    @PutMapping("{bookId}")
    @PreAuthorize("hasAuthority('update')")
    public ResponseEntity<Book> updateBook(@PathVariable("bookId") final Long id,
                                           @Valid @RequestBody final BookDto book) {
        log.info("Invoked /api/v1/books/{} endpoint with parameter: {}", id, book);
        return ResponseEntity.status(HttpStatus.OK).body(this.bookService.updateBook(id, book));
    }
}
