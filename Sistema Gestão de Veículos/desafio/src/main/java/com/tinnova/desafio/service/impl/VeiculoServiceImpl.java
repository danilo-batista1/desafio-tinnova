package com.tinnova.desafio.service.impl;

import com.tinnova.desafio.dto.veiculo.VeiculoRequestDTO;
import com.tinnova.desafio.exception.BusinessException;
import com.tinnova.desafio.model.Veiculo;
import com.tinnova.desafio.repository.VeiculoRepository;
import com.tinnova.desafio.repository.projection.TotalBrandProjection;
import com.tinnova.desafio.repository.projection.TotalCarsDecadeProjection;
import com.tinnova.desafio.service.VeiculoService;
import jakarta.persistence.Id;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VeiculoServiceImpl implements VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Transactional(readOnly = false)
    public Veiculo cadastrarNovoVeiculo(Veiculo veiculo) {
        return veiculoRepository.save(veiculo);
    }

    @Transactional
    public Veiculo atualizarDadosVeiculo(Long id, Veiculo veiculo) {
        findVeiculoById(id);
        veiculo.setId(id);

        return veiculoRepository.save(veiculo);
    }

    @Transactional
    public Veiculo atualizarDadosVeiculoPorId(Long id, Veiculo veiculo) {
        Veiculo veiculoEncontrado = findVeiculoById(id);

        modelMapper.getConfiguration().setPropertyCondition(c -> c.getSource() != null);
        modelMapper.map(veiculo, veiculoEncontrado);

        return veiculoRepository.save(veiculoEncontrado);
    }

    @Transactional(readOnly = true)
    public List<Veiculo> buscarTodosVeiculos() {
        return veiculoRepository.findAll();
    }

    @Transactional(readOnly = true)
    @Override
    public Veiculo buscarVeiculoPorId(Long Id) {
        return findVeiculoById(Id);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Veiculo> buscarPorMarcaAnoCor(String marca, Integer ano, String cor) {

        return veiculoRepository.findByMarcaAnoCor(marca, ano, cor);
    }

    @Transactional(readOnly = false)
    @Override
    public void deleteVeiculoPorId(Long Id) {
        Veiculo veiculoEncontrado = findVeiculoById(Id);

        veiculoRepository.delete(veiculoEncontrado);
    }

    @Transactional(readOnly = true)
    @Override
    public Long buscarTotalVeiculosNaoVendidos() {
        return veiculoRepository.totalUnsoldCars();
    }

    @Transactional(readOnly = true)
    @Override
    public List<TotalCarsDecadeProjection> findCarsByDecade() {
        return veiculoRepository.findCarsByDecade();
    }

    @Transactional(readOnly = true)
    @Override
    public List<TotalBrandProjection> totalCarsByBrand() {
        return veiculoRepository.totalCarsByBrand();
    }

    @Transactional(readOnly = true)
    @Override
    public Long totalLast7days() {
        return veiculoRepository.totalLast7days();
    }

    @Transactional(readOnly = true)
    private Veiculo findVeiculoById(Long Id) {

        return veiculoRepository.findById(Id)
                .orElseThrow(() -> new BusinessException("Veículo não encontrado com ID: " + Id));
    }

}
