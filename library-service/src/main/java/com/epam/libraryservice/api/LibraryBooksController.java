package com.epam.libraryservice.api;

import com.epam.libraryservice.pojo.BookInfo;
import com.epam.libraryservice.proxies.BookServiceProxy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/library/")
public class LibraryBooksController {
    private final BookServiceProxy bookServiceProxy;
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public LibraryBooksController(final BookServiceProxy bookServiceProxy) {
        this.bookServiceProxy = bookServiceProxy;
    }

    @GetMapping("books")
    public ResponseEntity<List<BookInfo>> getAllBooks() {
        log.info("Invoked /books");
        return ResponseEntity.status(HttpStatus.OK).body(this.bookServiceProxy.getBooks());
    }

    @GetMapping("books/{book_id}")
    public ResponseEntity<BookInfo> getBook(@PathVariable(value = "book_id") final int book_id) {
        log.info("Invoked /books/{}", book_id);
        return ResponseEntity.status(HttpStatus.OK).body(this.bookServiceProxy.getBook(book_id));
    }

    @PostMapping("books")
    public ResponseEntity<String> addBook(@RequestBody final BookInfo bookInfo) {
        log.info("Invoked /books with parameter: {}", bookInfo);
        return ResponseEntity.status(HttpStatus.CREATED).body(this.bookServiceProxy.addBook(bookInfo));
    }

    @DeleteMapping("books/{book_id}")
    public ResponseEntity<String> deleteBook(@PathVariable(value = "book_id") final int bookId) {
        log.info("Invoked /books/{}", bookId);
        return ResponseEntity.status(HttpStatus.OK).body(this.bookServiceProxy.deleteBook(bookId));
    }
}
