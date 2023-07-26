package com.axsos.bookdepository.controllers;


import com.axsos.bookdepository.models.Author;
import com.axsos.bookdepository.models.Book;
import com.axsos.bookdepository.models.Publisher;
import com.axsos.bookdepository.models.User;
import com.axsos.bookdepository.services.AuthorService;
import com.axsos.bookdepository.services.BookService;
import com.axsos.bookdepository.services.PublisherService;
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
public class AdminBookController {
    private final BookService bookService;
    private final AuthorService authorService;
    private final PublisherService publisherService;
    private final UserService userService;

    public AdminBookController(BookService bookService, AuthorService authorService, PublisherService publisherService, UserService userService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.publisherService = publisherService;
        this.userService = userService;
    }

    @GetMapping("/bookForm")
    public String bookForm(@ModelAttribute("book") Book book, Model model, HttpSession session){
        if (session.getAttribute("user_id")!=null) {
            Long userId = (Long) session.getAttribute("user_id");
            User currentUser = userService.findUserById(userId);
            model.addAttribute("currentUser", currentUser);

            model.addAttribute("book", book);

            List<Book> bookList = bookService.allBooks();
            List<Author> authorList = authorService.allAuthors();
            List<Publisher> publisherList = publisherService.allPublishers();
            model.addAttribute("books", bookList);
            model.addAttribute("authors", authorList);
            model.addAttribute("publishers", publisherList);

            return "admin/bookForm.jsp";
        }
        return "redirect:/";
    }

    @PostMapping("/addBook")
    public String addPublisher(@Valid @ModelAttribute("book") Book book, BindingResult result){

        if(result.hasErrors()){
            return "admin/bookForm.jsp";
        }else {
            bookService.createBook(book);
            return "redirect:/bookForm";
        }
    }
}