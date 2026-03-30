package com.clientes.api.controller;

import java.util.List;

import com.clientes.api.model.Cliente;
import com.clientes.api.service.ClienteService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    @Autowired
    private ClienteService service;

    @GetMapping
    public ResponseEntity<List<Cliente>> obtenerTodos(){
        List<Cliente> lista = service.listarClientes();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> crear(@Valid @RequestBody Cliente cliente) {
        String resultado = service.registrarCliente(cliente);
        
        if (resultado.contains("ERROR")) {
            return new ResponseEntity<>(resultado, HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity<>(resultado, HttpStatus.CREATED);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<String> borrar(@PathVariable String email) {
        boolean eliminado = service.borrarCliente(email);
        
        if (eliminado) {
            return new ResponseEntity<>("Cliente eliminado correctamente", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("No se encontró el cliente", HttpStatus.NOT_FOUND);
        }
    }


}
