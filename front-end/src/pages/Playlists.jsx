import { useEffect, useState } from "react";
import api from "../services/api";

export default function Playlists() {
  const [playlists, setPlaylists] = useState([]);
  const [nome, setNome] = useState("");
  const [usuarioId, setUsuarioId] = useState("");

  useEffect(() => {
    listar();
  }, []);

  function listar() {
    api.get("/playlists").then(res => setPlaylists(res.data));
  }

  function salvar() {
    api.post("/playlists", {
      nome,
      usuario: { id: usuarioId }
    }).then(() => {
      setNome("");
      setUsuarioId("");
      listar();
    });
  }

  function excluir(id) {
    api.delete(`/playlists/${id}`).then(listar);
  }

  return (
    <div>
      <h1>Playlists</h1>

      <input
        placeholder="Nome da playlist"
        value={nome}
        onChange={e => setNome(e.target.value)}
      />

      <input
        placeholder="ID do usuário"
        value={usuarioId}
        onChange={e => setUsuarioId(e.target.value)}
      />

      <button onClick={salvar}>Salvar</button>

      <table border="1" width="100%" style={{ marginTop: 20 }}>
        <thead>
          <tr>
            <th>ID</th>
            <th>Nome</th>
            <th>Ações</th>
          </tr>
        </thead>
        <tbody>
          {playlists.map(p => (
            <tr key={p.id}>
              <td>{p.id}</td>
              <td>{p.nome}</td>
              <td>
                <button onClick={() => excluir(p.id)}>Excluir</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}