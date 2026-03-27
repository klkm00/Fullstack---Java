package com.example.productos.controller;

import com.example.productos.model.Producto;
import com.example.productos.service.ProductoService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/lproductos")
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping
    public List<Producto> mostarProductos(){
        return productoService.listarProductos();
    }

    @PostMapping
    public Producto agregarProducto(@Valid @RequestBody Producto prod) {
        return productoService.guardarProducto(prod);
    }

    @DeleteMapping
    public boolean borrarProducto(@PathVariable String nombre) {
        return productoService.eliminarProducto(nombre);
    }

}
