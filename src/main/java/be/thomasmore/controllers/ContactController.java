package be.thomasmore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class ContactController {
    @GetMapping({"/contact"})
    public String contact(Model model){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy");
        String formatDateTime = now.format(format);
        model.addAttribute("dateNow",formatDateTime);
        return "contact";
    }
}