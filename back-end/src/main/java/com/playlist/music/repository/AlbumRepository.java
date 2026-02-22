package com.playlist.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.playlist.music.entities.Album;

public interface AlbumRepository extends JpaRepository<Album, Integer> {
}