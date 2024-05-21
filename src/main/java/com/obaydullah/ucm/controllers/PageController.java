package com.obaydullah.ucm.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/home")
    public String home(Model model){
        System.out.println("Home page handler");

        // sending data to view
        model.addAttribute("name", "obaydullah");
        model.addAttribute("github", "https://github.com/0baydullah");
        model.addAttribute("facebook", "https://facebook.com/0baydullah0");
        return "home";
    }
}
