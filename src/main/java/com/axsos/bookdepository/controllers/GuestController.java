package com.axsos.bookdepository.controllers;

import com.axsos.bookdepository.models.*;
import com.axsos.bookdepository.services.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Controller
public class GuestController {
    private final BookService bookService;
    private final GenreService genreService;
    private final PublisherService publisherService;
    private final AuthorService authorService;
    private final ReviewService reviewService;

    public GuestController(BookService bookService, GenreService genreService, PublisherService publisherService, AuthorService authorService, ReviewService reviewService) {
        this.bookService = bookService;
        this.genreService = genreService;
        this.publisherService = publisherService;
        this.authorService = authorService;
        this.reviewService = reviewService;
    }

    @GetMapping("/homeG")
    public String homeGuest(Model model) {
            List<Book> bookList = bookService.allBooks();
            model.addAttribute("books", bookList);
            List<Genre> genreList = genreService.allGenres();
            model.addAttribute("genres", genreList);

            return "/guest/home.jsp";
    }

    @GetMapping("/aboutUsG")
    public String about() {
            return "/guest/about.jsp";
    }

    @GetMapping("/publisherG/{id}")
    public String publisherG(@PathVariable("id") Long id, Model model) {
            model.addAttribute("publisher", publisherService.findPublisher(id));
            return "/guest/publisher.jsp";
    }

    @GetMapping("/authorG/{id}")
    public String authorG(@PathVariable("id") Long id, Model model) {
            model.addAttribute("author", authorService.findAuthor(id));
            return "/guest/author.jsp";
    }

    @GetMapping("/booksG/{id}")
    public String bookInfoG(@PathVariable("id") Long id,
                           @ModelAttribute("book") Book book,
                           @ModelAttribute("purchase") Purchase purchase,
                           Model model){
            Book bookId = bookService.findBook(id);
            model.addAttribute("book", bookId);

            model.addAttribute("assignedGenres", genreService.getAssignedGenres(book));
            model.addAttribute("unassignedGenres", genreService.getUnassignedGenres(book));

            List<Genre> genreList = genreService.allGenres();
            model.addAttribute("genres", genreList);

            List<Review> reviewList = reviewService.allReviews();
            model.addAttribute("reviews", reviewList);
            return "/guest/bookInfo.jsp";
    }

}
