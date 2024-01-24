package com.vsmgerenciadorclientes.services;

import com.vsmgerenciadorclientes.domain.endereco.Endereco;
import com.vsmgerenciadorclientes.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public List<Endereco> getAllEnderecos(){
        return enderecoRepository.findAll();
    }
}
