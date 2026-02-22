package com.playlist.music.service;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.playlist.music.entities.*;
import com.playlist.music.repository.*;

@Service
public class HistoricoReproducaoService {

    private final UsuarioRepository usuarioRepository;
    private final MusicaRepository musicaRepository;
    private final HistoricoReproducaoRepository repository;

    public HistoricoReproducaoService(UsuarioRepository usuarioRepository,
                                      MusicaRepository musicaRepository,
                                      HistoricoReproducaoRepository repository) {
        this.usuarioRepository = usuarioRepository;
        this.musicaRepository = musicaRepository;
        this.repository = repository;
    }

    public HistoricoReproducao registrar(Integer usuarioId, Integer musicaId) {

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Musica musica = musicaRepository.findById(musicaId)
                .orElseThrow(() -> new RuntimeException("Música não encontrada"));

        LocalDateTime agora = LocalDateTime.now();

        HistoricoReproducaoId id =
                new HistoricoReproducaoId(usuarioId, musicaId, agora);

        HistoricoReproducao historico = new HistoricoReproducao();
        historico.setId(id);
        historico.setUsuario(usuario);
        historico.setMusica(musica);

        return repository.save(historico);
    }
}