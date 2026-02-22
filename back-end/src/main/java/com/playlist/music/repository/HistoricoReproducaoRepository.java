package com.playlist.music.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.playlist.music.entities.HistoricoReproducao;
import com.playlist.music.entities.HistoricoReproducaoId;

public interface HistoricoReproducaoRepository
        extends JpaRepository<HistoricoReproducao, HistoricoReproducaoId> {
}