package be.thomasmore.controllers;

import be.thomasmore.model.News;
import be.thomasmore.model.Services;
import be.thomasmore.repositories.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Optional;

@Controller
public class ServicesController {
    @Autowired
    private ServicesRepository servicesRepository;

    @GetMapping({"/services/{extraword}","/services"})
    public String servicesFilter(Model model, @RequestParam(required = false) String keyword) {
        Iterable<Services> services = servicesRepository.findByKeyword(keyword);
        Iterable<Services> service = servicesRepository.findAll();
        model.addAttribute("keyword", keyword);
        model.addAttribute("services", services);
        model.addAttribute("service", service);
        model.addAttribute("nrServices", ((Collection<?>) services).size());
        model.addAttribute("filter", true);
        return "services";
    }

    @GetMapping({"/servicesdetails/{id}", "/servicesdetails"})
    public String servicesDetails(Model model, @PathVariable(required = false) Integer id) {
        if (id==null) {
            model.addAttribute("noserv","You did not choose an index for service. Please choose it!");
            return "servicesdetails";
        }
        Optional<Services> optionalServices = servicesRepository.findById(id);
        Optional<Services> optionalPrev = servicesRepository.findFirstByIdLessThanOrderByIdDesc(id);
        Optional<Services> optionalNext = servicesRepository.findFirstByIdGreaterThanOrderById(id);
        if (optionalServices.isPresent()) {
            Services s = optionalServices.get();
            model.addAttribute("services", s);
        }else{
            int max=servicesRepository.findFirstByOrderByIdDesc().get().getId();
            int min=servicesRepository.findFirstByOrderByIdAsc().get().getId();
            model.addAttribute("message","Index is between"+min+" and "+max);
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
