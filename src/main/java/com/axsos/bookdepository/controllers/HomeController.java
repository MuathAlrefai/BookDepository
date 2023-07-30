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
public class HomeController {

    private final UserService userService;
    private final BookService bookService;
    private final GenreService genreService;

    public HomeController(UserService userServ, BookService bookService, GenreService genreService) {
        this.userService = userServ;
        this.bookService = bookService;
        this.genreService = genreService;
    }

    @GetMapping("/home")
    public String home(Model model, HttpSession session) {
        if (session.getAttribute("user_id")!=null) {
            Long userId = (Long) session.getAttribute("user_id");
            User currentUser = userService.findUserById(userId);
            model.addAttribute("currentUser", currentUser);


            List<Book> specificBooks = bookService.getAssignedBooks(genreService.findGenre(userId));
            model.addAttribute("specificBook", specificBooks);
            List<Book> bookList = bookService.allBooks();
            model.addAttribute("books", bookList);
            List<Genre> genreList = genreService.allGenres();
            model.addAttribute("genres", genreList);
            return "home.jsp";
        }
        return "redirect:/";
    }



    @GetMapping("/aboutUs")
    public String about(Model model, HttpSession session) {
        if (session.getAttribute("user_id")!=null) {
            Long userId = (Long) session.getAttribute("user_id");
            User currentUser = userService.findUserById(userId);
            model.addAttribute("currentUser", currentUser);

            model.addAttribute("users", userService.allUsers());

            return "about.jsp";
        }
        return "redirect:/";
    }

    @GetMapping("/404")
    public String error404(Model model, HttpSession session){
        Long userId = (Long) session.getAttribute("user_id");
        User currentUser = userService.findUserById(userId);
        model.addAttribute("currentUser", currentUser);
        return "error404.jsp";
    }

}
