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
    List<Song> trackList;
    private int length;
    private String imageUrl;

    // Constructors
    protected Album() {}

    public Album(long id, String title, String artist, int length, String imageUrl) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.length = length;
        this.imageUrl = imageUrl;
        this.trackList = new ArrayList<>();
        this.songCount = this.trackList.size();
    }

    public Album(String title, String artist, int length, String imageUrl) {
        this.title = title;
        this.artist = artist;
        this.length = length;
        this.imageUrl = imageUrl;
        this.trackList = new ArrayList<>();
        this.songCount = this.trackList.size();
    }

    // Methods
    public void calculateAlbumLength() {
        int total = 0;
        for(Song track : trackList) {
            total += track.length;
        }
        length = total;
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
        return trackList;
    }

    public void addSong(Song song) {
        song.setAlbum(this);
        trackList.add(song);
        this.songCount = this.trackList.size();
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
