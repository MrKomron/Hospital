package be.thomasmore.controllers;

import be.thomasmore.model.User;
import be.thomasmore.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {
    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder encoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    @GetMapping("/login")
    public String login(Principal principal, Model model) {
        if (principal != null) return "redirect:/news";
        return "user/login";
    }

    @GetMapping("/logout")
    public String logout(Principal principal, Model model) {
        if (principal == null) return "redirect:/news";
        return "user/logout";
    }

    @GetMapping("/register")
    public String register(Principal principal) {
        if (principal != null) return "redirect:/contact";
        return "user/register";
    }


    @PostMapping("/register")
    public String registerPost(Principal principal,
                               @RequestParam String userName,
                               @RequestParam String password,
                               @RequestParam String name,
                               @RequestParam String city) {
        if (principal != null) return "redirect:/home";
        if (userName == null || userName.trim().equals("")) return "redirect:/home";
        if (password == null || password.trim().equals("")) return "redirect:/home";
        userName = userName.trim();
        Optional<User> optionalUser = userRepository.findByUsername(userName);
        if (optionalUser.isPresent()) return "redirect:/home";
        String encodedPassword = encoder.encode(password.trim());
        User user = new User(userName, encodedPassword, "ROLE_USER");
        userRepository.save(user);
//        Animal animal = new Animal(name.trim(), city.trim(), bio.trim(), user);
//        animalRepository.save(animal);
        autologin(userName, password.trim());
        return "redirect:/home";
    }

    private void autologin(String userName, String password) {
        UsernamePasswordAuthenticationToken token
                = new UsernamePasswordAuthenticationToken(userName, password);
        try {
            Authentication auth = authenticationManager.authenticate(token);
            logger.info("authentication: " + auth.isAuthenticated());
            SecurityContext sc = SecurityContextHolder.getContext();
            sc.setAuthentication(auth);
        } catch (AuthenticationException e) {
            e.printStackTrace();
        }
    }
}