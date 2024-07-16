package com.izabellavm.apiforum.controller;

import com.izabellavm.apiforum.model.Topico;
import com.izabellavm.apiforum.service.TopicoService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("topicos")
public class TopicoController {

    @Autowired
    private TopicoService topicoService;

    @PostMapping
    @Transactional
    public ResponseEntity<Topico> cadastrar(@Valid @RequestBody Topico topico) {
        Topico topicocriado = topicoService.save(topico);
        return ResponseEntity.status(HttpStatus.CREATED).body(topicocriado);
    }

    @GetMapping
    public List<Topico> listarTodosTopicos() {
        return topicoService.listarTodosTopicos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topico> getTopicoPorId(@PathVariable Long id) {
        Topico topico = topicoService.listarPorId(id)
            .orElseThrow(() -> new RuntimeException("Topico não encontrado com o id " + id));
        return ResponseEntity.ok(topico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topico> updateTopico(@PathVariable Long id, @RequestBody Topico topicoAtualizar) {
        Topico topicoAtualizado = topicoService.atualizarTopico(id, topicoAtualizar);

        if (topicoAtualizado != null){
            return ResponseEntity.ok(topicoAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopico(@PathVariable Long id) {
        topicoService.deletePorId(id);
        return ResponseEntity.noContent().build();
    }

}
