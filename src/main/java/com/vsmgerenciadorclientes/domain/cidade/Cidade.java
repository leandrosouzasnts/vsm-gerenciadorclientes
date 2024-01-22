package com.vsmgerenciadorclientes.domain.cidade;

import com.vsmgerenciadorclientes.dtos.CidadeDTO;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cidade")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cidade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String nome;

    public String uf;

    public Cidade(CidadeDTO cidadeDTO){
        this.nome = cidadeDTO.nome();
        this.uf = cidadeDTO.uf();
    }
}
