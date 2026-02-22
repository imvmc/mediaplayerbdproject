package com.playlist.music.entities;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Embeddable;

@Embeddable
public class PlaylistMusicaId implements Serializable {

    private Integer idPlaylist;
    private Integer idMusica;

    public PlaylistMusicaId() {}

    public PlaylistMusicaId(Integer idPlaylist, Integer idMusica) {
        this.idPlaylist = idPlaylist;
        this.idMusica = idMusica;
    }

    

    public Integer getIdPlaylist() {
		return idPlaylist;
	}

	public void setIdPlaylist(Integer idPlaylist) {
		this.idPlaylist = idPlaylist;
	}

	public Integer getIdMusica() {
		return idMusica;
	}

	public void setIdMusica(Integer idMusica) {
		this.idMusica = idMusica;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlaylistMusicaId)) return false;
        PlaylistMusicaId that = (PlaylistMusicaId) o;
        return Objects.equals(idPlaylist, that.idPlaylist) &&
               Objects.equals(idMusica, that.idMusica);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPlaylist, idMusica);
    }
}