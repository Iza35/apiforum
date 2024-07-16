package com.izabellavm.apiforum.service;

import com.izabellavm.apiforum.model.Topico;
import com.izabellavm.apiforum.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TopicoService {

    @Autowired
    private TopicoRepository repository;

    public Topico save(Topico topico) {
        topico.setDatadecriacao(LocalDateTime.now());
        return repository.save(topico);
    }

    public List<Topico> listarTodosTopicos() {
        return repository.findAll();
    }

    public Optional<Topico> listarPorId(Long id) {
        return repository.findById(id);
    }

    public Topico atualizarTopico(Long id, Topico topicoAtualizar) {
        Optional<Topico> topico = this.listarPorId(id);
        if (topico.isPresent()) {
            Topico topicoExistente = topico.get();
            topicoExistente.setTitulo(topicoAtualizar.getTitulo());
            topicoExistente.setMensagem(topicoAtualizar.getMensagem());
            topicoExistente.setDatadecriacao(topicoAtualizar.getDatadecriacao());
            topicoExistente.setAutor(topicoAtualizar.getAutor());
            topicoExistente.setCurso(topicoAtualizar.getCurso());
            Topico topicoAtualizado = this.save(topicoExistente);
            return topicoAtualizado;
        }
        return null;
    }

    public void deletePorId(Long id) {
        repository.deleteById(id);
    }
}











