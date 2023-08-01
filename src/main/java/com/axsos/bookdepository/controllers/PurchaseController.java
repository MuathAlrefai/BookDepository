package com.axsos.bookdepository.controllers;


import com.axsos.bookdepository.models.Purchase;
import com.axsos.bookdepository.models.User;
import com.axsos.bookdepository.services.EmailSenderService;
import com.axsos.bookdepository.services.PurchaseService;
import com.axsos.bookdepository.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PurchaseController {
    private final PurchaseService purchaseService;
    private final UserService userService;
    private final EmailSenderService emailSenderService;

    public PurchaseController(PurchaseService purchaseService, UserService userService, EmailSenderService emailSenderService) {
        this.purchaseService = purchaseService;
        this.userService = userService;

        this.emailSenderService = emailSenderService;
    }

    @PostMapping("/buyBook")
    public String buyBook(@ModelAttribute("purchase") Purchase purchase){
        purchaseService.createPurchase(purchase);
        User user = purchase.getUser();
        emailSenderService.sendSimpleEmail(user.getEmail(),
                "Thank You for Your Purchase from Book Depository!",
                "Dear " + user.getUserName() + ",\n" + "\n" + "This is a summary of your order " + "\n"
                     + "Invoice: " + "\n" + "Book Name: " + purchase.getBook().getName() + "." + "\n" + "Price: " + "$" + purchase.getBook().getPrice() + "." + "\n" +
                         "Purchase Date: " + purchase.getCreatedAt() + "\n" + "\n" +
                         "See you later!");
        return "redirect:/buySuccess";
    }

    @GetMapping("/buySuccess")
    public String buySuccess(Model model, HttpSession session){
        if (session.getAttribute("user_id")!=null) {
            Long userId = (Long) session.getAttribute("user_id");
            User currentUser = userService.findUserById(userId);
            model.addAttribute("currentUser", currentUser);

            return "buySuccess.jsp";
        }
        return "redirect:/";
    }

    @GetMapping("/purchaseList")
    public String purchaseList(Model model, HttpSession session){
        if (session.getAttribute("user_id")!=null) {
            Long userId = (Long) session.getAttribute("user_id");
            User currentUser = userService.findUserById(userId);
            model.addAttribute("currentUser", currentUser);

            return "purchaseList.jsp";
        }
        return "redirect:/";
    }

}
