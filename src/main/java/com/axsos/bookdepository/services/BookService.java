package com.axsos.bookdepository.services;


import com.axsos.bookdepository.models.Book;
import com.axsos.bookdepository.models.Genre;
import com.axsos.bookdepository.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book createBook(Book book){
        return bookRepository.save(book);
    }

    public Book updateBook(Book book){
        return bookRepository.save(book);
    }

    public void deleteBook(Long id){
        bookRepository.deleteById(id);
    }

    public List<Book> getAssignedBooks(Genre genre){
        return bookRepository.findAllByGenres(genre);
    }

    public List<Book> getUnassignedBooks(Genre genre){
        return bookRepository.findByGenresNotContains(genre);
    }


    public List<Book> allBooks(){
        return bookRepository.findAll();
    }

    public Book findBook(Long id){
        Optional<Book> optionalBook = bookRepository.findById(id);
        if(optionalBook.isPresent()){
            return optionalBook.get();
        }else{
            return null;
        }
    }

    public List<Book> searchBooks(String keyword) {
        return bookRepository.findByNameContainingIgnoreCase(keyword);
    }

}
