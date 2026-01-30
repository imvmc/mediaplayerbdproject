CREATE TABLE ARTISTA (
  id_artista INT PRIMARY KEY,
  nome VARCHAR(100) NOT NULL
);

CREATE TABLE ALBUM (
  id_album INT PRIMARY KEY,
  titulo VARCHAR(100) NOT NULL,
  ano_lancamento INT NOT NULL,
  genero VARCHAR(50) NOT NULL,
  id_artista INT NOT NULL,
  FOREIGN KEY (id_artista) REFERENCES ARTISTA(id_artista)
);

CREATE TABLE MUSICA (
  id_musica INT PRIMARY KEY,
  titulo VARCHAR(100) NOT NULL,
  duracao INT NOT NULL,
  url_musica VARCHAR(255) NOT NULL,
  id_album INT NOT NULL,
  FOREIGN KEY (id_album) REFERENCES ALBUM(id_album)
);

CREATE TABLE USUARIO (
  id_usuario INT PRIMARY KEY,
  nome VARCHAR(100) NOT NULL,
  email VARCHAR(100) UNIQUE NOT NULL,
  senha VARCHAR(255) NOT NULL
);

CREATE TABLE PLAYLIST (
  id_playlist INT PRIMARY KEY,
  nome_playlist VARCHAR(100) NOT NULL,
  data_criacao DATE DEFAULT CURRENT_DATE,
  id_usuario INT NOT NULL,
  FOREIGN KEY (id_usuario) REFERENCES USUARIO(id_usuario)
);

CREATE TABLE PLAYLIST_MUSICA (
  id_playlist INT NOT NULL,
  id_musica INT NOT NULL,
  data_adicao DATE NOT NULL,
  PRIMARY KEY (id_playlist, id_musica),
  FOREIGN KEY (id_playlist) REFERENCES PLAYLIST(id_playlist),
  FOREIGN KEY (id_musica) REFERENCES MUSICA(id_musica)
);

CREATE TABLE HISTORICO_REPRODUCAO (
  id_usuario INT NOT NULL,
  id_musica INT NOT NULL,
  data_hora_reproducao DATETIME NOT NULL,
  PRIMARY KEY (id_usuario, id_musica, data_hora_reproducao),
  FOREIGN KEY (id_usuario) REFERENCES USUARIO(id_usuario),
  FOREIGN KEY (id_musica) REFERENCES MUSICA(id_musica)
);

INSERT INTO ARTISTA VALUES (1, 'Coldplay');

INSERT INTO ALBUM VALUES (1, 'Parachutes', 2000, 'Rock', 1);

INSERT INTO MUSICA VALUES
(1, 'Yellow', 260, 'http://musica/yellow', 1),
(2, 'Trouble', 270, 'http://musica/trouble', 1);

INSERT INTO USUARIO VALUES
(1, 'Yasmin', 'yasmin@email.com', 'hash123');

INSERT INTO PLAYLIST VALUES
(1, 'Favoritas', CURRENT_DATE, 1);

INSERT INTO PLAYLIST_MUSICA VALUES
(1, 1, CURRENT_DATE),
(1, 2, CURRENT_DATE);

INSERT INTO HISTORICO_REPRODUCAO VALUES
(1, 1, NOW()),
(1, 1, NOW()),
(1, 2, NOW());
