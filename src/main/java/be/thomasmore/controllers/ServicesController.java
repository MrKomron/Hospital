package be.thomasmore.controllers;

import be.thomasmore.model.News;
import be.thomasmore.model.Services;
import be.thomasmore.repositories.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Controller
public class ServicesController {
    @Autowired
    private ServicesRepository servicesRepository;

    @GetMapping({"/services"})
    public String services(Model model){
       Iterable<Services> services = servicesRepository.findAll();
        model.addAttribute("services", services);


        return "services";
    }


}
