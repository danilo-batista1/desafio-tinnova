import React, { useEffect, useState } from 'react';
import axios from 'axios';
import './index.css'; 
import { URI } from '../../enumerations/uri';

function VeiculoRegistradoSemana() {
    const [quantidade, setQuantidade] = useState(0);

    useEffect(() => {
        fetchQuantidadeRegistros();
    }, []);

    const fetchQuantidadeRegistros = async () => {
        try {
            const response = await axios.get(`${URI.VEICULO_SEMANA}`);
            setQuantidade(response.data);
        } catch (error) {
            console.log(error);
        }
    };
console.log(quantidade);

    return (
        <div >
            <p className="veiculoRegistradoSemana">{`Essa semana: ${quantidade}`}</p>
        </div>
    );
}

export default VeiculoRegistradoSemana;
