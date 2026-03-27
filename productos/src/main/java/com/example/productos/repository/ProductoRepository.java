package com.example.productos.repository;

import com.example.productos.model.Producto;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductoRepository {

    private List<Producto> listaProductos = new ArrayList<>();

    public List<Producto> obtenerProductos() {
        return listaProductos;
    }

    public Producto guardar(Producto prod) {
        listaProductos.add(prod);
        return prod;
    }

    public boolean eliminar(String nombre) {
        return listaProductos.removeIf(p -> p.getNombre().equalsIgnoreCase(nombre));
    }

    
}


    

