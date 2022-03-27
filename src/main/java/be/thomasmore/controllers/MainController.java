package be.thomasmore.controllers;

import be.thomasmore.model.Doctors;
import be.thomasmore.model.Services;
import be.thomasmore.repositories.DoctorsRepository;
import be.thomasmore.repositories.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    private ServicesRepository servicesRepository;
    @Autowired
    private DoctorsRepository doctorsRepository;

    @GetMapping({"/","/home"})
    public String home(Model model){
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy");
        String formatDateTime = now.format(format);
        model.addAttribute("dateNow",formatDateTime);

        Iterable<Services> allServices=servicesRepository.findAll();
        model.addAttribute("services",allServices);


        Iterable<Doctors> allDoctors=doctorsRepository.findAll();
        model.addAttribute("doctors",allDoctors);

        return "home";
    }


}
