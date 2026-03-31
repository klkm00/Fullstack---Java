package com.example.peliculas.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.peliculas.model.Pelicula;
import com.example.peliculas.repository.PeliculaRepository;

@Service
public class PeliculaService {
    @Autowired
    private PeliculaRepository repository;

    public List<Pelicula> listar(){
        return repository.findAll();
    }

    public String guardar(Pelicula nuevaPeli){
        Pelicula existe = repository.findId(nuevaPeli.getId());
        if(existe != null){
            return "ERROR: Pelicula ya en el catalogo.";
        }
        repository.save(nuevaPeli);
        return "EXITO: Pelicula agregada al catalogo.";
    }

    public boolean eliminar(int id){
        return repository.delete(id);
    }
    
}
