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

    @GetMapping("/albums")
    public String albums(Model model) {
        Album[] albums = {
                new Album("The Dark Side of the Moon", "Pink Floyd", 10, 2640, "https://upload.wikimedia.org/wikipedia/en/3/3b/Dark_Side_of_the_Moon.png"),
                new Album("Thriller", "Michael Jackson", 9, 2580, "https://upload.wikimedia.org/wikipedia/en/5/55/Michael_Jackson_-_Thriller.png"),
                new Album("Back in Black", "AC/DC", 10, 2494, "https://upload.wikimedia.org/wikipedia/en/7/74/ACDC_Back_in_Black.png")
        };

        model.addAttribute("albums", albums);
        return "albums";
    }
}
