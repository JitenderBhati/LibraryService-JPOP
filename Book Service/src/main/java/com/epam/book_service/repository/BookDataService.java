package com.epam.book_service.repository;

import com.epam.book_service.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("BookDao")
public interface BookDataService extends JpaRepository<Book, Long> {
}
