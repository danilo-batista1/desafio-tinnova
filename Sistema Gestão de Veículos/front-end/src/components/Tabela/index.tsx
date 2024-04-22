import { useEffect, useState } from 'react';
import axios from 'axios';
import './index.css'; 
import { URI } from '../../enumerations/uri';
import { Veiculos } from "../../types/veiculo";
import Marcas from "../Marcas/index";
import { Link } from 'react-router-dom'; 
import { FaEdit , FaTrashAlt  } from 'react-icons/fa';
import { BsTrash } from 'react-icons/bs';
import Swal, { SweetAlertResult } from 'sweetalert2';

function Tabela() {
  const [veiculos, setVeiculos] = useState<Veiculos[]>([]);
  const [marcaPesquisa, setMarcaPesquisa] = useState('');
  const [anoPesquisa, setAnoPesquisa] = useState('');
  const [corPesquisa, setCorPesquisa] = useState('');
  const Swal = require('sweetalert2');

  useEffect(() => {
    fetchVeiculos();
  }, []);

  const fetchVeiculos = async () => {
    try {
      const response = await axios.get(URI.LISTAR_VEICULO);
      setVeiculos(response.data);
    } catch (error) {
      console.log(error);
    }
  };

  const handlePesquisa = async () => {
    try {
      const response = await axios.get('http://localhost:8080/veiculos', {
        params: {
          marca: marcaPesquisa,
          ano: anoPesquisa,
          cor: corPesquisa
        }
      });
      const veiculos = response.data;
      setVeiculos(veiculos);

    } catch (error) {
      console.error('Erro ao buscar veículos:', error);
    }
  };

  async function avisoDeletar(): Promise<SweetAlertResult> {
    return Swal.fire({
      title: "Deletar veículo",
      text: "Esta ação não pode ser revertida",
      icon: "warning",
      showCancelButton: true,
      confirmButtonColor: "#3085d6",
      cancelButtonColor: "#d33",
      confirmButtonText: "Sim, deletar",
      cancelButtonText: "Cancelar",
    });
  }

  const handleExcluirVeiculo = async (id: number) => {
    const resultado = await avisoDeletar()
    if (resultado.isConfirmed) {
        try {
        await axios.delete(`${URI.DELETE_VEICULO}${id}`);
        setVeiculos(veiculos.filter((veiculo) => veiculo.id !== id));
        window.location.reload();
      } catch (error) {
        console.log(error);
      }
    }
  };

  return (
    <div>
      <div>
        <input
          style={{marginRight: '5px'}}
          type="text"
          placeholder="Pesquisa por marca"
          name="Pesquisa"
          value={marcaPesquisa}
          onChange={(e) => setMarcaPesquisa(e.target.value)}
        />
   
        <input
          style={{marginRight: '5px'}}
          type="text"
          placeholder="Pesquisa por ano"
          name="Pesquisa"
          value={anoPesquisa}
          onChange={(e) => setAnoPesquisa(e.target.value)}
        />

        <input
          style={{marginRight: '5px'}}
          type="text"
          placeholder="Pesquisa por cor"
          name="Pesquisa"
          value={corPesquisa}
          onChange={(e) => setCorPesquisa(e.target.value)}
        />
        <button style={{cursor: 'pointer', borderRadius: '5px'}} onClick={handlePesquisa}>Pesquisar</button>
      </div>
    
      <table className="tabela">
        <thead>
          <tr>
            <th>ID</th>
            <th>Marca</th>
            <th>Modelo</th>
            <th>Ano</th>
            <th>Cor</th>
            <th>Descrição</th>
            <th>Vendido</th>
            <th>Editar</th>
            <th>Excluir</th>
          </tr>
        </thead>
        <tbody>
          {veiculos.map(veiculo => (
            <tr key={veiculo.id}>
              <td>{veiculo.id}</td>
              <td>{veiculo.marca}</td>
              <td>{veiculo.veiculo}</td>
              <td>{veiculo.ano}</td>
              <td>{veiculo.cor}</td>
              <td>{veiculo.descricao}</td>
              <td>{veiculo.vendido ? 'Sim' : 'Não'}</td>
              <td><Link to={`/veiculos/${veiculo.id}`}><FaEdit  className="icone"/></Link></td>
              <td><button style={{background: 'none', border: 'none', cursor: 'pointer'}} onClick={() => handleExcluirVeiculo(veiculo.id)}><FaTrashAlt  className="icone"/></button></td>
            </tr>
          ))}
        </tbody>
      </table>

      <Marcas />
    </div>
  );
}

export default Tabela;
