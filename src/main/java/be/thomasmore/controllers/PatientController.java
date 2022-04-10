package be.thomasmore.controllers;

import be.thomasmore.model.Patient;
import be.thomasmore.model.Services;
import be.thomasmore.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;
import java.util.Optional;

@Controller
public class PatientController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping({"/patients"})
    public String patientFilter(Model model, @RequestParam(required = false) String firstname,
                                 @RequestParam(required = false) String lastname,
                                 @RequestParam(required = false) String newClinet,
                                 @RequestParam(required = false) Integer phoneNumber) {
        Iterable<Patient> patients = patientRepository.findByCapacityDistanceFoodIndoorOutdoor(lastname,
                firstname,
                ((newClinet==null ? null : (newClinet.equals("yes") ? true : false))),
                phoneNumber);
        Iterable<Patient> patients1 = patientRepository.findAll();
        model.addAttribute("firstname", firstname);
        model.addAttribute("lastname", lastname);
        model.addAttribute("newClinet", newClinet);
        model.addAttribute("phoneNumber", phoneNumber);
        model.addAttribute("patients", patients);
        model.addAttribute("patients1", patients1);
        model.addAttribute("nrPatient", ((Collection<?>) patients).size());
        model.addAttribute("filter", true);
        return "patients";
    }


    @GetMapping({"/patientdetails/{id}", "/patientdetails"})
    public String patientDetails(Model model, @PathVariable(required = false) Integer id) {
        if (id==null) {
            model.addAttribute("nopatients","You did not choose an index for service. Please choose it!");
            return "patientdetails";
        }
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        Optional<Patient> optionalPrev = patientRepository.findFirstByIdLessThanOrderByIdDesc(id);
        Optional<Patient> optionalNext = patientRepository.findFirstByIdGreaterThanOrderById(id);
        if (optionalPatient.isPresent()) {
            Patient p = optionalPatient.get();
            model.addAttribute("patients", p);
        }else{
            int max=patientRepository.findFirstByOrderByIdDesc().get().getId();
            int min=patientRepository.findFirstByOrderByIdAsc().get().getId();
            model.addAttribute("message","Index is between"+min+" and "+max);
        }
        if (optionalPrev.isPresent()) {
            model.addAttribute("prev", optionalPrev.get().getId());
        } else {
            model.addAttribute("prev", patientRepository.findFirstByOrderByIdDesc().get().getId());
        }
        if (optionalNext.isPresent()) {
            model.addAttribute("next", optionalNext.get().getId());
        } else {
            model.addAttribute("next", patientRepository.findFirstByOrderByIdAsc().get().getId());
        }
        return "patientdetails";
    }


}
