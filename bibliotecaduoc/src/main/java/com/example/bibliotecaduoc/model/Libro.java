package com.example.bibliotecaduoc.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //Anotaciones (Getter, Setter, etc)
@AllArgsConstructor //Genera constructor con todos los campos como parámetros
@NoArgsConstructor //Genera construtor sin argumentos

public class Libro {
    private int id;
    private String isbn;
    private String titulo;
    private String editorial;
    private int fechaPublicacion;
    private String autor;

}
