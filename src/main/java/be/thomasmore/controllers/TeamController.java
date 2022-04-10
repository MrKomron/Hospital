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
    public String servicesFilter(Model model) {
        Iterable<Team> teams = teamRepository.findAll();
        model.addAttribute("teams", teams);
        return "team";
    }


    @GetMapping({"/teamdetails/{id}", "/teamdetails"})
    public String servicesDetails(Model model, @PathVariable(required = false) Integer id) {
        if (id==null) {
            model.addAttribute("noserv","You did not choose an index for service. Please choose it!");
            return "teamdetails";
        }
        Optional<Team> optionalTeam = teamRepository.findById(id);
        Optional<Team> optionalPrev = teamRepository.findFirstByIdLessThanOrderByIdDesc(id);
        Optional<Team> optionalNext = teamRepository.findFirstByIdGreaterThanOrderById(id);
        if (optionalTeam.isPresent()) {
            Team t = optionalTeam.get();
            model.addAttribute("teams", t);
        }else{
            int max=teamRepository.findFirstByOrderByIdDesc().get().getId();
            int min=teamRepository.findFirstByOrderByIdAsc().get().getId();
            model.addAttribute("message","Index is between"+min+" and "+max);
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
