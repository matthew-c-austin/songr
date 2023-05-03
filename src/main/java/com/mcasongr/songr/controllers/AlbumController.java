package com.mcasongr.songr.controllers;

import com.mcasongr.songr.models.Album;
import com.mcasongr.songr.repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
public class AlbumController {
    @Autowired
    AlbumRepository albumRepository;

    @GetMapping("/albums")
    public RedirectView getAllAlbums(Model model) {
            List<Album> albums = albumRepository.findAll();

            if (!albums.isEmpty()) {
                model.addAttribute("albums", albums);
            }

        return new RedirectView("/albums");
    }

    @PostMapping("/albums")
    public RedirectView addAlbum(String title,
                                 String artist,
                                 int songCount,
                                 int length,
                                 String imageUrl) {
        Album newAlbum = new Album(title, artist, songCount, length, imageUrl);
        albumRepository.save(newAlbum);
        return new RedirectView("/albums");
    }
}
