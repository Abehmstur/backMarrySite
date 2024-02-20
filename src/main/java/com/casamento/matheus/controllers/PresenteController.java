package com.casamento.matheus.controllers;

import com.casamento.matheus.entities.Presente;
import com.casamento.matheus.repositories.PresenteRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PresenteController {

    @Autowired
    PresenteRepository presenteRepository;

    @PostMapping("/presentes")
    public Presente salvarPresente(@RequestBody Presente presente){
        return presenteRepository.save(presente);
    }

    @GetMapping("/presentes")
    public List<Presente> listarPresentes(){
        return presenteRepository.findAll();
    }

}
