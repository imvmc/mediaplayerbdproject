package com.playlist.music.entities;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "playlist")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idPlaylist;

    private String nomePlaylist;
    private LocalDate dataCriacao;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
    
    public Playlist () {}

	public Playlist(Integer idPlaylist, String nomePlaylist, LocalDate dataCriacao, Usuario usuario) {
		this.idPlaylist = idPlaylist;
		this.nomePlaylist = nomePlaylist;
		this.dataCriacao = dataCriacao;
		this.usuario = usuario;
	}

	public Integer getIdPlaylist() {
		return idPlaylist;
	}

	public void setIdPlaylist(Integer idPlaylist) {
		this.idPlaylist = idPlaylist;
	}

	public String getNomePlaylist() {
		return nomePlaylist;
	}

	public void setNomePlaylist(String nomePlaylist) {
		this.nomePlaylist = nomePlaylist;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(LocalDate dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	
    
    
    
    
    
}