package com.axsos.bookdepository.controllers;


import com.axsos.bookdepository.services.AuthorService;
import org.springframework.stereotype.Controller;

@Controller
public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


}
