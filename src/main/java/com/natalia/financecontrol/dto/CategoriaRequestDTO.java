package com.natalia.financecontrol.dto;

import com.natalia.financecontrol.entity.TipoTransacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class CategoriaRequestDTO {
    @NotBlank(message = "O nome da categoria é obrigatório")
    @Size(min = 3, max = 100, message = "Nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @Size(max = 255, message = "Descrição deve ter no máximo 255 caracteres")
    private String descricao;

    @NotNull(message = "O tipo da categoria é obrigatório")
    private TipoTransacao tipo;
}
