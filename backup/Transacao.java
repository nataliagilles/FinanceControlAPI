package com.natalia.financecontrol.entity;

import com.natalia.financecontrol.enums.TipoTransacao;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private TipoTransacao tipo;
    private BigDecimal valor;
    private String descricao;
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "categoria_id")   // Chave estrangeira
    private Categoria categoria;
}