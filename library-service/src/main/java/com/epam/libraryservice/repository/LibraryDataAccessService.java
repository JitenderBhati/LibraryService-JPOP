package com.epam.libraryservice.repository;

import com.epam.libraryservice.pojo.Library;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("libraryDao")
public interface LibraryDataAccessService extends JpaRepository<Library, Integer> {
    List<Library> findByUser(final int id);
     Library findByUserAndBook(final int userId, final int bookId);
}
