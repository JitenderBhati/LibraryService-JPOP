package com.epam.book_service.service;

import com.epam.book_service.dto.BookDto;
import com.epam.book_service.model.Book;
import com.epam.book_service.repository.BookDataService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookDataService bookDataService;
    private final ModelMapper modelMapper;

    //TODO: Remove it after use
    private final Logger logger = LoggerFactory.getLogger(BookService.class);

    @Autowired
    public BookService(@Qualifier("BookDao") final BookDataService bookDataService,
                       final ModelMapper modelMapper) {
        this.bookDataService = bookDataService;
        this.modelMapper = modelMapper;
    }

    public void addBook(final BookDto book) {
        var returnValue = this.bookDataService.save(this.modelMapper.map(book, Book.class));
        logger.info("Return Value after adding book: {}", returnValue);
    }

    public Book getBook(final Long id) {
        return this.bookDataService.findById(id).orElse(null);
    }

    public List<Book> getBooks() {
        return this.bookDataService.findAll();
    }

    public void deleteBook(final Long id) {
        this.bookDataService.deleteById(id);
    }

    public Book updateBook(final Long id, final BookDto book) {
        var bookToUpdate = this.bookDataService.getOne(id);
        this.modelMapper.map(book, bookToUpdate);
        return this.bookDataService.save(bookToUpdate);
    }
}
