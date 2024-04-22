package com.tinnova.desafio.dto.veiculo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class VeiculoResponseDTO {

    private Long id;

    private String veiculo;

    private String marca;

    private Integer ano;

    private String cor;

    private String descricao;

    private Boolean vendido;
}
