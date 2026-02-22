package com.playlist.music.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playlist.music.entities.Artista;
import com.playlist.music.repository.ArtistaRepository;

@Service
public class ArtistaService {

    @Autowired
    private ArtistaRepository repository;

    public List<Artista> listar() {
        return repository.findAll();
    }

    public Artista salvar(Artista artista) {
        return repository.save(artista);
    }

    public Artista buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Artista não encontrado"));
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}