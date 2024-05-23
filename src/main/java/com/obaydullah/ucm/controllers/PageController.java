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

    @RequestMapping("/about")
    public String about(){
        System.out.println("about page loading");
        return "about";
    }

    @RequestMapping("/services")
    public String services(){
        System.out.println("services page loading");
        return "services";
    }

    @RequestMapping("/contact")
    public String contact(){
        System.out.println("contact page echoing");
        return "contact";
    }

    @RequestMapping("/login")
    public String login(){
        System.out.println("login page echoing");
        return "login";
    }

    @RequestMapping("/register")
    public String register(){
        System.out.println("register page echoing");
        return "register";
    }


}
