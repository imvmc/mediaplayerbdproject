import { useEffect, useState } from "react";
import api from "../services/api";

export default function Usuarios() {
  const [usuarios, setUsuarios] = useState([]);
  const [nome, setNome] = useState("");

  useEffect(() => {
    listar();
  }, []);

  function listar() {
    api.get("/usuarios").then(res => setUsuarios(res.data));
  }

  function salvar() {
    api.post("/usuarios", { nome }).then(() => {
      setNome("");
      listar();
    });
  }

  function excluir(id) {
    api.delete(`/usuarios/${id}`).then(listar);
  }

  return (
    <div>
      <h1>Usuários</h1>

      <input
        placeholder="Nome"
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
          {usuarios.map(u => (
            <tr key={u.id}>
              <td>{u.id}</td>
              <td>{u.nome}</td>
              <td>
                <button onClick={() => excluir(u.id)}>Excluir</button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}