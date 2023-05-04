package com.mcasongr.songr.repository;

import com.mcasongr.songr.models.Song;
import org.springframework.data.jpa.repository.JpaRepository;
public interface SongRepository extends JpaRepository<Song, Long> {
}
