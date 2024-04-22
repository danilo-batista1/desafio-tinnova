import { useState } from 'react';
import axios from 'axios';
import './index.css';
import { URI } from '../../enumerations/uri';
import { hover } from '@testing-library/user-event/dist/hover';
import Swal from 'sweetalert2';

function Formulario() {
    const [veiculo, setVeiculo] = useState('');
    const [marca, setMarca] = useState('');
    const [descricao, setDescricao] = useState('');
    const [ano, setAno] = useState('');
    const [cor, setCor] = useState('');
    const [vendido, setVendido] = useState('');

    const handleSubmit = async () => {

        if(veiculo.trim() === '' || marca.trim() === '' || descricao.trim() === '' || ano.trim() === '' || cor.trim() === '' || vendido.trim() === '') {
            Swal.fire("Por favor, preencher todos os campos do formulário.");
            return
        }

        try {
            const formData = { veiculo, marca, ano, cor, descricao, vendido: vendido === 'true' };
            await axios.post(URI.CRIAR_VEICULO, formData);
            setVeiculo('');
            setMarca('');
            setDescricao('');
            setAno('');
            setCor('');
            setVendido('');
            alert('Veiculo cadastrado com sucesso!');
            window.location.reload();
        } catch (error) {
            console.log('Erro ao cadastrar veiculo:', error);
            alert('Erro ao cadastrar veiculo. Por favor, tente novamente.');
        }
    };

    return (
        <div>
            <div className="titulo">
                <p>Gestão de Veiculos</p>
            </div>
            <div className="container-formulario">
                <div className="container-select-marca">
                    <select className="select-marca" required={true} value={marca} onChange={(e) => setMarca(e.target.value)}>
                        <option value="" disabled>Marca</option>
                        <option value="Volkswagen">Volkswagen</option>
                        <option value="Chevrolet">Chevrolet</option>
                        <option value="Audi">Ford</option>
                    </select>
                </div>
                <div className="container-input-veiculo">
                    <input required={true} type="text" placeholder="Veículo" value={veiculo} onChange={(e) => setVeiculo(e.target.value)} className="input-veiculo" />
                    <input required={true} type="text" placeholder="Cor" value={cor} onChange={(e) => setCor(e.target.value)} className="input-descricao" />
                    <input required={true} type="text" placeholder="Descrição" value={descricao} onChange={(e) => setDescricao(e.target.value)} className="input-descricao" />
                </div>
                <div className="input-row">
                    <input required={true} type="text" placeholder="Ano" value={ano} onChange={(e) => setAno(e.target.value)} className="input-ano" />

                    <select required={true} className="select-vendido" value={vendido} onChange={(e) => setVendido(e.target.value)}>
                        <option value="" disabled>Vendido</option>
                        <option value="true">Sim</option>
                        <option value="false">Não</option>
                    </select>
                </div>
                <div className="button-container">
                    <button style={{cursor: 'pointer', borderRadius: '5px'}} className="button" onClick={handleSubmit}>Cadastrar veículo</button>
                </div>
            </div>
        </div>
    );
}

export default Formulario;
