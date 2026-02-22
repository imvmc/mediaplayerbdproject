package com.playlist.music.entities;

import java.time.LocalDate;
import jakarta.persistence.*;

@Entity
@Table(name = "playlist_musica")
public class PlaylistMusica {

    @EmbeddedId
    private PlaylistMusicaId id;

    @ManyToOne
    @MapsId("idPlaylist")
    @JoinColumn(name = "id_playlist")
    private Playlist playlist;

    @ManyToOne
    @MapsId("idMusica")
    @JoinColumn(name = "id_musica")
    private Musica musica;

    @Column(name = "data_adicao", nullable = false)
    private LocalDate dataAdicao;

    public PlaylistMusica() {}

	public PlaylistMusica(PlaylistMusicaId id, Playlist playlist, Musica musica, LocalDate dataAdicao) {
		this.id = id;
		this.playlist = playlist;
		this.musica = musica;
		this.dataAdicao = dataAdicao;
	}

	public PlaylistMusicaId getId() {
		return id;
	}

	public void setId(PlaylistMusicaId id) {
		this.id = id;
	}

	public Playlist getPlaylist() {
		return playlist;
	}

	public void setPlaylist(Playlist playlist) {
		this.playlist = playlist;
	}

	public Musica getMusica() {
		return musica;
	}

	public void setMusica(Musica musica) {
		this.musica = musica;
	}

	public LocalDate getDataAdicao() {
		return dataAdicao;
	}

	public void setDataAdicao(LocalDate dataAdicao) {
		this.dataAdicao = dataAdicao;
	}
	

    
}