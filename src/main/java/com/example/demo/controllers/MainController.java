package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class MainController {
    @GetMapping({"/","/home"})
    public String home(Model model){
        String address="12 Mikrorayon, Khujand, Tajikistan";
        String email="example@gmail.com";
        String number="+992 92 622 5060";
        String instagram="https://www.instagram.com/";
        String linkedin="https://www.linkedin.com/";
        String facebook="https://www.facebook.com/";
        model.addAttribute("address",address);
        model.addAttribute("email",email);
        model.addAttribute("number",number);
        model.addAttribute("instagram",instagram);
        model.addAttribute("linkedin",linkedin);
        model.addAttribute("facebook",facebook);

        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy");
        String formatDateTime = now.format(format);
        model.addAttribute("dateNow",formatDateTime);
        return "home";
    }

    @GetMapping({"/about"})
    public String about(Model model){

        return "about";
    }

    @GetMapping({"/services"})
    public String services(Model model){

        return "services";
    }

    @GetMapping({"/pages"})
    public String pages(Model model){

        return "pages";
    }

    @GetMapping({"/news"})
    public String news(Model model){

        return "news";
    }

    @GetMapping({"/contact"})
    public String contact(Model model){

        return "contact";
    }
}
