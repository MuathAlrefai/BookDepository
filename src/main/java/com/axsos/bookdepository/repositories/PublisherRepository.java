package com.axsos.bookdepository.repositories;


import com.axsos.bookdepository.models.Publisher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
    List<Publisher> findAll();
}
