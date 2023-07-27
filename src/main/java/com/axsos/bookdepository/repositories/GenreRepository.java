package com.axsos.bookdepository.repositories;


import com.axsos.bookdepository.models.Book;
import com.axsos.bookdepository.models.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GenreRepository extends CrudRepository<Genre, Long> {
    List<Genre> findAll();
    List<Genre> findAllByBooks(Book book);
    List<Genre> findByBooksNotContains(Book book);
}
