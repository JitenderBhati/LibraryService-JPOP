package com.epam.libraryservice.service;

import com.epam.libraryservice.pojo.Library;
import com.epam.libraryservice.repository.LibraryDataAccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class LibraryService {
    private final LibraryDataAccessService libraryDataAccessService;
    private final Library library;

    @Autowired
    public LibraryService(@Qualifier("libraryDao") final LibraryDataAccessService libraryDataAccessService,
                          final Library library) {
        this.libraryDataAccessService = libraryDataAccessService;
        this.library = library;
    }

    public Library issueBook(final int bookId, final int userId) {
        this.library.setUser(userId);
        this.library.setBook(bookId);
        this.library.setIssuedate(LocalDate.now());
        this.library.setIssuedby(1);
        return this.libraryDataAccessService.save(library);
    }

    public List<Library> getUserBooks(final int userId) {
        return this.libraryDataAccessService.findByUser(userId);
    }

    public void deleteBookRecords(final int userId) {
        this.libraryDataAccessService.deleteAll(this.libraryDataAccessService.findByUser(userId));
    }

    public  void deleteBookRecord(final  int userId, final int bookId) {
        this.libraryDataAccessService.delete(this.libraryDataAccessService.findByUserAndBook(userId, bookId));
    }
}
