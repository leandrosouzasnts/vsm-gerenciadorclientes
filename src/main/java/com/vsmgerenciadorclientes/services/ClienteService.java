package com.vsmgerenciadorclientes.services;

import com.vsmgerenciadorclientes.domain.cliente.Cliente;
import com.vsmgerenciadorclientes.domain.endereco.Endereco;
import com.vsmgerenciadorclientes.repositories.ClienteRepository;
import com.vsmgerenciadorclientes.repositories.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public Cliente createCliente(Cliente cliente){

        Cliente novoCliente = new Cliente();
        novoCliente.setNome(cliente.getNome());
        novoCliente.setDocumento(cliente.getDocumento());
        novoCliente.setEmail(cliente.getEmail());
        novoCliente.setTelefone(cliente.getTelefone());
        novoCliente.setEnderecos(cliente.getEnderecos());

        this.clienteRepository.save(novoCliente);

        for (Endereco endereco : novoCliente.getEnderecos()){
            endereco.setClienteId(novoCliente.getId());
            this.enderecoRepository.save(endereco);
        }

        return novoCliente;
    }

    public void inactivateCliente(Long clienteId) throws Exception {
        Optional<Cliente> cliente = this.clienteRepository.findById(clienteId);

        if (!cliente.isPresent()) throw new Exception("Cliente não encontrado");

        cliente.get().setAtivo(false);

        this.clienteRepository.save(cliente.get());
    }

    public void activateCliente(Long clienteId) throws Exception {
        Optional<Cliente> cliente = this.clienteRepository.findById(clienteId);

        if (!cliente.isPresent()) throw new Exception("Cliente não encontrado");

        cliente.get().setAtivo(true);

        this.clienteRepository.save(cliente.get());
    }

    public Cliente getById(Long clienteId) throws Exception {
        return this.clienteRepository.findById(clienteId).orElseThrow(() -> new Exception("Cliente não encontrado"));
    }

    public Cliente getByDocumento(String documento) throws Exception{

        Cliente cliente = this.clienteRepository.findByDocumento(documento);
        if (cliente == null) {
            throw new Exception("Cliente não encontrado");
        }
        return cliente;
    }
}
