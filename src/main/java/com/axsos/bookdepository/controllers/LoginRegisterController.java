package com.axsos.bookdepository.controllers;


import com.axsos.bookdepository.models.LoginUser;
import com.axsos.bookdepository.models.User;
import com.axsos.bookdepository.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginRegisterController {
    private final UserService userService;

    public LoginRegisterController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping("/")
    public String loginForm(Model model, HttpSession session) {
        if (session.getAttribute("user_id")!=null) {
            return "redirect:/home";
        }
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "/user/loginTest.jsp";
    }

    @GetMapping("/registerForm")
    public String registerForm(Model model, HttpSession session) {
        if (session.getAttribute("user_id")!=null) {
            return "redirect:/home";
        }
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "/user/register.jsp";
    }

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser,
                           BindingResult result, Model model, HttpSession session) {
        User regUser = userService.register(newUser, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "/user/register.jsp";
        }
        session.setAttribute("user_id", regUser.getId());
        return "redirect:/home";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin,
                        BindingResult result, Model model, HttpSession session) {
        User logUser = userService.login(newLogin, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "/user/loginTest.jsp";
        }
        if(logUser.getId() == 1){
            session.setAttribute("user_id", logUser.getId());
            return "redirect:/adminHome";
        }else{
        session.setAttribute("user_id", logUser.getId());
        return "redirect:/home";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/";
    }
}
