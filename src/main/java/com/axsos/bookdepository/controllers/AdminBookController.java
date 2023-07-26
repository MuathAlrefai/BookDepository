package com.axsos.bookdepository.controllers;


import com.axsos.bookdepository.models.*;
import com.axsos.bookdepository.services.*;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminBookController {
    private final BookService bookService;
    private final AuthorService authorService;
    private final PublisherService publisherService;
    private final UserService userService;
    private final GenreService genreService;

    public AdminBookController(BookService bookService, AuthorService authorService, PublisherService publisherService, UserService userService, GenreService genreService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.publisherService = publisherService;
        this.userService = userService;
        this.genreService = genreService;
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

    @GetMapping("/books/{id}")
    public String bookInfo(@PathVariable("id") Long id, @ModelAttribute("book") Book book, Model model, HttpSession session){
        if (session.getAttribute("user_id")!=null) {
            Long userId = (Long) session.getAttribute("user_id");
            User currentUser = userService.findUserById(userId);
            model.addAttribute("currentUser", currentUser);

            Book bookId = bookService.findBook(id);
            model.addAttribute("book", bookId);

            List<Genre> genreList = genreService.allGenres();
            model.addAttribute("genres", genreList);
            return "admin/adminBookInfo.jsp";
        }
        return "redirect:/";
    }

    @PostMapping("/addGenreToBook/{id}")
    public String addGenre(@PathVariable("id") Long bookId, @RequestParam("genreId") Long genreId){

            Book thisBook = bookService.findBook(bookId);
            Genre genre = genreService.findGenre(genreId);
            thisBook.getGenres().add(genre);
            bookService.updateBook(thisBook);
            return "redirect:/books/{id}";

    }
}