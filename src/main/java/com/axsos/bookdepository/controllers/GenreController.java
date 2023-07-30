package com.axsos.bookdepository.controllers;


import com.axsos.bookdepository.models.Genre;
import com.axsos.bookdepository.models.User;
import com.axsos.bookdepository.services.GenreService;
import com.axsos.bookdepository.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class GenreController {
    private final GenreService genreService;
    private final UserService userService;


    public GenreController(GenreService genreService, UserService userService) {
        this.genreService = genreService;
        this.userService = userService;
    }


    @PostMapping("/addGenre")
    public String addGenre(@Valid @ModelAttribute("genre") Genre genre, BindingResult result){

            if(result.hasErrors()){
                return "admin/genreForm.jsp";
            }else {
                genreService.createGenre(genre);
                return "redirect:/genreForm";
            }
    }
}
