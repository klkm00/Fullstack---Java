package com.example.peliculas.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.peliculas.model.Pelicula;

@Repository
public class PeliculaRepository {

    private List<Pelicula> listaPeliculas = new ArrayList<>();

    public List<Pelicula> findAll(){
        return listaPeliculas;
    }

    public void save(Pelicula peli){
        listaPeliculas.add(peli);
        return;
    }

    public Pelicula findId(int id){
        for(Pelicula peli : listaPeliculas){
            if(peli.getId() == id){
                return peli;
            }
        } return null;
    }

    public boolean delete(int id){
        Pelicula peli = findId(id);
        if(peli != null){
            listaPeliculas.remove(peli);
        } return false;
    } 
    
}
