package com.vsmgerenciadorclientes.controllers;

import com.vsmgerenciadorclientes.domain.endereco.Endereco;
import com.vsmgerenciadorclientes.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
/*

    Esse controller é simbolico, visto que não usamos o Endereço diretamente

 */
@RestController
@RequestMapping("/enderecos")
public class EnderecoController {
    @Autowired
    private EnderecoService enderecoService;

    @GetMapping
    public ResponseEntity<List<Endereco>> getAllEnderecos(){
        List<Endereco> enderecos = this.enderecoService.getAllEnderecos();
        return new ResponseEntity<>(enderecos, HttpStatus.OK);
    }
}
