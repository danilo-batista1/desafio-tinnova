import VeiculoRegistradoSemana from "../components/VeiculoRegistradoSemana";
import DistribuicaoDecada from "../components/DistribuicaoDecada";
import Formulario from "../components/Formulario";
import Tabela from "../components/Tabela";

function Veiculo() {
  return ( 
    <div style={{ width: '80%', margin: '0 auto' }}> 
       <Formulario/>
      <div style={{ display: 'flex', justifyContent: 'space-between' }}>
        <div>
          <DistribuicaoDecada/>
        </div>
        <div style={{ marginRight: "10px", marginTop: "20px"}}>
          <VeiculoRegistradoSemana/>  
        </div>
      </div>
      <Tabela/>
    </div>
  );
}

export default Veiculo;
