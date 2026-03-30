package com.clientes.api.repository;

import com.clientes.api.model.Cliente;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ClienteRespository {
    //Lista donde guardamos los clientes en memoria
    private List<Cliente> listaClientes = new ArrayList<>();

    //Retorna todos los clientes
    public List<Cliente> buscarTodos(){
        return listaClientes;
    }

    //Guarda un cliente en la lista
    public void guardar(Cliente cliente){
        listaClientes.add(cliente);
    }

    //Buscar un cliente por su email 
    public Cliente buscarPorEmail(String email){
        for (Cliente c : listaClientes){
            if(c.getEmail().equalsIgnoreCase(email)){
                return c; //Encontramos y devolvemos
            }
        }
        return null; //no existe
    }

    //Elimina un cliente 
    public boolean eliminarPorEmail(String email){
        for (int i = 0; i < listaClientes.size(); i++){
            if(listaClientes.get(i).getEmail().equalsIgnoreCase(email)){
                listaClientes.remove(i);
                return true; //Se eliminó con éxito
            }
        }
        return false; //No se encontró nada a eliminar
    }

}
