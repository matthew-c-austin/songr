package com.mcasongr.songr.repository;

import com.mcasongr.songr.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AlbumRepository extends JpaRepository<Album, Long> {
}
