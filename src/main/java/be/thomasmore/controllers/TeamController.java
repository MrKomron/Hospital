package be.thomasmore.controllers;

import be.thomasmore.model.Doctors;
import be.thomasmore.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;


@Controller
public class TeamController {
    @Autowired
    private TeamRepository teamRepository;

    @GetMapping({"/teamdetails", "/teamdetails/{id}"})
    public String animalDetails(Model model, @PathVariable(required = false) Integer id) {
        if (id==null) return "teamdetails";
        Optional<Doctors> optionalAnimal = teamRepository.findById(id);
        Optional<Doctors> optionalPrev = teamRepository.findFirstByIdLessThanOrderByIdDesc(id);
        Optional<Doctors> optionalNext = teamRepository.findFirstByIdGreaterThanOrderById(id);
        if (optionalAnimal.isPresent()) {
            model.addAttribute("team", optionalAnimal.get());
        }
        if (optionalPrev.isPresent()) {
            model.addAttribute("prev", optionalPrev.get().getId());
        } else {
            model.addAttribute("prev", teamRepository.findFirstByOrderByIdDesc().get().getId());
        }
        if (optionalNext.isPresent()) {
            model.addAttribute("next", optionalNext.get().getId());
        } else {
            model.addAttribute("next", teamRepository.findFirstByOrderByIdAsc().get().getId());
        }
        return "teamdetails";
    }
}
