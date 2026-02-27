import { useEffect, useState } from "react";
import api from "../services/api";

export default function Relatorios() {
  const [usuarios, setUsuarios] = useState([]);
  const [playlists, setPlaylists] = useState([]);
  const [ranking, setRanking] = useState([]);

  useEffect(() => {
    api.get("/relatorios/usuarios-dia").then(r => setUsuarios(r.data));
    api.get("/relatorios/playlists").then(r => setPlaylists(r.data));
    api.get("/relatorios/ranking-artistas").then(r => setRanking(r.data));
  }, []);

  return (
    <div>
      <h1>📊 Relatórios do Sistema</h1>

      <h2>📅 Execução diária por usuário</h2>
      <Tabela dados={usuarios} colunas={[
        "usuario","dia","total_reproducoes","musicas_distintas","total_minutos"
      ]} />

      <h2>🎼 Desempenho das playlists</h2>
      <Tabela dados={playlists} colunas={[
        "nome_playlist","dono_playlist","total_musicas","duracao_total_minutos"
      ]} />

      <h2>🏆 Ranking global de artistas</h2>
      <Tabela dados={ranking} colunas={[
        "artista","total_reproducoes","usuarios_unicos"
      ]} />
    </div>
  );
}

function Tabela({ dados, colunas }) {
  return (
    <table border="1" width="100%" cellPadding="6" style={{ marginBottom: 30 }}>
      <thead>
        <tr>
          {colunas.map(c => <th key={c}>{c}</th>)}
        </tr>
      </thead>
      <tbody>
        {dados.map((d, i) => (
          <tr key={i}>
            {colunas.map(c => <td key={c}>{d[c]}</td>)}
          </tr>
        ))}
      </tbody>
    </table>
  );
}