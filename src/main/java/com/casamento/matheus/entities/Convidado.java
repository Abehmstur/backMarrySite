package com.casamento.matheus.entities;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "TB_CONVIDADO")
public class Convidado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String nome;
    private String Mensagem;
    @ManyToOne
    private Presente presente;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Presente getPresente() {
        return presente;
    }

    public void setPresente(Presente presente) {
        this.presente = presente;
    }

    public String getMensagem() {
        return Mensagem;
    }

    public void setMensagem(String mensagem) {
        Mensagem = mensagem;
    }
}
