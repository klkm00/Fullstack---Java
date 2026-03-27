package com.example.productos.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data //Anotaciones (Getter, Setter, etc)
@AllArgsConstructor //Genera constructor con todos los campos como parámetros
@NoArgsConstructor //Genera construtor sin argumentos
public class Producto {

    @NotBlank
    private String nombre;
    @NotNull
    private Double precio;
    @NotBlank
    private String categoria;
    
    
}
