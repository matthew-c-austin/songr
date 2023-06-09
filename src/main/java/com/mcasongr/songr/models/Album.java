package com.mcasongr.songr.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Album {

    // Fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    private String title;
    private String artist;
    private int songCount;
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL)
    @OrderBy("trackNumber")
    List<Song> songs;
    private int length;
    private String imageUrl;

    // Constructors
    protected Album() {}

    public Album(long id, String title, String artist, String imageUrl) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.imageUrl = imageUrl;
        this.songs = new ArrayList<>();
        this.songCount = this.songs.size();
        calculateAlbumLength();
    }

    public Album(String title, String artist, String imageUrl) {
        this.title = title;
        this.artist = artist;
        this.imageUrl = imageUrl;
        this.songs = new ArrayList<>();
        this.songCount = this.songs.size();
        calculateAlbumLength();
    }

    // Methods
    public void calculateAlbumLength() {
        int total = 0;
        for(Song track : this.songs) {
            total += track.length;
        }
       this.length = total;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getSongCount() {
        return songCount;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public List<Song> getTrackList() {
        return songs;
    }

    public void addSong(Song song) {
        song.setAlbum(this);
        songs.add(song);
        this.songCount = this.songs.size();
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
