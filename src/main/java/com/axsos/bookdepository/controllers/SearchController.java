package com.axsos.bookdepository.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchController {

    @GetMapping("/ajax")
    public String ajax(){
        return "ajaxSearch.jsp";
    }

}
