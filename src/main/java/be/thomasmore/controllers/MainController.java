package be.thomasmore.controllers;

import be.thomasmore.model.Team;
import be.thomasmore.model.News;
import be.thomasmore.model.Services;
import be.thomasmore.repositories.TeamRepository;
import be.thomasmore.repositories.NewsRepository;
import be.thomasmore.repositories.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class MainController {
    @Autowired
    private ServicesRepository servicesRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private NewsRepository newsRepository;

    @GetMapping({"/","/home"})
    public String home(Model model){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy");
        String formatDateTime = now.format(format);
        model.addAttribute("dateNow",formatDateTime);

        Iterable<Services> allServices=servicesRepository.findAll();
        model.addAttribute("services",allServices);


        Iterable<Team> allDoctors=teamRepository.findAll();
        model.addAttribute("teams",allDoctors);

        Iterable<News> allNews=newsRepository.findAll();
        model.addAttribute("news",allNews);

      return "home";
    }

    @GetMapping({"/about"})
    public String about(Model model){

        return "about";
    }




}
