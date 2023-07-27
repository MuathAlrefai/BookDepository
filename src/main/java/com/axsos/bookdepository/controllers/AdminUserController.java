package com.axsos.bookdepository.controllers;

import com.axsos.bookdepository.models.User;
import com.axsos.bookdepository.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class AdminUserController {
    private final UserService userService;


    public AdminUserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/profile")
    public String profilePage(@ModelAttribute("user") User user,Model model, HttpSession session) {
        if (session.getAttribute("user_id")!=null) {
            Long userId = (Long) session.getAttribute("user_id");
            User currentUser = userService.findUserById(userId);
            model.addAttribute("currentUser", currentUser);


            return "admin/userProfile.jsp";
        }
        return "redirect:/";
    }

    @PatchMapping("/updateUser")
    public String updateUser(@RequestParam("userName") String userName,
                             @RequestParam("email") String email,
                             @RequestParam("password") String password,
                             @RequestParam("confirm") String confirm,
                             HttpSession session){
            Long userId = (Long) session.getAttribute("user_id");
            User currentUser = userService.findUserById(userId);

            currentUser.setUserName(userName);
            currentUser.setEmail(email);
            currentUser.setPassword(password);
            currentUser.setConfirm(confirm);

            userService.updateUser(currentUser);
            return "redirect:/profile";

        }

    }


