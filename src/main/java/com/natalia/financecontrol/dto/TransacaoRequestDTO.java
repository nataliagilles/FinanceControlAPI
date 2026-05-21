package com.natalia.financecontrol.dto;

import com.natalia.financecontrol.entity.TipoTransacao;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class TransacaoRequestDTO {

    @NotBlank(message = "A descrição é obrigatória")
    private String descricao;
    @NotNull(message = "O valor é obrigatório")
    @Positive(message = "O valor deve ser maior que zero")
    private BigDecimal valor;
    @NotNull(message = "O tipo da transação é obrigatório")
    private TipoTransacao tipo;
    @NotNull(message = "A data é obrigatória")
    private LocalDate data;
    @NotNull(message = "A categoria é obrigatória")
    private Long categoriaId;

}