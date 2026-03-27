package com.example.clientes.repository;

import com.example.clientes.model.Cliente;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClienteRepository {

    private List<Cliente> listaClientes = new ArrayList<>();

    public List<Cliente> obtenerClientes(){
        return listaClientes;
    }

    public Cliente guardarCliente(Cliente cli){
        listaClientes.add(cli);
        return cli;
    }
    
    //Eliminar cliente por su correo 
    public boolean eliminarCliente(String correo){
        return listaClientes.removeIf(c -> c.getCorreo() != null && c.getCorreo().equalsIgnoreCase(correo));
    }

}
