package com.playlist.music.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "musica")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Musica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMusica;

    private String titulo;
    private Integer duracao;
    private String urlMusica;

    @ManyToOne
    @JoinColumn(name = "id_album")
    private Album album;
    
    public Musica () {}

	public Musica(Integer idMusica, String titulo, Integer duracao, String urlMusica, Album album) {
		this.idMusica = idMusica;
		this.titulo = titulo;
		this.duracao = duracao;
		this.urlMusica = urlMusica;
		this.album = album;
	}

	public Integer getIdMusica() {
		return idMusica;
	}

	public void setIdMusica(Integer idMusica) {
		this.idMusica = idMusica;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Integer getDuracao() {
		return duracao;
	}

	public void setDuracao(Integer duracao) {
		this.duracao = duracao;
	}

	public String getUrlMusica() {
		return urlMusica;
	}

	public void setUrlMusica(String urlMusica) {
		this.urlMusica = urlMusica;
	}

	public Album getAlbum() {
		return album;
	}

	public void setAlbum(Album album) {
		this.album = album;
	}
	
	
    
    
}