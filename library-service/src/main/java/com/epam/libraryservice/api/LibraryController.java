package com.epam.libraryservice.api;

import com.epam.libraryservice.pojo.Library;
import com.epam.libraryservice.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/library/users/{user_id}/books/{books_id}")
public class LibraryController {
    private final LibraryService libraryService;

    @Autowired
    public LibraryController(final LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @PostMapping
    public ResponseEntity<Library> issueBook(@PathVariable(value = "user_id") final int userId,
                                             @PathVariable(value = "books_id") final int bookId) {
        return ResponseEntity.status(HttpStatus.OK).body(this.libraryService.issueBook(bookId, userId));
    }

    @DeleteMapping
    public ResponseEntity<String> deleteIssuedRecord(@PathVariable(value = "user_id") final int userId,
                                                     @PathVariable(value = "books_id") final int bookId) {
        this.libraryService.deleteBookRecord(userId, bookId);
        return ResponseEntity.status(HttpStatus.OK).body("Book Released");
    }
}
