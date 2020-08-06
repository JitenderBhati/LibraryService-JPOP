package com.epam.libraryservice.proxies;

import com.epam.libraryservice.pojo.BookInfo;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "book-service-app")
public interface BookServiceProxy {
    @GetMapping("api/v1/books")
    List<BookInfo> getBooks();

    @GetMapping("api/v1/books/{book_id}")
    BookInfo getBook(@PathVariable(value = "book_id") final int id);

    @PostMapping("api/v1/books")
    @Headers("Content-Type: application/json")
    String addBook(@RequestBody final BookInfo book);

    @DeleteMapping("api/v1/books/{book_id}")
    String deleteBook(@PathVariable(value = "book_id") final int book_id);
}
