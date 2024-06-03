package com.obaydullah.ucm.controllers;


import com.obaydullah.ucm.entities.User;
import com.obaydullah.ucm.forms.UserForm;
import com.obaydullah.ucm.helper.Message;
import com.obaydullah.ucm.helper.MessageType;
import com.obaydullah.ucm.services.UserService;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PageController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public String index() {
        return "redirect:home";
    }

    @RequestMapping("/authenticate")
    public String authenticate() { /// fall back error 405 when login , so redirect to dashboard
        return "redirect:/user/dashboard";
    }

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

    @RequestMapping(value = "/login")
    public String login(){
        System.out.println("login page echoing");
        return "login";
    }

//    @PostMapping("/login")
//    public String lin(){
//            System.out.println("login page echoing");
//            return "login";
//
//    }
//    @PostMapping("/authenticate")
//    public String auth(){
//        System.out.println("login page echoing");
//        return "redirect:/user/dashboard";
//
//    }

    @RequestMapping("/register")
    public String register(Model model){
        System.out.println("register page echoing");

        UserForm userForm = new UserForm();

        ///for sending default data to form
//        userForm.setName("Obaydullah");
//        userForm.setEmail("obaydullah@gmail.com");
//        userForm.setPassword("123456");
//        userForm.setAbout("Obaydullah");
//        userForm.setPhoneNumber("1234567890");
        model.addAttribute("userForm", userForm);
        return "register";
    }

    // processing register

    @RequestMapping(value = "/do-register", method = RequestMethod.POST)
    public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult rBindingResult, HttpSession session){
        System.out.println("do register running");


        ///fetch form data
        System.out.println("userForm = " + userForm);

        ///validate form data

        if(rBindingResult.hasErrors()){
            return "register";
        }


        ///save to db
        // user service

//        User user = User.builder()
//                .name(userForm.getName())
//                .password(userForm.getPassword())
//                .email(userForm.getEmail())
//                .about(userForm.getAbout())
//                .phoneNumber(userForm.getPhoneNumber())
//                .profilePic("https://images.unsplash.com/photo-1542596594-649edbc13630?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D")
//                .build();

        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic("https://images.unsplash.com/photo-1542596594-649edbc13630?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D");

        User savedUser = userService.saveUser(user);


        // registration success message

        Message message = Message.builder().content("Registration Successful").type(MessageType.green).build();

        session.setAttribute("message",message);

        System.out.println("savedUser = " + savedUser.toString());
        //redirect to  login page

        return "redirect:/register";
    }

//    @RequestMapping(value = "/authenticate",method = {RequestMethod.POST})
//    public String auth(){
//        return "redirect:/user/dashboard";
//    }

}
