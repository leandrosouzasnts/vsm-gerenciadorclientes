package com.vsmgerenciadorclientes.controllers;

import com.vsmgerenciadorclientes.domain.cliente.Cliente;
import com.vsmgerenciadorclientes.services.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente){
        Cliente novoCliente = clienteService.createCliente(cliente);

        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }

    @PatchMapping("/{clienteId}/inativar")
    public ResponseEntity<Void> inactivateCliente(@PathVariable Long clienteId) throws Exception {
        this.clienteService.inactivateCliente(clienteId);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("/{clienteId}/ativar")
    public ResponseEntity<Void> activateCliente(@PathVariable Long clienteId) throws Exception {
        this.clienteService.activateCliente(clienteId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{clienteId}")
    public ResponseEntity<Cliente> getById(@PathVariable Long clienteId) throws Exception {
        Cliente cliente = this.clienteService.getById(clienteId);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }

    @GetMapping("/documento/{documento}")
    public ResponseEntity<Cliente> getByDocumento(@PathVariable String documento) throws Exception {
        Cliente cliente = this.clienteService.getByDocumento(documento);
        return new ResponseEntity<>(cliente, HttpStatus.OK);
    }


}
