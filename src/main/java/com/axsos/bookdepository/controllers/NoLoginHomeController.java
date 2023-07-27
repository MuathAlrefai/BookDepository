package com.axsos.bookdepository.controllers;

import com.axsos.bookdepository.models.Book;
import com.axsos.bookdepository.models.Genre;
import com.axsos.bookdepository.models.User;
import com.axsos.bookdepository.services.BookService;
import com.axsos.bookdepository.services.GenreService;
import com.axsos.bookdepository.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


@Controller
public class NoLoginHomeController {

    private final UserService userService;
    private final BookService bookService;
    private final GenreService genreService;

    public NoLoginHomeController(UserService userService, BookService bookService, GenreService genreService) {
        this.userService = userService;
        this.bookService = bookService;
        this.genreService = genreService;
    }


    @GetMapping("/home")
    public String noLoginHome(Model model, HttpSession session) {
            List<Book> bookList = bookService.allBooks();
            model.addAttribute("books", bookList);
            List<Genre> genreList = genreService.allGenres();
            model.addAttribute("genres", genreList);
            return "user/home.jsp";
    }

    /*@GetMapping("/adminHome")
    public String adminHome(Model model, HttpSession session) {
        if (session.getAttribute("user_id")!=null) {
            Long userId = (Long) session.getAttribute("user_id");
            User currentUser = userService.findUserById(userId);
            model.addAttribute("currentUser", currentUser);

            List<Book> bookList = bookService.allBooks();
            model.addAttribute("books", bookList);
            List<Genre> genreList = genreService.allGenres();
            model.addAttribute("genres", genreList);
            return "admin/adminHome.jsp";
        }
        return "redirect:/";
    }

    @GetMapping("/databaseForms")
    public String databaseForms(Model model, HttpSession session){
        if (session.getAttribute("user_id")!=null) {
            Long userId = (Long) session.getAttribute("user_id");
            User currentUser = userService.findUserById(userId);
            model.addAttribute("currentUser", currentUser);
            return "admin/databaseForms.jsp";
        }
        return "redirect:/";

    }*/


}
