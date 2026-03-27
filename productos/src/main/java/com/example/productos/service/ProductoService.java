package com.example.productos.service;

import com.example.productos.model.Producto;
import com.example.productos.repository.ProductoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> listarProductos(){
        return productoRepository.obtenerProductos();
    }

    public Producto guardarProducto(Producto prod) {
        return productoRepository.guardar(prod);
    }

    public boolean eliminarProducto(String nombre) {
        return productoRepository.eliminar(nombre);
    }
    
}
