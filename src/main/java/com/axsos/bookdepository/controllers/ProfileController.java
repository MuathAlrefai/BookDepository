package com.axsos.bookdepository.controllers;

import com.axsos.bookdepository.models.User;
import com.axsos.bookdepository.services.AuthorService;
import com.axsos.bookdepository.services.BookService;
import com.axsos.bookdepository.services.PublisherService;
import com.axsos.bookdepository.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;


@Controller
public class ProfileController {
    private final UserService userService;
    private final BookService bookService;
    private final AuthorService authorService;
    private final PublisherService publisherService;

    public ProfileController(UserService userService, BookService bookService, AuthorService authorService, PublisherService publisherService) {
        this.userService = userService;
        this.bookService = bookService;
        this.authorService = authorService;
        this.publisherService = publisherService;
    }



    /*########   RENDERING METHODS   ########*/


    @GetMapping("/profile")
    public String profilePage(@ModelAttribute("user") User user,Model model, HttpSession session) {
        if (session.getAttribute("user_id")!=null) {
            Long userId = (Long) session.getAttribute("user_id");
            User currentUser = userService.findUserById(userId);
            model.addAttribute("currentUser", currentUser);

            model.addAttribute("users", userService.allUsers());
            model.addAttribute("books", bookService.allBooks());
            model.addAttribute("authors", authorService.allAuthors());
            model.addAttribute("publishers", publisherService.allPublishers());

            LocalDate myDate = LocalDate.now();
            model.addAttribute("date", myDate);

            LocalTime myTime = LocalTime.now();
            DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("hh:mm:ss a");
            String formattedTime = myTime.format(myFormatObj);
            model.addAttribute("time", formattedTime);

            return "profile.jsp";
        }
        return "redirect:/";
    }

    @GetMapping("/editProfile")
    public String editProfile(@ModelAttribute("user") User user,Model model, HttpSession session) {
        if (session.getAttribute("user_id")!=null) {
            Long userId = (Long) session.getAttribute("user_id");
            User currentUser = userService.findUserById(userId);
            model.addAttribute("currentUser", currentUser);

            return "editProfile.jsp";
        }
        return "redirect:/";
    }

    @GetMapping("/editPassword")
    public String editPassword(@ModelAttribute("user") User user, Model model, HttpSession session) {
        if (session.getAttribute("user_id")!=null) {
            Long userId = (Long) session.getAttribute("user_id");
            User currentUser = userService.findUserById(userId);
            model.addAttribute("currentUser", currentUser);

            return "editPassword.jsp";
        }
        return "redirect:/";
    }

    @GetMapping("/followingList")
    public String followingList(Model model, HttpSession session) {
        if (session.getAttribute("user_id")!=null) {
            Long userId = (Long) session.getAttribute("user_id");
            User currentUser = userService.findUserById(userId);
            model.addAttribute("currentUser", currentUser);

            return "followedAuthorList.jsp";
        }
        return "redirect:/";
    }


    /*########   PATCHING METHODS   ########*/


    @PatchMapping("/updateUser")
    public String updateUser(@RequestParam("userName") String userName,
                             @RequestParam("email") String email,
                             @RequestParam("avatar") String avatar,
                             @RequestParam("password") String password,
                             @RequestParam("confirm") String confirm,
                             HttpSession session){
            Long userId = (Long) session.getAttribute("user_id");
            User currentUser = userService.findUserById(userId);

            currentUser.setUserName(userName);
            currentUser.setEmail(email);
            currentUser.setAvatar(avatar);
            currentUser.setPassword(password);
            currentUser.setConfirm(confirm);

            userService.updateUser(currentUser);
            return "redirect:/profile";

        }

    @PatchMapping("/updatePassword")
    public String updatePassword(@RequestParam("userName") String userName,
                                 @RequestParam("email") String email,
                                 @RequestParam("password") String password,
                                 @RequestParam("confirm") String confirm,
                                 HttpSession session,
                                 Model model){
        Long userId = (Long) session.getAttribute("user_id");
        User currentUser = userService.findUserById(userId);
        model.addAttribute("currentUser", currentUser);

        String hashedPW = BCrypt.hashpw(password, BCrypt.gensalt());
        currentUser.setUserName(userName);
        currentUser.setEmail(email);
        currentUser.setPassword(hashedPW);
        currentUser.setConfirm(confirm);

        userService.updateUser(currentUser);

        return "redirect:/profile";

    }


}


