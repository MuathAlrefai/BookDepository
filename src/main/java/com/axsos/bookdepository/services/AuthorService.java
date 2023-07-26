package com.axsos.bookdepository.services;


import com.axsos.bookdepository.models.Author;
import com.axsos.bookdepository.repositories.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public Author createAuthor(Author author){
        return authorRepository.save(author);
    }

    public Author updateAuthor(Author author){
        return authorRepository.save(author);
    }

    public void deleteAuthor(Long id){
        authorRepository.deleteById(id);
    }

    public List<Author> allAuthors(){
        return authorRepository.findAll();
    }

    public Author findAuthor(Long id){
        Optional<Author> optionalAuthor = authorRepository.findById(id);
        if(optionalAuthor.isPresent()){
            return optionalAuthor.get();
        }else {
            return null;
        }
    }
}
