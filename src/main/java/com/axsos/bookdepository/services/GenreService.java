package com.axsos.bookdepository.services;


import com.axsos.bookdepository.models.Book;
import com.axsos.bookdepository.models.Genre;
import com.axsos.bookdepository.repositories.GenreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreService {
    private final GenreRepository genreRepository;

    public GenreService(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public Genre createGenre(Genre genre){
        return genreRepository.save(genre);
    }

    public Genre updateGenre(Genre genre){
        return genreRepository.save(genre);
    }

    public List<Genre> getAssignedGenres(Book book){
        return genreRepository.findAllByBooks(book);
    }

    public List<Genre> getUnassignedGenres(Book book){
        return genreRepository.findByBooksNotContains(book);
    }

    public void deleteGenre(Long id){
        genreRepository.deleteById(id);
    }

    public List<Genre> allGenres(){
        return genreRepository.findAll();
    }

    public Genre findGenre(Long id){
        Optional<Genre> optionalGenre = genreRepository.findById(id);
        if(optionalGenre.isPresent()){
            return optionalGenre.get();
        }else {
            return null;
        }
    }
}
