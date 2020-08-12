package com.epam.libraryservice.service;

import com.epam.libraryservice.pojo.Library;
import com.epam.libraryservice.repository.LibraryDataAccessService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class LibraryService {
    private final LibraryDataAccessService libraryDataAccessService;
    private final Library library;

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public LibraryService(@Qualifier("libraryDao") final LibraryDataAccessService libraryDataAccessService,
                          final Library library) {
        this.libraryDataAccessService = libraryDataAccessService;
        this.library = library;
    }

    public Library issueBook(final int bookId, final int userId) {
        log.info("Called issue Book with parameters: bookId - {}, userId = {}", bookId, userId);
        this.library.setUser(userId);
        this.library.setBook(bookId);
        this.library.setIssuedate(LocalDate.now());
        this.library.setIssuedby(1);
        return this.libraryDataAccessService.save(library);
    }

    public List<Library> getUserBooks(final int userId) {
        log.info("Called get User Book with parameters:  userId = {}", userId);
        return this.libraryDataAccessService.findByUser(userId);
    }

    public void deleteBookRecords(final int userId) {
        log.info("Called delete User Book with parameters:  userId = {}", userId);
        this.libraryDataAccessService.deleteAll(this.libraryDataAccessService.findByUser(userId));
    }

    public  void deleteBookRecord(final  int userId, final int bookId) {
        log.info("Called delete Book Record with parameters: bookId - {}, userId = {}", bookId, userId);
        this.libraryDataAccessService.delete(this.libraryDataAccessService.findByUserAndBook(userId, bookId));
    }
}
