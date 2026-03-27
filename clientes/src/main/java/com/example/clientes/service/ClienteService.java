package com.example.clientes.service;

import com.example.clientes.model.Cliente;
import com.example.clientes.repository.ClienteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public List<Cliente> getClientes(){
        return clienteRepository.obtenerClientes();
    }

    public Cliente addCliente(Cliente cli){
        return clienteRepository.guardarCliente(cli);
    }

    public boolean deleteCliente(String correo) {
        return clienteRepository.eliminarCliente(correo);
    }

    
}
