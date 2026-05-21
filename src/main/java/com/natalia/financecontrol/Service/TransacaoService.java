package com.natalia.financecontrol.Service;

import com.natalia.financecontrol.dto.TransacaoRequestDTO;
import com.natalia.financecontrol.dto.TransacaoResponseDTO;
import com.natalia.financecontrol.entity.Categoria;
import com.natalia.financecontrol.entity.Transacao;
import com.natalia.financecontrol.entity.TipoTransacao;
import com.natalia.financecontrol.repository.CategoriaRepository;
import com.natalia.financecontrol.repository.TransacaoRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransacaoService {

    private final TransacaoRepository transacaoRepository;
    private final CategoriaRepository categoriaRepository;

    public TransacaoService(TransacaoRepository transacaoRepository,
                            CategoriaRepository categoriaRepository) {
        this.transacaoRepository = transacaoRepository;
        this.categoriaRepository = categoriaRepository;
    }

    public TransacaoResponseDTO criar(TransacaoRequestDTO dto) {
        Categoria categoria = categoriaRepository.findById(dto.getCategoriaId())
                .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));

        Transacao transacao = new Transacao();
        transacao.setDescricao(dto.getDescricao());
        transacao.setValor(dto.getValor());
        transacao.setTipo(dto.getTipo());
        transacao.setData(dto.getData());
        transacao.setCategoria(categoria);

        Transacao transacaoSalva = transacaoRepository.save(transacao);
        return converterParaResponse(transacaoSalva);
    }

    public List<TransacaoResponseDTO> listarTodas() {
        return transacaoRepository.findAll().stream()
                .map(this::converterParaResponse)
                .collect(Collectors.toList());
    }

    public List<TransacaoResponseDTO> buscarPorPeriodo(LocalDate inicio, LocalDate fim) {
        return transacaoRepository.findByDataBetween(inicio, fim).stream()
                .map(this::converterParaResponse)
                .collect(Collectors.toList());
    }

    private TransacaoResponseDTO converterParaResponse(Transacao transacao) {
        TransacaoResponseDTO response = new TransacaoResponseDTO();

        response.setId(transacao.getId());
        response.setDescricao(transacao.getDescricao());
        response.setValor(transacao.getValor());
        response.setTipo(transacao.getTipo());
        response.setData(transacao.getData());

        if (transacao.getCategoria() != null) {
            response.setCategoriaNome(transacao.getCategoria().getNome());
        } else {
            response.setCategoriaNome("Sem categoria");
        }

        return response;
    }

    // Buscar transação por ID
    public TransacaoResponseDTO buscarPorId(Long id) {
        Transacao transacao = transacaoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Transação não encontrada com ID: " + id));

        return converterParaResponse(transacao);
    }

    public List<TransacaoResponseDTO> buscarPorTipo(TipoTransacao tipo) {
        List<Transacao> transacoes = transacaoRepository.findByTipo(tipo);
        return transacoes.stream()
                .map(this::converterParaResponse)
                .collect(Collectors.toList());
    }
}