package com.casamento.matheus.controllers;

import com.casamento.matheus.entities.Convidado;
import com.casamento.matheus.entities.Presente;
import com.casamento.matheus.repositories.ConvidadoRepository;
import com.casamento.matheus.repositories.PresenteRepository;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    @CrossOrigin(origins = "*")
    @PostMapping("/presentes")
    public Presente salvarPresente(@RequestBody Presente presente){
        return presenteRepository.save(presente);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/presentes")
    public List<Presente> listarPresentes(){
        return presenteRepository.findAll();
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/presentes/{id}")
    public Presente alterarPresentes(@PathVariable(value = "id") UUID id ,@RequestBody Presente presente){
        Optional<Presente> presente0 = presenteRepository.findById(id);
        if(presente0.isEmpty()){
            return null;
        }
        presente.setId(presente0.get().getId());
        return presenteRepository.save(presente);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/presentes/{id}")
    public String deletarPresente(@PathVariable(value = "id") UUID id){
        Optional<Presente> presente = presenteRepository.findById(id);
        if (presente.isEmpty()){
            return null;
        }
        presenteRepository.delete(presente.get());
        return "deletado com sucesso!";
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/convidados/{id}")
    public Object cadastrarConvidado(@PathVariable(value = "id") UUID id, @RequestBody Convidado convidado){
        Optional<Presente> presente = presenteRepository.findById(id);
        if(presente.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("presente não existe!");
        }
        if(!presente.get().isDisponivel()){
            return ResponseEntity.status(HttpStatus.NOT_MODIFIED).body("presente não disponivel");
        }
        Convidado convidado1 = new Convidado();
        convidado1.setPresente(presente.get());
        convidado1.setNome(convidado.getNome());
        convidado1.setMensagem(convidado.getMensagem());
        presente.get().setQtd_present( presente.get().getQtd_present() - 1);
        return convidadoRepository.save(convidado1);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/convidados")
    public List<Convidado> listarConvidadosComPresentes(){
        return convidadoRepository.findAll();
    }

}
