package com.example.clientes.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Cliente {

    @NotBlank
    private String nombre;
    @NotBlank @Email
    private String correo;
    @NotNull
    private int edad;
    
}
