package com.natalia.financecontrol.Service;

import com.natalia.financecontrol.dto.CategoriaRequestDTO;
import com.natalia.financecontrol.dto.CategoriaResponseDTO;
import com.natalia.financecontrol.entity.Categoria;
import com.natalia.financecontrol.repository.CategoriaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service

public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    @Transactional
    public CategoriaResponseDTO criar(CategoriaRequestDTO dto) {
        Categoria categoria = new Categoria();
        categoria.setNome(dto.getNome());
        categoria.setDescricao(dto.getDescricao());
        categoria.setTipo(dto.getTipo());

        Categoria saved = categoriaRepository.save(categoria);
        return toResponseDTO(saved);
    }

    public List<CategoriaResponseDTO> listarTodas() {
        return categoriaRepository.findAll().stream()
                .map(this::toResponseDTO)
                .toList();
    }

    public Optional<CategoriaResponseDTO> buscarPorId(Long id) {
        return categoriaRepository.findById(id).map(this::toResponseDTO);
    }

    @Transactional
    public void deletar(Long id) {
        categoriaRepository.deleteById(id);
    }

    private CategoriaResponseDTO toResponseDTO(Categoria categoria) {
        return new CategoriaResponseDTO(
                categoria.getId(),
                categoria.getNome(),
                categoria.getDescricao(),
                categoria.getTipo()
        );
    }

}
