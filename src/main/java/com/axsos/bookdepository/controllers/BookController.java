package com.axsos.bookdepository.controllers;


import com.axsos.bookdepository.models.*;
import com.axsos.bookdepository.services.*;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class BookController {
    private final BookService bookService;
    private final UserService userService;
    private final GenreService genreService;
    private final ReviewService reviewService;

    public BookController(BookService bookService, UserService userService, GenreService genreService, ReviewService reviewService) {
        this.bookService = bookService;
        this.userService = userService;
        this.genreService = genreService;
        this.reviewService = reviewService;
    }


    @PostMapping("/addBook")
    public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult result){

        if(result.hasErrors()){
            return "admin/bookForm.jsp";
        }else {
            bookService.createBook(book);
            return "redirect:/bookForm";
        }
    }

    @GetMapping("/books/{id}")
    public String bookInfo(@PathVariable("id") Long id,
                           @ModelAttribute("book") Book book,
                           @ModelAttribute("purchase") Purchase purchase,
                           Model model,
                           HttpSession session){
        if (session.getAttribute("user_id")!=null) {
            Long userId = (Long) session.getAttribute("user_id");
            User currentUser = userService.findUserById(userId);
            model.addAttribute("currentUser", currentUser);

            Book bookId = bookService.findBook(id);
            model.addAttribute("book", bookId);

            model.addAttribute("assignedGenres", genreService.getAssignedGenres(book));
            model.addAttribute("unassignedGenres", genreService.getUnassignedGenres(book));

            List<Genre> genreList = genreService.allGenres();
            model.addAttribute("genres", genreList);

            List<Review> reviewList = reviewService.allReviews();
            model.addAttribute("reviews", reviewList);
            return "bookInfo.jsp";
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

    @PostMapping("/addReview/{id}")
    public String addReview(@PathVariable("id") Long id,
                            @RequestParam("review") String review,
                            @RequestParam("user") Long user,
                            @RequestParam("book") Long book){

            User user1 = userService.findUserById(user);
            Book book1 = bookService.findBook(book);

            Review review1 = new Review();
            review1.setReview(review);
            review1.setUser(user1);
            review1.setBook(book1);

            reviewService.createReview(review1);

            return "redirect:/books/{id}";

    }

    @GetMapping("/review/delete/{id}")
    public String deleteReview(@PathVariable("id") Long id,@RequestParam("bookId") Long bookId, Model model, HttpSession session) {
        if (session.getAttribute("user_id")!=null) {
            Long userId = (Long) session.getAttribute("user_id");
            User currentUser = userService.findUserById(userId);
            model.addAttribute("currentUser", currentUser);

            reviewService.deleteReview(id);
            return "redirect:/books/" + bookId;
        }
        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchBooks(@RequestParam("keyword") String keyword,
                              Model model,
                              HttpSession session) {
        Long userId = (Long) session.getAttribute("user_id");
        User currentUser = userService.findUserById(userId);
        model.addAttribute("currentUser", currentUser);

        List<Book> books = bookService.searchBooks(keyword);
        model.addAttribute("books", books);

        return "searchResults.jsp";
    }

/*        @GetMapping("/hireadeveloperr/{id}")
    public String triggerMail(
            @PathVariable("id") Long id
    ) {
        User user = userServ.findUserById(id);
        emailSenderService.sendSimpleEmail(user.getEmail(),
                "This is email body",
                "Test Test Test");
        return "redirect:/successcompany";
    }*/

}