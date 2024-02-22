package com.casamento.matheus.controllers;

import com.casamento.matheus.entities.Convidado;
import com.casamento.matheus.entities.Presente;
import com.casamento.matheus.repositories.ConvidadoRepository;
import com.casamento.matheus.repositories.PresenteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class PresenteController {

    @Autowired
    PresenteRepository presenteRepository;

    @Autowired
    ConvidadoRepository convidadoRepository;

    @PostMapping("/presentes")
    public Presente salvarPresente(@RequestBody Presente presente){
        return presenteRepository.save(presente);
    }

    @GetMapping("/presentes")
    public List<Presente> listarPresentes(){
        return presenteRepository.findAll();
    }

    @PutMapping("/presentes/{id}")
    public Presente alterarPresentes(@PathVariable(value = "id") UUID id ,@RequestBody Presente presente){
        Optional<Presente> presente0 = presenteRepository.findById(id);
        if(presente0.isEmpty()){
            return null;
        }
        presente.setId(presente0.get().getId());
        return presenteRepository.save(presente);
    }

    @DeleteMapping("/presentes/{id}")
    public String deletarPresente(@PathVariable(value = "id") UUID id){
        Optional<Presente> presente = presenteRepository.findById(id);
        if (presente.isEmpty()){
            return null;
        }
        presenteRepository.delete(presente.get());
        return "deletado com sucesso!";
    }

    @PostMapping("/convidados/{id}")
    public Object cadastrarConvidado(@PathVariable(value = "id") UUID id, @RequestBody Convidado convidado){
        Optional<Presente> presente = presenteRepository.findById(id);
        if(presente.isEmpty()){
            return "presente não existe!";
        }
        if(!presente.get().isDisponivel()){
            return "presente não disponivel";
        }
        Convidado convidado1 = new Convidado();
        convidado1.setPresente(presente.get());
        convidado1.setNome(convidado.getNome());
        presente.get().setQtd_present( presente.get().getQtd_present() - 1);
        return convidadoRepository.save(convidado1);
    }

    @GetMapping("/convidados")
    public List<Convidado> listarConvidadosComPresentes(){
        return convidadoRepository.findAll();
    }

}
