package be.thomasmore.controllers;

import be.thomasmore.model.Faq;
import be.thomasmore.model.Services;
import be.thomasmore.repositories.FaqRepository;
import be.thomasmore.repositories.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

@Controller
public class FaqController {
    @Autowired
    private FaqRepository faqRepository;

    @GetMapping({"/faq/{extraword}","/faq"})
    public String faqFilter(Model model, @RequestParam(required = false) String question) {
        Iterable<Faq> faqs = faqRepository.findByKeyword(question);
        Iterable<Faq> faq = faqRepository.findAll();
        model.addAttribute("question", question);
        model.addAttribute("faqs", faqs);
        model.addAttribute("faq", faq);
        model.addAttribute("filter", true);
        return "faq";
    }
}
