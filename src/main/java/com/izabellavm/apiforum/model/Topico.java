package com.izabellavm.apiforum.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Entity(name = "Topico")
@Table(name = "topicos")
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "campo obrigatório")
    @Column(nullable = false,length = 50)
    private String titulo;

    @NotBlank
    @Column(length = 150)
    private String mensagem;

    @Column(nullable = false)
    private LocalDateTime datadecriacao;

    @Column(length = 50, name = "estadodotopico")
    private String estadoDoTopico;

    @Column(nullable = false, length = 50)
    private String autor;

    @Column(length = 50)
    private String curso;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public LocalDateTime getDatadecriacao() {
        return datadecriacao;
    }

    public void setDatadecriacao(LocalDateTime datadecriacao) {
        this.datadecriacao = datadecriacao;
    }

    public String getEstadoDoTopico() {
        return estadoDoTopico;
    }

    public void setEstadoDoTopico(String estadoDoTopico) {
        this.estadoDoTopico = estadoDoTopico;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }
}
