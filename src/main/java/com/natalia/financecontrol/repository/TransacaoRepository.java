package com.natalia.financecontrol.repository;

import com.natalia.financecontrol.entity.TipoTransacao;
import com.natalia.financecontrol.entity.Transacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface TransacaoRepository extends JpaRepository<Transacao, Long> {
    List<Transacao> findByTipo(TipoTransacao tipo);
    List<Transacao> findByDataBetween(LocalDate inicio, LocalDate fim);
    List<Transacao> findByCategoriaNome(String categoriaNome);
}
