package com.clientes.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.clientes.api.model.Cliente;
import com.clientes.api.repository.ClienteRespository;
import java.util.List;

@Service
public class ClienteService {

    @Autowired
    private ClienteRespository respository;

    public List<Cliente> listarClientes(){
        return respository.buscarTodos();
    }

    public String registrarCliente(Cliente nuevoCliente){
        //REGLA: Verificar si el email ya existe
        Cliente existente = respository.buscarPorEmail(nuevoCliente.getEmail());

        if (existente != null){
            return "ERROR: Cliente registrado";
        }

        respository.guardar(nuevoCliente);
        return "EXITO: Cliente registrado";
    }

    public boolean borrarCliente(String email){
        return respository.eliminarPorEmail(email);
    }

}
