package com.axsos.bookdepository.controllers;


import com.axsos.bookdepository.models.Book;
import com.axsos.bookdepository.models.User;
import com.axsos.bookdepository.services.BookService;
import com.axsos.bookdepository.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class BookController {
    private final BookService bookService;
    private final UserService userService;

    public BookController(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    @GetMapping("/bookForm")
    public String bookForm(@ModelAttribute("book") Book book, Model model, HttpSession session){
        if (session.getAttribute("user_id")!=null) {
            Long userId = (Long) session.getAttribute("user_id");
            User currentUser = userService.findUserById(userId);
            model.addAttribute("currentUser", currentUser);

            model.addAttribute("book", book);

            return "bookForm.jsp";
        }
        return "redirect:/";
    }
}