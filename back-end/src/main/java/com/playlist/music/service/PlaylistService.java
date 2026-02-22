package com.playlist.music.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.playlist.music.entities.Playlist;
import com.playlist.music.entities.Usuario;
import com.playlist.music.repository.PlaylistRepository;
import com.playlist.music.repository.UsuarioRepository;

@Service
public class PlaylistService {

    private final PlaylistRepository repository;
    private final UsuarioRepository usuarioRepository;

    public PlaylistService(PlaylistRepository repository,
                           UsuarioRepository usuarioRepository) {
        this.repository = repository;
        this.usuarioRepository = usuarioRepository;
    }

    public List<Playlist> listar() {
        return repository.findAll();
    }

    public Playlist salvar(Playlist playlist) {

        if (playlist.getUsuario() == null ||
            playlist.getUsuario().getIdUsuario() == null) {
            throw new RuntimeException("Usuário é obrigatório");
        }

        Integer usuarioId = playlist.getUsuario().getIdUsuario();

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        playlist.setUsuario(usuario);

        return repository.save(playlist);
    }

    public Playlist buscarPorId(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Playlist não encontrado"));
    }
    
    public void deletar(Integer id) {
        repository.deleteById(id);
    }
}