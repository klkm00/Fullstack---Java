package com.api.biblioteca.repository;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import com.api.biblioteca.model.Libro;

@Repository
public class LibroRepository {
    List<Libro> listaLibros = new ArrayList<>();

    public List<Libro> findAll(){
        return listaLibros;
    }

    public void save(Libro libro){
        listaLibros.add(libro);
    }

    public Libro findId(int id) {

        for (Libro libro : listaLibros) {
            if (libro.getId() == id) {
                return libro;
            }
        }
        return null;
    }

    public boolean deleteById(int id) {
        Libro libro = findId(id);
        if (libro != null) {
            listaLibros.remove(libro);
        }
        return false;
    }

    
}
