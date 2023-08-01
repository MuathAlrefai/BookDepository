package com.axsos.bookdepository.controllers;

import com.axsos.bookdepository.models.Book;
import com.axsos.bookdepository.services.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TestingController {

    private final BookService bookService;

    public TestingController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/searchh")
    public List<Book> searchh(@RequestParam("name") String name) {
        return bookService.searchBook(name);
    }
}