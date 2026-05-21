package com.natalia.financecontrol.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name= "categorias")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transacao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private com.natalia.financecontrol.entity.TipoTransacao tipo;
    private BigDecimal valor;
    private String descricao;
    private LocalDate data;

    @ManyToOne
    @JoinColumn(name = "categoria_id")   // Chave estrangeira
    private Categoria categoria;
}