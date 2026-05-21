package com.natalia.financecontrol.Controller;

import com.natalia.financecontrol.dto.TransacaoRequestDTO;
import com.natalia.financecontrol.dto.TransacaoResponseDTO;
import com.natalia.financecontrol.entity.TipoTransacao;
import com.natalia.financecontrol.Service.TransacaoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

        import jakarta.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/transacoes")
public class TransacaoController {

    private final TransacaoService transacaoService;

    public TransacaoController(TransacaoService transacaoService) {
        this.transacaoService = transacaoService;
    }

    // Criar nova transação
    @PostMapping
    public ResponseEntity<TransacaoResponseDTO> criar(@Valid @RequestBody TransacaoRequestDTO dto) {
        TransacaoResponseDTO response = transacaoService.criar(dto);
        return ResponseEntity.ok(response);
    }

    // Listar todas
    @GetMapping
    public ResponseEntity<List<TransacaoResponseDTO>> listarTodas() {
        return ResponseEntity.ok(transacaoService.listarTodas());
    }

    // Buscar por ID
    @GetMapping("/{id}")
    public ResponseEntity<TransacaoResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(transacaoService.buscarPorId(id));
    }

    // Buscar por tipo (RECEITA ou DESPESA)
    @GetMapping("/tipo/{tipo}")
    public ResponseEntity<List<TransacaoResponseDTO>> buscarPorTipo(@PathVariable TipoTransacao tipo) {
        return ResponseEntity.ok(transacaoService.buscarPorTipo(tipo));
    }

    // Buscar por período
    @GetMapping("/periodo")
    public ResponseEntity<List<TransacaoResponseDTO>> buscarPorPeriodo(
            @RequestParam LocalDate inicio,
            @RequestParam LocalDate fim) {
        return ResponseEntity.ok(transacaoService.buscarPorPeriodo(inicio, fim));
    }
}