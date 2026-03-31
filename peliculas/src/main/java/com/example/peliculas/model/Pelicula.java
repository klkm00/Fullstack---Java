package com.example.peliculas.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pelicula {

    private int id;
    @NotBlank(message= "El titulo es obliagtorio.")
    private String titulo;
    @NotBlank(message = "La categoria es obligatoria.")
    private String categoria;
    @NotNull(message = "El anno es obligatorio.")
    @Min(value = 1950, message = "El anno debe ser mayor a 1950.")
    @Max(value = 2026, message = "El anno no puede ser superior al anno actual.")
    private int anno;

}
