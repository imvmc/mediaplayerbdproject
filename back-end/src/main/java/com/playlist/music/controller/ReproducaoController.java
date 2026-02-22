package com.playlist.music.controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.playlist.music.entities.HistoricoReproducao;
import com.playlist.music.service.HistoricoReproducaoService;

@RestController
@RequestMapping("/usuarios")
public class ReproducaoController {

    private final HistoricoReproducaoService service;

    public ReproducaoController(HistoricoReproducaoService service) {
        this.service = service;
    }

    @PostMapping("/{usuarioId}/reproduzir/{musicaId}")
    public HistoricoReproducao reproduzir(
            @PathVariable Integer usuarioId,
            @PathVariable Integer musicaId) {

        return service.registrar(usuarioId, musicaId);
    }
}