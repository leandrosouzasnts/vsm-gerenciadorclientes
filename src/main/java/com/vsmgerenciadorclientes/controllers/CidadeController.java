package com.vsmgerenciadorclientes.controllers;

import com.vsmgerenciadorclientes.domain.cidade.Cidade;
import com.vsmgerenciadorclientes.dtos.CidadeDTO;
import com.vsmgerenciadorclientes.services.CidadeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

    @Autowired
    private CidadeService cidadeService;

    @PostMapping
    public ResponseEntity<Cidade> createCidade(@RequestBody CidadeDTO cidade) throws Exception {
        Cidade novaCidade = this.cidadeService.createCidade(cidade);

        return new ResponseEntity<>(novaCidade, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Cidade>> getAllCidades(){
        List<Cidade> cidades = this.cidadeService.getAllCidades();
        return new ResponseEntity<>(cidades, HttpStatus.OK);
    }

}
