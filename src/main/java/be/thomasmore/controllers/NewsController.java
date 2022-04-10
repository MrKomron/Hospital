package be.thomasmore.controllers;

import be.thomasmore.model.News;
import be.thomasmore.model.Services;
import be.thomasmore.repositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;
import java.util.Optional;

@Controller
public class NewsController {
    @Autowired
    private NewsRepository newsRepository;


    @GetMapping({"/news/{extraword}","/news"})
    public String filterNews(Model model, @RequestParam(required = false) String nameandtext) {
        Iterable<News> news = newsRepository.findByNameAndText(nameandtext);
        Iterable<News> newnews = newsRepository.findAll();
        model.addAttribute("keyword", nameandtext);
        model.addAttribute("news", news);
        model.addAttribute("newnews", newnews);
        model.addAttribute("nrNews", ((Collection<?>) news).size());
        model.addAttribute("filter", true);
        return "news";
    }

    @GetMapping({"/newsdetails/{id}", "/newsdetails"})
    public String newsDetails(Model model, @PathVariable(required = false) Integer id) {
        if (id==null) {
            model.addAttribute("nonews","You did not choose an index for service. Please choose it!");
            return "newsdetails";
        }
        Optional<News> optionalNews = newsRepository.findById(id);
        Optional<News> optionalPrev = newsRepository.findFirstByIdLessThanOrderByIdDesc(id);
        Optional<News> optionalNext = newsRepository.findFirstByIdGreaterThanOrderById(id);
        if (optionalNews.isPresent()) {
            News n = optionalNews.get();
            model.addAttribute("news", n);
        }else{
            int max=newsRepository.findFirstByOrderByIdDesc().get().getId();
            int min=newsRepository.findFirstByOrderByIdAsc().get().getId();
            model.addAttribute("message","Index is between"+min+" and "+max);
        }
        if (optionalPrev.isPresent()) {
            model.addAttribute("prev", optionalPrev.get().getId());
        } else {
            model.addAttribute("prev", newsRepository.findFirstByOrderByIdDesc().get().getId());
        }
        if (optionalNext.isPresent()) {
            model.addAttribute("next", optionalNext.get().getId());
        } else {
            model.addAttribute("next", newsRepository.findFirstByOrderByIdAsc().get().getId());
        }
        return "newsdetails";
    }





}
