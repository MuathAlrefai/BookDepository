package com.axsos.bookdepository.controllers;


import com.axsos.bookdepository.models.*;
import com.axsos.bookdepository.services.*;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Controller
public class AdminController {

    private final UserService userService;
    private final BookService bookService;
    private final AuthorService authorService;
    private final PublisherService publisherService;
    private final GenreService genreService;

    public AdminController(UserService userService, BookService bookService, AuthorService authorService, PublisherService publisherService, GenreService genreService) {
        this.userService = userService;
        this.bookService = bookService;
        this.authorService = authorService;
        this.publisherService = publisherService;
        this.genreService = genreService;
    }

    @GetMapping("/banUser/{id}")
    public String banUser(@PathVariable("id") Long id, Model model, HttpSession session) {
        if (session.getAttribute("user_id")!=null) {
            Long userId = (Long) session.getAttribute("user_id");
            User currentUser = userService.findUserById(userId);
            if(currentUser.getId() == 1){
                model.addAttribute("currentUser", currentUser);
                userService.banUser(id);
                return "redirect:/usersList";
            }else {
                return "redirect:/404";
            }
        }
        return "redirect:/";
    }

    @GetMapping("/book/delete/{id}")
    public String deleteBook(@PathVariable("id") Long id, Model model, HttpSession session) {
        if (session.getAttribute("user_id")!=null) {
            Long userId = (Long) session.getAttribute("user_id");
            User currentUser = userService.findUserById(userId);
            if(currentUser.getId() == 1){
                model.addAttribute("currentUser", currentUser);
                bookService.deleteBook(id);
                return "redirect:/bookList";
            }else {
                return "redirect:/404";
            }
        }
        return "redirect:/";
    }

    @GetMapping("/databaseForms")
    public String databaseForms(Model model, HttpSession session){
        if (session.getAttribute("user_id")!=null) {
            Long userId = (Long) session.getAttribute("user_id");
            User currentUser = userService.findUserById(userId);
            if(currentUser.getId() == 1){
                model.addAttribute("currentUser", currentUser);
                return "admin/databaseForms.jsp";
            }else {
                return "redirect:/404";
            }
        }
        return "redirect:/";

    }

    @GetMapping("/authorForm")
    public String authorForm(@ModelAttribute("author") Author author, Model model, HttpSession session) {
        if (session.getAttribute("user_id") != null) {
            Long userId = (Long) session.getAttribute("user_id");
            User currentUser = userService.findUserById(userId);
            if(currentUser.getId() == 1){
                model.addAttribute("currentUser", currentUser);
                model.addAttribute("author", author);
                List<Author> authorList = authorService.allAuthors();
                model.addAttribute("authors", authorList);
                return "admin/authorForm.jsp";
            }else {
                return "redirect:/404";
            }
        }
        return "redirect:/";
    }

    @GetMapping("/bookForm")
    public String bookForm(@ModelAttribute("book") Book book, Model model, HttpSession session){
        if (session.getAttribute("user_id")!=null) {
            Long userId = (Long) session.getAttribute("user_id");
            User currentUser = userService.findUserById(userId);
            if(currentUser.getId() == 1){
                model.addAttribute("currentUser", currentUser);
                model.addAttribute("book", book);

                List<Book> bookList = bookService.allBooks();
                List<Author> authorList = authorService.allAuthors();
                List<Publisher> publisherList = publisherService.allPublishers();
                model.addAttribute("books", bookList);
                model.addAttribute("authors", authorList);
                model.addAttribute("publishers", publisherList);

                return "admin/bookForm.jsp";
            }else {
                return "redirect:/404";
            }
        }
        return "redirect:/";
    }

    @GetMapping("/bookList")
    public String bookList(Model model, HttpSession session){
        if (session.getAttribute("user_id")!=null) {
            Long userId = (Long) session.getAttribute("user_id");
            User currentUser = userService.findUserById(userId);
            if(currentUser.getId() == 1){
                model.addAttribute("currentUser", currentUser);
                model.addAttribute("books", bookService.allBooks());
                return "/admin/adminBooksTable.jsp";
            }else {
                return "redirect:/404";
            }
        }
        return "redirect:/";
    }

    @GetMapping("/genreForm")
    public String genreForm(@ModelAttribute("genre") Genre genre, Model model, HttpSession session) {
        if (session.getAttribute("user_id") != null) {
            Long userId = (Long) session.getAttribute("user_id");
            User currentUser = userService.findUserById(userId);
            if(currentUser.getId() == 1){
                model.addAttribute("currentUser", currentUser);
                model.addAttribute("genre", genre);
                List<Genre> genreList = genreService.allGenres();
                model.addAttribute("genres", genreList);
                return "admin/genreForm.jsp";
            }else {
                return "redirect:/404";
            }
        }
        return "redirect:/";
    }

    @GetMapping("/usersList")
    public String usersList(@ModelAttribute("user") User user, Model model, HttpSession session) {
        if (session.getAttribute("user_id")!=null) {
            Long userId = (Long) session.getAttribute("user_id");
            User currentUser = userService.findUserById(userId);
            if(currentUser.getId() == 1){
                model.addAttribute("currentUser", currentUser);
                model.addAttribute("users", userService.allUsers());

                return "/admin/adminUsersTable.jsp";
            }else {
                return "redirect:/404";
            }
        }
        return "redirect:/";
    }

    @GetMapping("/publisherForm")
    public String publisherForm(@ModelAttribute("publisher") Publisher publisher, Model model, HttpSession session) {
        if (session.getAttribute("user_id") != null) {
            Long userId = (Long) session.getAttribute("user_id");
            User currentUser = userService.findUserById(userId);
            if(currentUser.getId() == 1){
                model.addAttribute("currentUser", currentUser);
                model.addAttribute("publisher", publisher);
                List<Publisher> publisherList = publisherService.allPublishers();
                model.addAttribute("publishers", publisherList);
                return "admin/publisherForm.jsp";
            }else {
                return "redirect:/404";
            }
        }
        return "redirect:/";
    }


}
