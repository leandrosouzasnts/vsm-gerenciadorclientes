package com.vsmgerenciadorclientes.domain.endereco;

import com.vsmgerenciadorclientes.domain.cliente.Cliente;
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
    private Long id;

    private String logradouro;

    private String numero;

    private String bairro;

    private String cep;

    private Long cidadeId;

    @Column(name = "cliente_id")
    private Long clienteId;
}
