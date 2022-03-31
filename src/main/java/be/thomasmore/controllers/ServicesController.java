package be.thomasmore.controllers;

import be.thomasmore.model.News;
import be.thomasmore.model.Services;
import be.thomasmore.repositories.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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

    @GetMapping({"/servicesdetails/{id}", "/servicesdetails"})
    public String venueDetails(Model model, @PathVariable(required = false) Integer id) {
        if (id==null) return "servicesdetails";
        Optional<Services> optionalVenue = servicesRepository.findById(id);
        Optional<Services> optionalPrev = servicesRepository.findFirstByIdLessThanOrderByIdDesc(id);
        Optional<Services> optionalNext = servicesRepository.findFirstByIdGreaterThanOrderById(id);
        if (optionalVenue.isPresent()) {
            Services s = optionalVenue.get();
            model.addAttribute("services", s);
//            model.addAttribute("parties", partyRepository.findByVenue(v));
        }
        if (optionalPrev.isPresent()) {
            model.addAttribute("prev", optionalPrev.get().getId());
        } else {
            model.addAttribute("prev", servicesRepository.findFirstByOrderByIdDesc().get().getId());
        }
        if (optionalNext.isPresent()) {
            model.addAttribute("next", optionalNext.get().getId());
        } else {
            model.addAttribute("next", servicesRepository.findFirstByOrderByIdAsc().get().getId());
        }
        return "servicesdetails";
    }


}
