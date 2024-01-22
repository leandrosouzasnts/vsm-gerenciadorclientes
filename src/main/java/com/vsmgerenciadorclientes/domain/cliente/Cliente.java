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
    public String name;

    @Column(unique = true, nullable = false)
    public String documento;

    public String telefone;

    @Column(unique = true)
    public String email;

    @OneToMany
    @JoinColumn(name = "enderecoId")
    public List<Endereco> endereco = new ArrayList<>();
}
