package com.example.peliculas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.peliculas.model.Pelicula;
import com.example.peliculas.service.PeliculaService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("api/v1/peliculas")
public class PeliculaController {
    @Autowired
    private PeliculaService service;

    @GetMapping
    public ResponseEntity<List<Pelicula>> listarPeliculas(){
        List<Pelicula> lista = service.listar();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> guardarPelicula(@Valid @RequestBody Pelicula peli){
        String res = service.guardar(peli);
        if(res.contains("ERROR")){
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarPelicula(@PathVariable int id){
        boolean elim = service.eliminar(id);
        if(elim){
            return new ResponseEntity<>("ERROR: Pelicula no encontrada.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Pelicula eliminada correctamente.", HttpStatus.OK);
    }
    
}
