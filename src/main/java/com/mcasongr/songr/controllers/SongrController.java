package com.mcasongr.songr.controllers;

import com.mcasongr.songr.models.Album;
import com.mcasongr.songr.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return "capitalize";
    }

    @GetMapping("/")
    public String splash() {
        return "splash";
    }
}
