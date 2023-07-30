package com.axsos.bookdepository.repositories;


import com.axsos.bookdepository.models.Book;
import com.axsos.bookdepository.models.Genre;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
    List<Book> findAll();
    List<Book> findAllByGenres(Genre genre);
    List<Book> findByGenresNotContains(Genre genre);
    List<Book> findByNameContainingIgnoreCase(String name);
}
