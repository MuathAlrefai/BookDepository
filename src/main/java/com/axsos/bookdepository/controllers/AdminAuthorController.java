package com.axsos.bookdepository.controllers;


import com.axsos.bookdepository.models.Author;
import com.axsos.bookdepository.models.Genre;
import com.axsos.bookdepository.models.User;
import com.axsos.bookdepository.services.AuthorService;
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
public class AdminAuthorController {
    private final AuthorService authorService;
    private final UserService userService;

    public AdminAuthorController(AuthorService authorService, UserService userService) {
        this.authorService = authorService;
        this.userService = userService;
    }

    @GetMapping("/authorForm")
    public String authorForm(@ModelAttribute("author") Author author, Model model, HttpSession session) {
        if (session.getAttribute("user_id") != null) {
            Long userId = (Long) session.getAttribute("user_id");
            User currentUser = userService.findUserById(userId);
            model.addAttribute("currentUser", currentUser);

            model.addAttribute("author", author);
            List<Author> authorList = authorService.allAuthors();
            model.addAttribute("authors", authorList);
            return "admin/authorForm.jsp";
        }
        return "redirect:/";
    }

    @PostMapping("/addAuthor")
    public String addAuthor(@Valid @ModelAttribute("author") Author author, BindingResult result){

        if(result.hasErrors()){
            return "admin/authorForm.jsp";
        }else {
            authorService.createAuthor(author);
            return "redirect:/authorForm";
        }
    }

}
