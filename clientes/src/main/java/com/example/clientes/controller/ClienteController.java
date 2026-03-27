package com.example.clientes.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.clientes.model.Cliente;
import com.example.clientes.service.ClienteService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public List<Cliente> mostrarClientes() {
        return clienteService.getClientes();
    }
    
    @PostMapping
    public Cliente annadirCliente(@Valid @RequestBody Cliente cli){
        return clienteService.addCliente(cli);
    }

    @DeleteMapping("/{correo:.+}")
    public ResponseEntity<String> borrarCliente(@PathVariable("correo") String correo) {
        boolean eliminado = clienteService.deleteCliente(correo);
        if (eliminado) {
            return new ResponseEntity<>("Cliente eliminado correctamente", HttpStatus.OK);
        }
        return new ResponseEntity<>("Cliente no encontrado", HttpStatus.NOT_FOUND);
    } 
}
