package com.playlist.music.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.playlist.music.entities.*;
import com.playlist.music.repository.*;

@Service
public class PlaylistMusicaService {

    private final PlaylistRepository playlistRepository;
    private final MusicaRepository musicaRepository;
    private final PlaylistMusicaRepository repository;

    public PlaylistMusicaService(PlaylistRepository playlistRepository,
                                 MusicaRepository musicaRepository,
                                 PlaylistMusicaRepository repository) {
        this.playlistRepository = playlistRepository;
        this.musicaRepository = musicaRepository;
        this.repository = repository;
    }

    public PlaylistMusica adicionarMusica(Integer playlistId, Integer musicaId) {

        Playlist playlist = playlistRepository.findById(playlistId)
                .orElseThrow(() -> new RuntimeException("Playlist não encontrada"));

        Musica musica = musicaRepository.findById(musicaId)
                .orElseThrow(() -> new RuntimeException("Música não encontrada"));

        PlaylistMusicaId id = new PlaylistMusicaId(playlistId, musicaId);

        PlaylistMusica playlistMusica = new PlaylistMusica();
        playlistMusica.setId(id);
        playlistMusica.setPlaylist(playlist);
        playlistMusica.setMusica(musica);
        playlistMusica.setDataAdicao(LocalDate.now());

        return repository.save(playlistMusica);
    }
}