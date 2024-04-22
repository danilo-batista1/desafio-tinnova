import { useEffect, useState } from 'react';
import axios from 'axios';
import { URI } from '../../enumerations/uri';
import { Veiculos } from '../../types/veiculo';

function Marcas() {
    const [veiculos, setVeiculos] = useState([]);

    useEffect(() => {
        fetchVeiculos();
    }, []);

    const fetchVeiculos = async () => {
        try {
            const response = await axios.get(`${URI.LISTAR_VEICULO}`);
            setVeiculos(response.data);
        } catch (error) {
            console.log(error);
        }
    };

    const contarVeiculosPorFabricante = (veiculos: Veiculos[]) => {
        const contagem: { [marca: string]: number } = {};

        veiculos.forEach(veiculo => {
            const marca = veiculo.marca;

            if (contagem[marca]) {
                contagem[marca]++;
            } else {
                contagem[marca] = 1;
            }
        });

        return contagem;
    }
    const contagemPorFabricante = contarVeiculosPorFabricante(veiculos);

    return (
        <div>
            <ul style={{ listStyleType: 'none', fontFamily: 'Arial, Helvetica, sans-serif' }}>
                {Object.entries(contagemPorFabricante).map(([marca, quantidade]) => (
                    <li key={marca}>{marca} - {quantidade} veiculos</li>
                ))}
            </ul>
        </div>
    );
}

export default Marcas;