package be.thomasmore.controllers;

import be.thomasmore.model.Contact;
import be.thomasmore.model.News;
import be.thomasmore.model.Patient;
import be.thomasmore.model.Services;
import be.thomasmore.repositories.ContactRepository;
import be.thomasmore.repositories.NewsRepository;
import be.thomasmore.repositories.PatientRepository;
import be.thomasmore.repositories.ServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private ServicesRepository servicesRepository;
    @Autowired
    private NewsRepository newsRepository;
    @Autowired
    private PatientRepository patientRepository;
    @Autowired
    private ContactRepository contactRepository;


    @ModelAttribute("services")
    public Services findService(@PathVariable(required = false) Integer id) {
        if (id!=null) {
            Optional<Services> optionalServices = servicesRepository.findById(id);
            if (optionalServices.isPresent()) return optionalServices.get();
        }
        return new Services();
    }

    @PostMapping("/servicesnew")
    public String serviceNewPost(Model model, @Valid @ModelAttribute("services") Services services, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("service", servicesRepository.findAll());
            return "admin/servicesnew";
        }
        servicesRepository.save(services);
        return "redirect:/servicesdetails/"+services.getId();
    }

    @GetMapping("/servicesnew")
    public String serviceNew(Model model) {
        model.addAttribute("service", servicesRepository.findAll());
        return "admin/servicesnew";
    }

    @GetMapping("/serviceedit/{id}")
    public String serviceEdit(Model model, @PathVariable int id) {
        model.addAttribute("service", servicesRepository.findAll());
        return "admin/serviceedit";
    }

    @PostMapping("/serviceedit/{id}")
    public String serviceEditPost(Model model, @PathVariable int id, @Valid @ModelAttribute("services") Services services, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("service", servicesRepository.findAll());
            return "admin/serviceedit";
        }
        servicesRepository.save(services);
        return "redirect:/servicesdetails/"+id;
    }









    @GetMapping("/newsedit/{id}")
    public String newsEdit(Model model, @PathVariable int id) {
        Optional<News> optionalNews = newsRepository.findById(id);
        if (optionalNews.isPresent()) {
            model.addAttribute("news", optionalNews.get());
        }
        return "admin/newsedit";
    }

    @PostMapping("/newsedit/{id}")
    public String newsEditPost(Model model, @PathVariable int id, @RequestParam String newsName,@RequestParam String text) {
        Optional<News> optionalNews = newsRepository.findById(id);
        if (optionalNews.isPresent()) {
            News news = optionalNews.get();
            news.setName(newsName);
            news.setText(text);
            newsRepository.save(news);
            model.addAttribute("news", news);
        }
        return "redirect:/newsdetails/"+id;
    }



    @GetMapping("/patientsedit/{id}")
    public String patientEdit(Model model, @PathVariable int id) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if (optionalPatient.isPresent()) {
            model.addAttribute("patients", optionalPatient.get());
        }
        return "admin/patientsedit";
    }



    @PostMapping("/patientsedit/{id}")
    public String patientEditPost(Model model, @PathVariable int id, @RequestParam String firstname,
                                @RequestParam String lastname,
                                  @RequestParam Integer age,
                                  @RequestParam String email,
                                  @RequestParam Integer phoneNumber,
                                  @RequestParam String bio) {
        Optional<Patient> optionalPatient = patientRepository.findById(id);
        if (optionalPatient.isPresent()) {
            Patient patient = optionalPatient.get();
            patient.setFirstname(firstname);
            patient.setLastname(lastname);
            patient.setAge(age);
            patient.setEmail(email);
            patient.setBio(bio);

            patientRepository.save(patient);
            model.addAttribute("patients", patient);
        }
        return "redirect:/patientdetails/"+id;
    }





}
