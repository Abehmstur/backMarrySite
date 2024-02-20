package com.casamento.matheus.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_PRESENTE")
public class Presente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String urlImg;
    private String nome;
    private int qtd_present;

    @OneToMany
    private List<Convidado> listaConvidado;

    public Presente() {
        this.listaConvidado = new ArrayList<Convidado>();
    }

    public Boolean isDisponivel(){
        return this.qtd_present < this.listaConvidado.size();
    };

    public int getQtdDisponivel(){
        return this.qtd_present - this.listaConvidado.size();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUrlImg() {
        return urlImg;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtd_present() {
        return qtd_present;
    }

    public void setQtd_present(int qtd_present) {
        this.qtd_present = qtd_present;
    }
}
