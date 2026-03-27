package com.example.petshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Mascota {
    
    private int id;
    private String nombre;
    private String especie;
    private String raza;
    private int edad;
    private String nombreDueno;

}