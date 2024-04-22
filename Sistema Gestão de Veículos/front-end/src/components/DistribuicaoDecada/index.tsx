import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './index.css';
import { URI } from '../../enumerations/uri';

interface DecadaDistribuicao {
    decade: number;
    quantity: number;
}

function DistribuicaoDecada() {
    const [distribuicao, setDistribuicao] = useState<DecadaDistribuicao[]>([]);

    useEffect(() => {
        fetchDistribuicaoPorDecada();
    }, []);

    const fetchDistribuicaoPorDecada = async () => {
        try {
            const response = await axios.get<DecadaDistribuicao[]>(`${URI.VEICULO_DECADA}`);
            setDistribuicao(response.data); 
        } catch (error) {
            console.log(error);
        }
    };
console.log(distribuicao);

    return (
        <div>
            <ul style={{ listStyleType: 'none' }}>
                {distribuicao.map((item, index) => (
                    <li key={index} className="distribuicaoDecada">{`${item.decade}: ${item.quantity} veículos`}</li>
                ))}
            </ul>
        </div>
    );
}

export default DistribuicaoDecada;
