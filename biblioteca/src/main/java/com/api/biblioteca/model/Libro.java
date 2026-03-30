package com.api.biblioteca.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Libro {

    private int id;
    @NotBlank(message= "El titulo es obligatorio.")
    private String titulo;
    @NotBlank(message= "Tienes que agregar al autor del libro.")
    private String autor;
    @NotNull(message= "La cantidad de paginas es obligatoria.")
    @Min(value= 1, message= "Debe tener por al menos 1 pagina")
    private int paginas;
    
}
