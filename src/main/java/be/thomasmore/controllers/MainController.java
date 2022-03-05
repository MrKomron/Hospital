package be.thomasmore.controllers;

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


}
