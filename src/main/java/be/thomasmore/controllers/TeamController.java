package be.thomasmore.controllers;

import be.thomasmore.model.Services;
import be.thomasmore.model.Team;
import be.thomasmore.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.Optional;


@Controller
public class TeamController {
    @Autowired
    private TeamRepository teamRepository;

    @GetMapping({"/team/{extraword}","/team"})
    public String servicesFilter(Model model, @RequestParam(required = false) String keyword) {
//        Iterable<Team> services = teamRepository.findByKeyword(keyword);
        Iterable<Team> teams = teamRepository.findAll();
//        model.addAttribute("keyword", keyword);
//        model.addAttribute("services", services);
        model.addAttribute("teams", teams);
//        model.addAttribute("nrServices", ((Collection<?>) services).size());
        model.addAttribute("filter", true);
        return "team";
    }


    @GetMapping({"/teamdetails", "/teamdetails/{id}"})
    public String animalDetails(Model model, @PathVariable(required = false) Integer id) {
        if (id==null) return "teamdetails";
        Optional<Team> optionalAnimal = teamRepository.findById(id);
        Optional<Team> optionalPrev = teamRepository.findFirstByIdLessThanOrderByIdDesc(id);
        Optional<Team> optionalNext = teamRepository.findFirstByIdGreaterThanOrderById(id);
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
