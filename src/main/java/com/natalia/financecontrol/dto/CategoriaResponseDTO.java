package com.natalia.financecontrol.dto;

import com.natalia.financecontrol.entity.TipoTransacao;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaResponseDTO {

    private Long id;
    private String nome;
    private String descricao;
    private TipoTransacao tipo;
}