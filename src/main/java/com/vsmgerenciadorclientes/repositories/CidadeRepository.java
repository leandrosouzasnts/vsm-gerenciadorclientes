package com.vsmgerenciadorclientes.repositories;

import com.vsmgerenciadorclientes.domain.cidade.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {
    public boolean existsByNomeAndUf(String nome, String uf);
}
