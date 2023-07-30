package com.axsos.bookdepository.controllers;


import com.axsos.bookdepository.models.Author;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AuthorController {
    private final AuthorService authorService;
    private final UserService userService;

    public AuthorController(AuthorService authorService, UserService userService) {
        this.authorService = authorService;
        this.userService = userService;
    }

    @GetMapping("/author/{id}")
    public String author(@PathVariable("id") Long id, Model model, HttpSession session) {
        if (session.getAttribute("user_id") != null) {
            Long userId = (Long) session.getAttribute("user_id");
            User currentUser = userService.findUserById(userId);
            model.addAttribute("currentUser", currentUser);

            model.addAttribute("author", authorService.findAuthor(id));
            return "author.jsp";
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

    @PostMapping("/author/follow/{id}")
    public String followAuthor(@PathVariable("id") Long authorId, Model model, HttpSession session){
        if (session.getAttribute("user_id")!=null) {
            Long userId = (Long) session.getAttribute("user_id");
            User currentUser = userService.findUserById(userId);
            model.addAttribute("currentUser", currentUser);

            Author author = authorService.findAuthor(authorId);
            User user = userService.findUserById(userId);
            author.getUsers().add(user);
            authorService.updateAuthor(author);

            return "redirect:/books/{id}";
        }
        return "redirect:/";
    }

}
