package com.playlist.music.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.playlist.music.entities.Album;
import com.playlist.music.entities.Artista;
import com.playlist.music.entities.Playlist;
import com.playlist.music.repository.AlbumRepository;
import com.playlist.music.repository.ArtistaRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AlbumService {

    private AlbumRepository repository;
  
    public AlbumService(AlbumRepository repository) {
        this.repository = repository;
    }
    @Autowired
    private ArtistaRepository artistaRepository;

    public List<Album> listar() {
        return repository.findAll();
    }

    public Album salvar(Album album) {

        Integer artistaId = album.getArtista().getIdArtista();

        Artista artista = artistaRepository.findById(artistaId)
                .orElseThrow(() -> new RuntimeException("Artista não encontrado"));

        album.setArtista(artista);

        return repository.save(album);
    }
    
    public Album buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Album não encontrado"));
    }

    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}