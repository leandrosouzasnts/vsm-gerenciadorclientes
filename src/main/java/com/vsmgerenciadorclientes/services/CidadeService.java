package com.vsmgerenciadorclientes.services;

import com.vsmgerenciadorclientes.domain.cidade.Cidade;
import com.vsmgerenciadorclientes.dtos.CidadeDTO;
import com.vsmgerenciadorclientes.repositories.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    public Cidade createCidade(CidadeDTO cidade) throws Exception {
        if (this.cidadeRepository.existsByNomeAndUf(cidade.nome(), cidade.uf())) {
            throw new Exception("Cidade já cadastrada");
        }

        Cidade novaCidade = new Cidade(cidade);

        this.cidadeRepository.save(novaCidade);

        return novaCidade;
    }

    public List<Cidade> getAllCidades(){
        return this.cidadeRepository.findAll();
    }
}
