package com.epam.libraryservice.api;

import com.epam.libraryservice.pojo.BookInfo;
import com.epam.libraryservice.proxies.BookServiceProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/library/")
public class LibraryBooksController {
    private final BookServiceProxy bookServiceProxy;

    @Autowired
    public LibraryBooksController(final BookServiceProxy bookServiceProxy) {
        this.bookServiceProxy = bookServiceProxy;
    }

    @GetMapping("books")
    public ResponseEntity<List<BookInfo>> getAllBooks() {
        return ResponseEntity.status(HttpStatus.OK).body(this.bookServiceProxy.getBooks());
    }

    @GetMapping("books/{book_id}")
    public ResponseEntity<BookInfo> getBook(@PathVariable(value = "book_id") final int book_id) {
        return ResponseEntity.status(HttpStatus.OK).body(this.bookServiceProxy.getBook(book_id));
    }

    @PostMapping("books")
    public ResponseEntity<String> addBook(@RequestBody final BookInfo bookInfo) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.bookServiceProxy.addBook(bookInfo));
    }

    @DeleteMapping("books/{book_id}")
    public ResponseEntity<String> deleteBook(@PathVariable(value = "book_id") final int bookId) {
        return ResponseEntity.status(HttpStatus.OK).body(this.bookServiceProxy.deleteBook(bookId));
    }
}
