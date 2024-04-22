package com.tinnova.desafio.controller;

import com.tinnova.desafio.dto.veiculo.VeiculoRequestDTO;
import com.tinnova.desafio.dto.veiculo.VeiculoResponseDTO;
import com.tinnova.desafio.exception.ErrorMessage;
import com.tinnova.desafio.model.Veiculo;
import com.tinnova.desafio.repository.projection.TotalBrandProjection;
import com.tinnova.desafio.repository.projection.TotalCarsDecadeProjection;
import com.tinnova.desafio.service.VeiculoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Tag(name = "Veiculos",description = "Contem todas operações relacionadas ao controle de veículo")
@RestController
@RequestMapping(value = "/veiculos")
@CrossOrigin
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @Autowired
    private ModelMapper modelMapper;

    @Operation(
            summary = "Este método cadastra um novo veículo",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Veículo encontrado com sucesso!",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(
                                            implementation = VeiculoResponseDTO.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Veículo não encontrado!",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(
                                            implementation = ErrorMessage.class
                                    )
                            )
                    )
            }
    )
    @PostMapping
    public ResponseEntity<VeiculoResponseDTO> cadastrarNovoVeiculo(@RequestBody VeiculoRequestDTO veiculoRequestDTO) {
        Veiculo veiculo = modelMapper.map(veiculoRequestDTO, Veiculo.class);
        VeiculoResponseDTO response = modelMapper.map(veiculoService.cadastrarNovoVeiculo(veiculo), VeiculoResponseDTO.class);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(
            summary = "Este método atualiza apenas um parametro no veículo através do ID",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Veículo encontrado com sucesso!",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(
                                            implementation = VeiculoResponseDTO.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Veículo não encontrado!",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(
                                            implementation = ErrorMessage.class
                                    )
                            )
                    )
            }
    )
    @PatchMapping("/{Id}")
    public ResponseEntity<VeiculoResponseDTO> atualizarDadosVeiculoPorId(@PathVariable("Id") Long id, @RequestBody VeiculoRequestDTO veiculoRequestDTO) {
        Veiculo dadosVeiculoAtualizado = veiculoService.atualizarDadosVeiculoPorId(id, modelMapper.map(veiculoRequestDTO, Veiculo.class));
        VeiculoResponseDTO response = modelMapper.map(dadosVeiculoAtualizado, VeiculoResponseDTO.class);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(
            summary = "Este método atualiza dados do veículo através do ID",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Veículo encontrado com sucesso!",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(
                                            implementation = VeiculoResponseDTO.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Veículo não encontrado!",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(
                                            implementation = ErrorMessage.class
                                    )
                            )
                    )
            }
    )
    @PutMapping("/{Id}")
    public ResponseEntity<VeiculoResponseDTO> atualizarDadosVeiculo(@PathVariable("Id") Long id, @RequestBody VeiculoRequestDTO veiculoRequestDTO) {
        Veiculo veiculoAtualizado = veiculoService.atualizarDadosVeiculo(id, modelMapper.map(veiculoRequestDTO, Veiculo.class));
        VeiculoResponseDTO response = modelMapper.map(veiculoAtualizado, VeiculoResponseDTO.class);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(
            summary = "Este método busca o veículo através do ID",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Veículo encontrado com sucesso!",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(
                                            implementation = VeiculoResponseDTO.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Veículo não encontrado!",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(
                                            implementation = ErrorMessage.class
                                    )
                            )
                    )
            }
    )
    @GetMapping("/{Id}")
    public ResponseEntity<VeiculoResponseDTO> buscarVeiculoPorId(@PathVariable("Id") Long id) {
        Veiculo veiculo = veiculoService.buscarVeiculoPorId(id);
        VeiculoResponseDTO response = modelMapper.map(veiculo, VeiculoResponseDTO.class);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(
            summary = "Este método busca pelo total de veículos e também através da marca, ano e cor",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Veículo encontrado com sucesso!",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(
                                            implementation = VeiculoResponseDTO.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Veículo não encontrado!",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(
                                            implementation = ErrorMessage.class
                                    )
                            )
                    )
            }
    )
    @GetMapping
    public ResponseEntity<List<VeiculoResponseDTO>> buscarPorMarcaAnoCor(@RequestParam(value = "marca", required = false) String marca,
                                                         @RequestParam(value = "ano", required = false) Integer ano,
                                                         @RequestParam(value = "cor", required = false) String cor) {

       if (marca == null && ano == null && cor == null) {
            List<Veiculo> veiculos = veiculoService.buscarTodosVeiculos();
            List<VeiculoResponseDTO> response = toVeiculoResponseDtoList(veiculos);

           return ResponseEntity.status(HttpStatus.OK).body(response);
        }

            List<Veiculo> veiculos = veiculoService.buscarPorMarcaAnoCor(marca, ano, cor);
            List<VeiculoResponseDTO> response = toVeiculoResponseDtoList(veiculos);

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @Operation(
            summary = "Este método busca pelo total de veículos não vendidos",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Veículo encontrado com sucesso!",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(
                                            implementation = VeiculoResponseDTO.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Veículo não encontrado!",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(
                                            implementation = ErrorMessage.class
                                    )
                            )
                    )
            }
    )
    @GetMapping("/total-unsold-cars")
    public ResponseEntity<Long> buscarTotalVeiculosNaoVendidos() {
        return ResponseEntity.status(HttpStatus.OK).body(veiculoService.buscarTotalVeiculosNaoVendidos());
    }

    @Operation(
            summary = "Este método busca pelo total de veículos vendidos na última década",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Veículo encontrado com sucesso!",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(
                                            implementation = VeiculoResponseDTO.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Veículo não encontrado!",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(
                                            implementation = ErrorMessage.class
                                    )
                            )
                    )
            }
    )
    @GetMapping("/total-cars-decades")
    public ResponseEntity<List<TotalCarsDecadeProjection>> findCarsByDecade() {
        return ResponseEntity.status(HttpStatus.OK).body(veiculoService.findCarsByDecade());
    }

    @Operation(
            summary = "Este método busca pelo total de veículos através da marca",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Veículo encontrado com sucesso!",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(
                                            implementation = VeiculoResponseDTO.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Veículo não encontrado!",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(
                                            implementation = ErrorMessage.class
                                    )
                            )
                    )
            }
    )
    @GetMapping("/total-cars-brand")
    public ResponseEntity<List<TotalBrandProjection>> totalCarsByBrand() {
        return ResponseEntity.status(HttpStatus.OK).body(veiculoService.totalCarsByBrand());
    }

    @Operation(
            summary = "Este método busca pelo total de veículos da última semana",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Veículo encontrado com sucesso!",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(
                                            implementation = VeiculoResponseDTO.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Veículo não encontrado!",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(
                                            implementation = ErrorMessage.class
                                    )
                            )
                    )
            }
    )
    @GetMapping("/total-last-week")
    public ResponseEntity<Long> totalLast7days() {
        return ResponseEntity.status(HttpStatus.OK).body(veiculoService.totalLast7days());
    }

    @Operation(
            summary = "Este método deleta o veículo através do ID",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Veículo encontrado com sucesso!",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(
                                            implementation = VeiculoResponseDTO.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Veículo não encontrado!",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(
                                            implementation = ErrorMessage.class
                                    )
                            )
                    )
            }
    )
    @DeleteMapping("/{Id}")
    public ResponseEntity<Void> deleteVeiculoPorId(@PathVariable("Id") Long id) {
        veiculoService.deleteVeiculoPorId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @Operation(
            summary = "Este método converte uma lista de objetos do tipo Veiculo em uma lista de objetos do tipo VeiculoResponseDTO.",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Veículo encontrado com sucesso!",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(
                                            implementation = VeiculoResponseDTO.class
                                    )
                            )
                    ),
                    @ApiResponse(
                            responseCode = "404",
                            description = "Veículo não encontrado!",
                            content = @Content(
                                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                                    schema = @Schema(
                                            implementation = ErrorMessage.class
                                    )
                            )
                    )
            }
    )
    private List<VeiculoResponseDTO> toVeiculoResponseDtoList(List<Veiculo> veiculos) {
        return veiculos.stream().map(veiculo -> modelMapper.map(veiculo, VeiculoResponseDTO.class))
                .collect(Collectors.toList());
    }

}
