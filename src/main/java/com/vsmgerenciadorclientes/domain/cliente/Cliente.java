package com.vsmgerenciadorclientes.domain.cliente;

import com.vsmgerenciadorclientes.domain.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "cliente")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, nullable = false)
    private String documento;

    private String telefone;

    @Column(unique = true)
    private String email;

    private boolean ativo = true;

    @OneToMany
    @JoinColumn(name = "cliente_id")
    private List<Endereco> enderecos = new ArrayList<>();

}
