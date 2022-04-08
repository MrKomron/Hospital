package be.thomasmore.controllers;

import be.thomasmore.model.Department;
import be.thomasmore.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;

    @GetMapping({"/department", "/department/{id}"})
    public String animalDetails(Model model, @PathVariable(required = false) Integer id) {
        if (id==null) return "animaldetails";
        Optional<Department> optionalDepartment = departmentRepository.findById(id);
        Optional<Department> optionalPrev = departmentRepository.findFirstByIdLessThanOrderByIdDesc(id);
        Optional<Department> optionalNext = departmentRepository.findFirstByIdGreaterThanOrderById(id);
        if (optionalDepartment.isPresent()) {
            model.addAttribute("animal", optionalDepartment.get());
        }
        if (optionalPrev.isPresent()) {
            model.addAttribute("prev", optionalPrev.get().getId());
        } else {
            model.addAttribute("prev", departmentRepository.findFirstByOrderByIdDesc().get().getId());
        }
        if (optionalNext.isPresent()) {
            model.addAttribute("next", optionalNext.get().getId());
        } else {
            model.addAttribute("next", departmentRepository.findFirstByOrderByIdAsc().get().getId());
        }
        return "department";
    }
}
