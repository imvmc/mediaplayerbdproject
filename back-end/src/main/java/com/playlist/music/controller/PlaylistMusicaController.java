package com.playlist.music.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.playlist.music.entities.PlaylistMusica;
import com.playlist.music.service.PlaylistMusicaService;

@RestController
@RequestMapping("/playlists")
public class PlaylistMusicaController {

    private final PlaylistMusicaService service;

    public PlaylistMusicaController(PlaylistMusicaService service) {
        this.service = service;
    }

    @PostMapping("/{playlistId}/musicas/{musicaId}")
    public PlaylistMusica adicionarMusica(
            @PathVariable Integer playlistId,
            @PathVariable Integer musicaId) {

        return service.adicionarMusica(playlistId, musicaId);
    }
}