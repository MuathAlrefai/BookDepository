package com.axsos.bookdepository.controllers;


import com.axsos.bookdepository.models.Publisher;
import com.axsos.bookdepository.models.User;
import com.axsos.bookdepository.services.PublisherService;
import com.axsos.bookdepository.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;


@Controller
public class PublisherController {
    private final PublisherService publisherService;
    private final UserService userService;

    public PublisherController(PublisherService publisherService, UserService userService) {
        this.publisherService = publisherService;
        this.userService = userService;
    }


    @GetMapping("/publisher/{id}")
    public String publisher(@PathVariable("id") Long id, Model model, HttpSession session) {
        if (session.getAttribute("user_id") != null) {
            Long userId = (Long) session.getAttribute("user_id");
            User currentUser = userService.findUserById(userId);
            model.addAttribute("currentUser", currentUser);


            model.addAttribute("publisher", publisherService.findPublisher(id));
            return "publisher.jsp";
        }
        return "redirect:/";
    }

    @PostMapping("/addPublisher")
    public String addPublisher(@Valid @ModelAttribute("publisher") Publisher publisher, BindingResult result){

        if(result.hasErrors()){
            return "admin/publisherForm.jsp";
        }else {
            publisherService.createPublisher(publisher);
            return "redirect:/publisherForm";
        }
    }

}
