package com.playlist.music.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "historico_reproducao")
public class HistoricoReproducao {

    @EmbeddedId
    private HistoricoReproducaoId id;

    @ManyToOne
    @MapsId("idUsuario")
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @MapsId("idMusica")
    @JoinColumn(name = "id_musica")
    private Musica musica;

    public HistoricoReproducao() {}

	public HistoricoReproducao(HistoricoReproducaoId id, Usuario usuario, Musica musica) {
		this.id = id;
		this.usuario = usuario;
		this.musica = musica;
	}

	public HistoricoReproducaoId getId() {
		return id;
	}

	public void setId(HistoricoReproducaoId id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Musica getMusica() {
		return musica;
	}

	public void setMusica(Musica musica) {
		this.musica = musica;
	}

    
}