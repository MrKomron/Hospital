package be.thomasmore.controllers;

import be.thomasmore.model.News;
import be.thomasmore.model.Services;
import be.thomasmore.repositories.NewsRepository;
import be.thomasmore.repositories.ServicesRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Optional;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private Logger logger = LoggerFactory.getLogger(AdminController.class);
    @Autowired
    private ServicesRepository servicesRepository;
    @Autowired
    private NewsRepository newsRepository;

    @ModelAttribute("services")
    public Services findParty(@PathVariable(required = false) Integer id) {
        logger.info("findParty "+id);
        if (id!=null) {
            Optional<Services> optionalServices = servicesRepository.findById(id);
            if (optionalServices.isPresent()) return optionalServices.get();
        }
        return new Services();
    }

    @PostMapping("/servicesnew")
    public String partyNewPost(Model model, @Valid @ModelAttribute("services") Services services, BindingResult bindingResult) {
        logger.info("partyNewPost -- new name=" + services.getName() );
        if (bindingResult.hasErrors()) {
            model.addAttribute("service", servicesRepository.findAll());
            return "admin/servicesnew";
        }
        servicesRepository.save(services);
        return "redirect:/servicesdetails/"+services.getId();
    }

    @GetMapping("/servicesnew")
    public String partyNew(Model model) {
        logger.info("servicesnew");
        model.addAttribute("service", servicesRepository.findAll());
        return "admin/servicesnew";
    }

    @GetMapping("/serviceedit/{id}")
    public String serviceEdit(Model model, @PathVariable int id) {
        logger.info("serviceedit"+id);
        model.addAttribute("service", servicesRepository.findAll());
        return "admin/serviceedit";
    }

    @PostMapping("/serviceedit/{id}")
    public String serviceEditPost(Model model, @PathVariable int id, @Valid @ModelAttribute("services") Services services, BindingResult bindingResult) {
        logger.info("serviceeditpost : " + id + " -- new name: " + services.getName());
        if (bindingResult.hasErrors()) {
            model.addAttribute("service", servicesRepository.findAll());
            return "admin/serviceedit";
        }
        servicesRepository.save(services);
        return "redirect:/servicesdetails/"+id;
    }





    @ModelAttribute("news")
    public News findNews(@PathVariable(required = false) Integer id) {
        if (id!=null) {
            Optional<News> optionalNews = newsRepository.findById(id);
            if (optionalNews.isPresent()) return optionalNews.get();
        }
        return new News();
    }

    @GetMapping("/newsedit/{id}")
    public String newsEdit(Model model, @PathVariable int id) {
        logger.info("newsedit"+id);
        model.addAttribute("new", newsRepository.findAll());

        return "admin/newsedit";
    }

    @PostMapping("/newsedit/{id}")
    public String newsEditPost(Model model, @PathVariable int id, @Valid @ModelAttribute("news") News news, BindingResult bindingResult) {
        logger.info("newseditpost : " + id + " -- new name: ");
        if (bindingResult.hasErrors()) {
            model.addAttribute("new", newsRepository.findAll());
            return "admin/newsedit";
        }
        newsRepository.save(news);
        return "redirect:/newsdetails/"+id;
    }

    @GetMapping("/newsnew")
    public String newsNew(Model model) {
        logger.info("newsnew");
        model.addAttribute("new", newsRepository.findAll());
        return "admin/newsnew";
    }

    @PostMapping("/newsnew")
    public String newsNewPost(Model model, @Valid @ModelAttribute("news") Services services, BindingResult bindingResult) {
        logger.info("partyNewPost -- new name=" + services.getName() );
        if (bindingResult.hasErrors()) {
            model.addAttribute("new", newsRepository.findAll());
            return "admin/newsnew";
        }
        servicesRepository.save(services);
        return "redirect:/newsdetails/"+services.getId();
    }




}
