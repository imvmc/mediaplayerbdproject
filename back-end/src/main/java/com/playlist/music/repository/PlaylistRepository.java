package com.playlist.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.playlist.music.entities.Playlist;

public interface PlaylistRepository extends JpaRepository<Playlist, Integer> {
}