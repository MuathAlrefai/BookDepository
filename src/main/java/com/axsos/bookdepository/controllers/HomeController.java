package com.axsos.bookdepository.controllers;

import com.axsos.bookdepository.models.User;
import com.axsos.bookdepository.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {

    private final UserService userService;

    public HomeController(UserService userServ) {
        this.userService = userServ;
    }

    @GetMapping("/home")
    public String home(Model model, HttpSession session) {
        if (session.getAttribute("user_id")!=null) {
            Long userId = (Long) session.getAttribute("user_id");
            User currentUser = userService.findUserById(userId);
            model.addAttribute("currentUser", currentUser);
            return "home.jsp";
        }
        return "redirect:/";
    }

    @GetMapping("/databaseForms")
    public String databaseForms(Model model, HttpSession session){
        if (session.getAttribute("user_id")!=null) {
            Long userId = (Long) session.getAttribute("user_id");
            User currentUser = userService.findUserById(userId);
            model.addAttribute("currentUser", currentUser);
            return "databaseForms.jsp";
        }
        return "redirect:/";

    }

}
