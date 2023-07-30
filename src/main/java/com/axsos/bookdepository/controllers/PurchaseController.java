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
                "Dear " + user.getUserName() + ",\n" +
                        "We wanted to take a moment to express our heartfelt gratitude for your recent purchase from Book Depository. We truly appreciate your trust in us and choosing us as your source for books.\n" +
                        "At Book Depository, we strive to provide an exceptional online shopping experience with a wide selection of books and convenient delivery services. Your support not only helps us continue doing what we love but also encourages us to improve and serve you better.\n" +
                        "If you have any questions or need further assistance regarding your order or any other book-related queries, please don't hesitate to reach out. Our dedicated customer service team is here to help.\n" +
                        "Once again, thank you for being a valued customer of Book Depository. We look forward to serving you again in the future! "+ purchase.getBook().getName() +"\n" +
                        "Best regards, The Trio's Bookstore Team at Book Depository");
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
