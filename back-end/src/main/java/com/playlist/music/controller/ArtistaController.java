package com.playlist.music.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.playlist.music.entities.Artista;
import com.playlist.music.service.ArtistaService;

@RestController
@RequestMapping("/artistas")
public class ArtistaController {

    @Autowired
    private ArtistaService service;

    @GetMapping
    public List<Artista> listar() {
        return service.listar();
    }

    @PostMapping
    public Artista salvar(@RequestBody Artista artista) {
        return service.salvar(artista);
    }

    @GetMapping("/{id}")
    public Artista buscar(@PathVariable Integer id) {
        return service.buscarPorId(id);
    }

    @PutMapping("/{id}")
    public Artista atualizar(@PathVariable Integer id,
                             @RequestBody Artista artista) {

        Artista existente = service.buscarPorId(id);
        existente.setNome(artista.getNome());

        return service.salvar(existente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        service.deletar(id);
    }
}