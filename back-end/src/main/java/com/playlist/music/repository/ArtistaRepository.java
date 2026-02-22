package com.playlist.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.playlist.music.entities.Artista;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Integer> {
}