package com.epam.book_service.api;

import com.epam.book_service.dto.BookDto;
import com.epam.book_service.model.Book;
import com.epam.book_service.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("api/v1/books")
public class BookController {
    private final BookService bookService;

    @Autowired
    public BookController(final BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        var listOfBooks = this.bookService.getBooks();
        return ResponseEntity
                .status(listOfBooks.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK)
                .body(listOfBooks);
    }

    @GetMapping("{bookId}")
    public ResponseEntity<Book> getBook(@PathVariable("bookId") final Long bookId) {
        return ResponseEntity.status(HttpStatus.OK).body(this.bookService.getBook(bookId));
    }

    @PostMapping
    public ResponseEntity<String> addBook(@Valid @RequestBody final BookDto book) {
        this.bookService.addBook(book);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Book Added Successfully");
    }

    @DeleteMapping("{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable("bookId") final Long bookId) {
        this.bookService.deleteBook(bookId);
        return ResponseEntity.status(HttpStatus.OK).body("Book Deleted Successfully");
    }

    @PutMapping("{bookId}")
    public ResponseEntity<Book> updateBook(@PathVariable("bookId") final Long id,
                                           @Valid @RequestBody final BookDto book) {
        return ResponseEntity.status(HttpStatus.OK).body(this.bookService.updateBook(id, book));
    }
}
