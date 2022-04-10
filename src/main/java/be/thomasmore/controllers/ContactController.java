package be.thomasmore.controllers;

import be.thomasmore.model.Contact;
import be.thomasmore.repositories.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class ContactController {
@Autowired
private ContactRepository contactRepository;


    @GetMapping({"/contact"})
    public String contact(Model model){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy");
        String formatDateTime = now.format(format);
        model.addAttribute("dateNow",formatDateTime);
        return "contact";
    }


    @PostMapping("/registration")
    public String register(@ModelAttribute Contact contact, HttpSession session){
        System.out.println(contact);
        contactRepository.save(contact);
        session.setAttribute("message","User register Sucessfully...");
        return "redirect:/";
    }

}
