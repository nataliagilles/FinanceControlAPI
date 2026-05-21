package com.natalia.financecontrol.dto;

import com.natalia.financecontrol.entity.TipoTransacao;
import java.math.BigDecimal;
import java.time.LocalDate;

public class TransacaoResponseDTO {

    private Long id;
    private String descricao;
    private BigDecimal valor;
    private TipoTransacao tipo;
    private LocalDate data;
    private String categoriaNome;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public BigDecimal getValor() { return valor; }
    public void setValor(BigDecimal valor) { this.valor = valor; }

    public TipoTransacao getTipo() { return tipo; }
    public void setTipo(TipoTransacao tipo) { this.tipo = tipo; }

    public LocalDate getData() { return data; }
    public void setData(LocalDate data) { this.data = data; }

    public String getCategoriaNome() { return categoriaNome; }
    public void setCategoriaNome(String categoriaNome) { this.categoriaNome = categoriaNome; }
}