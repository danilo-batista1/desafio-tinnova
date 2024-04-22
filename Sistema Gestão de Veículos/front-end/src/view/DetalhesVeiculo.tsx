import { useState, useEffect } from 'react';
import axios from 'axios';
import '../components/Formulario/index.css';
import { URI } from '../enumerations/uri';

function Editar() {
    const [veiculo, setVeiculo] = useState('');
    const [marca, setMarca] = useState('');
    const [descricao, setDescricao] = useState('');
    const [ano, setAno] = useState('');
    const [cor, setCor] = useState('');
    const [vendido, setVendido] = useState(true);

    const id = window.location.href.split("/")[4];

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await axios.get(`${URI.VEICULO_ESPECIFICA}${id}`);
                const veiculo = response.data;
                setVeiculo(veiculo.veiculo || '');
                setMarca(veiculo.marca || '');
                setDescricao(veiculo.descricao || '');
                setAno(veiculo.ano || '');
                setCor(veiculo.cor || '');
                setVendido(veiculo.vendido);


            } catch (error) {
                console.error('Erro ao obter detalhes do veiculo:', error);
            }
        };

        fetchData();
    }, [id])

    const handleSubmit = async () => {
        try {
            const formData = { veiculo, marca, descricao, ano, cor, vendido };
            await axios.put(`${URI.ALTERA_VEICULO}${id}`, formData);
            alert('Veiculo atualizado com sucesso!');
            window.location.assign("/");

        } catch (error) {
            console.error('Erro ao atualizar veiculo:', error);
            alert('Erro ao atualizar veiculo. Por favor, tente novamente.');
        }
    };

    const handleVoltar = async () => {
            window.location.assign("/");
    };

    return (
        <div style={{ width: '80%', margin: '0 auto' }}>
            <div className="titulo">
                <p>Editar Veiculo</p>
            </div>
            <div className="container-formulario">
                <div className="container-select-marca">
                    <select className="select-marca" value={marca} onChange={(e) => setMarca(e.target.value)}>
                        <option value="" disabled>Marca</option>
                        <option value="Ford">Ford</option>
                        <option value="Volkswagen">Volkswagen</option>
                        <option value="Chevrolet">Chevrolet</option>
                    </select>
                </div>
                <div className="container-input-veiculo">
                    <input type="text" placeholder="Veiculo" value={veiculo} onChange={(e) => setVeiculo(e.target.value)} className="input-veiculo" />
                    <input type="text" placeholder="Descricao" value={descricao} onChange={(e) => setDescricao(e.target.value)} className="input-veiculo" />
                </div>
                <div className="input-row">
                    <input type="text" placeholder="Ano" value={ano} onChange={(e) => setAno(e.target.value)} className="input-ano" />
                    <select className="select-vendido" value={vendido ? 'true' : 'false'} onChange={(e) => setVendido(e.target.value === 'true')}>
                        <option value="" disabled>Vendido</option>
                        <option value="true">Sim</option>
                        <option value="false">Não</option>
                    </select>
                </div>
                <div className="button-containerEditar ">
                    <button style={{cursor: 'pointer'}} className="button" onClick={handleVoltar}>Voltar</button>
                    <button style={{cursor: 'pointer'}} className="button" onClick={handleSubmit}>Editar</button>
                </div>
            </div>
        </div>
    );
}

export default Editar;
