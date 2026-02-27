import { useEffect, useState } from "react";
import api from "../services/api";

export default function Artistas() {
  const [artistas, setArtistas] = useState([]);
  const [nome, setNome] = useState("");

  useEffect(() => {
    listar();
  }, []);

  function listar() {
    api.get("/artistas").then(res => setArtistas(res.data));
  }

  function salvar() {
    api.post("/artistas", { nome }).then(() => {
      setNome("");
      listar();
    });
  }

  function excluir(id) {
    api.delete(`/artistas/${id}`).then(listar);
  }

  return (
    <div>
      <h1>Artistas</h1>

      <input
        placeholder="Nome do artista"
        value={nome}
        onChange={e => setNome(e.target.value)}
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
          {artistas.map(a => (
            <tr key={a.id}>
              <td>{a.id}</td>
              <td>{a.nome}</td>
              <td>
                <button onClick={() => excluir(a.id)}>Excluir</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}