import { Route, Routes } from "react-router-dom";
import Veiculo from "./view/Veiculo";
import DetalhesVeiculo from "./view/DetalhesVeiculo";

function Rotas(){
    return(
   
        <Routes>
            <Route path="/" element={<Veiculo />} />   
            <Route path="/veiculos/:uuid" element={<DetalhesVeiculo />} />   
        </Routes>
    )
}

export default Rotas