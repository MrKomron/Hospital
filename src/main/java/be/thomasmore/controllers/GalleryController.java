package be.thomasmore.controllers;

import be.thomasmore.model.Pokemon;
import be.thomasmore.repositories.ItemsRepository;
import be.thomasmore.repositories.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Controller
public class GalleryController {
//    @Autowired
//    private PokemonRepository pokemonRepository;
////    @Autowired
////    private ItemsRepository itemsRepository;
//
//    @GetMapping({"/gallery"})
//    public String gallery(Model model){
//        LocalDateTime now = LocalDateTime.now();
//        DateTimeFormatter format = DateTimeFormatter.ofPattern("yyyy");
//        String formatDateTime = now.format(format);
//        model.addAttribute("dateNow",formatDateTime);
//        return "gallery";
//    }
//
//    @GetMapping({"/edit-pokemon","/edit-pokemon/{pokemon"})
//    public String editParty(@PathVariable(required = false)int pokemonId,Model model){
//        Optional<Pokemon> optionalPokemonFromDb=pokemonRepository.findById(pokemonId);
//        Pokemon pokemon =(optionalPokemonFromDb.isPresent())?optionalPokemonFromDb.get():null;
//        model.addAttribute("pokemon",pokemon);
////        model.addAttribute("items",itemsRepository.findAll());
//        return "edit/pokemon";
//    }
}
