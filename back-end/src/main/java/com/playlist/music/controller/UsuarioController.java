package com.playlist.music.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import com.playlist.music.entities.Usuario;
import com.playlist.music.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private UsuarioService service;
    
    public UsuarioController(UsuarioService service) {
        this.service = service;
    }
    @GetMapping
    public List<Usuario> listar() {
        return service.listar();
    }

    @PostMapping
    public Usuario salvar(@RequestBody Usuario usuario) {
        return service.salvar(usuario);
    }
    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Integer id,
                             @RequestBody Usuario usuario) {

        Usuario existente = service.buscarPorId(id);

        existente.setNome(usuario.getNome());
        existente.setEmail(usuario.getEmail());
        existente.setSenha(usuario.getSenha());

        return service.salvar(existente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Integer id) {
        service.deletar(id);
    }
}