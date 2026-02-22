package com.playlist.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.playlist.music.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
}