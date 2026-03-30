package com.api.biblioteca.controller;

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
import com.api.biblioteca.model.Libro;
import com.api.biblioteca.service.LibroService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/libros")
public class LibroController {
    @Autowired
    private LibroService libroService;

    @GetMapping
    public ResponseEntity<List<Libro>> listarLibros(){
        List<Libro> lista = libroService.listar();
        return new ResponseEntity<>(lista, HttpStatus.OK);
    }
    
    @PostMapping 
    public ResponseEntity<String> guardarLibro(@Valid @RequestBody Libro libro){
        String res = libroService.guardar(libro);
        if(res.contains("ERROR")) {
            return new ResponseEntity<>(res,HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(res, HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> eliminarLibro(@PathVariable int id){
        boolean elim = libroService.eliminar(id);
        if(elim){
            return new ResponseEntity<>("No se encontro el libro", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("Libro eliminado", HttpStatus.OK);
    }

}