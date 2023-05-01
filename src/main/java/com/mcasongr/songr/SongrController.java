package com.mcasongr.songr;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class SongrController {
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/capitalize/{text}")
    public String capitalize(Model model, @PathVariable String text) {
        model.addAttribute("capitalizedText", text.toUpperCase());
        return "/capitalize/{text}";
    }

    @GetMapping("/")
    public String splash() {
        return "splash";
    }
    
    @GetMapping("/albums")
    public String albums(Model model) {
        Album[] albums = {
                new Album("Loveless", "My Bloody Valentine", 11, 2911, "/images/My_Bloody_Valentine_-_Loveless.png"),
                new Album("Fleet Foxes", "Fleet Foxes", 6, 1362, "/images/Fleet_Foxes_-_Fleet_Foxes.jpg"),
                new Album("What's Going On", "Marvin Gaye", 11, 2132, "/images/What's_Going_On_-_Marvin_Gaye.jpg")
        };

        model.addAttribute("albums", albums);
        return "albums";
    }
}
