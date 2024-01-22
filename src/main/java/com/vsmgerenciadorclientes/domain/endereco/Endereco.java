package com.vsmgerenciadorclientes.domain.endereco;

import com.vsmgerenciadorclientes.domain.cidade.Cidade;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "endereco")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String logradouro;

    public String numero;

    public String bairro;

    public String cep;

    @ManyToOne
    @JoinColumn(name = "cidadeId")
    public Cidade cidade;
}
