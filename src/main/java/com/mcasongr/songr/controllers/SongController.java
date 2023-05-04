package com.mcasongr.songr.controllers;

import com.mcasongr.songr.models.Album;
import com.mcasongr.songr.models.Song;
import com.mcasongr.songr.repository.AlbumRepository;
import com.mcasongr.songr.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;
import java.util.List;

@Controller
public class SongController {
    @Autowired
    SongRepository songRepository;
    @Autowired
    AlbumRepository albumRepository;

    @PostMapping("addSong")
    public RedirectView addSong(long albumId, String title, int length, int trackNumber) {
        Album album = albumRepository.getById(albumId);
        Song song = new Song(title, length, trackNumber);
        album.addSong(song);
        songRepository.save(song);
        album.calculateAlbumLength();
        albumRepository.save(album); // to save the updated album length
        return new RedirectView("/album-detail/" + albumId);
    }

    @GetMapping("songs")
    public String getSongsPage(Model m) {
        List<Album> albums = albumRepository.findAll();
        m.addAttribute("albums", albums);
        return "songs.html";
    }

}
