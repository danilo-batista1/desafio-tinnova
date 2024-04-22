package com.tinnova.desafio.service;

import com.tinnova.desafio.dto.veiculo.VeiculoRequestDTO;
import com.tinnova.desafio.model.Veiculo;
import com.tinnova.desafio.repository.projection.TotalBrandProjection;
import com.tinnova.desafio.repository.projection.TotalCarsDecadeProjection;

import java.util.List;

public interface VeiculoService {

    Veiculo cadastrarNovoVeiculo(Veiculo veiculo);

    List<Veiculo> buscarTodosVeiculos();

    Veiculo buscarVeiculoPorId(Long Id);

    List<Veiculo> buscarPorMarcaAnoCor(String marca, Integer ano, String cor);

    void deleteVeiculoPorId(Long Id);

    Veiculo atualizarDadosVeiculo(Long Id, Veiculo veiculo);

    Veiculo atualizarDadosVeiculoPorId(Long Id, Veiculo veiculo);

    Long buscarTotalVeiculosNaoVendidos();

    List<TotalCarsDecadeProjection> findCarsByDecade();

    List<TotalBrandProjection> totalCarsByBrand();

    Long totalLast7days();

}
