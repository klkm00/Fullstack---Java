package com.api.biblioteca.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.biblioteca.model.Libro;
import com.api.biblioteca.repository.LibroRepository;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> listar(){
        return libroRepository.findAll();
    }

    public String guardar(Libro nuevoLibro){
        Libro existente = libroRepository.findId(nuevoLibro.getId());
        if (existente != null){
            return "Error: Libro ya registrado.";
        } 
        libroRepository.save(nuevoLibro);
        return "Exito: Nuevo ibro registrado.";
    }

    public boolean eliminar(int id){
        return libroRepository.deleteById(id);
        
    }

}
