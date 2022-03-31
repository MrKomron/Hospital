package be.thomasmore.controllers;

import be.thomasmore.model.News;
import be.thomasmore.repositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Controller
public class NewsController {
    @Autowired
    private NewsRepository newsRepository;
    @GetMapping({"/news"})
    public String news(Model model){
        Iterable<News> optionalVenue = newsRepository.findAll();
        model.addAttribute("newsall", optionalVenue);


        return "news";
    }






}
