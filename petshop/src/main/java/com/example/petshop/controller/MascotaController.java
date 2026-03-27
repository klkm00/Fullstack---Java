package com.example.petshop.controller;

import com.example.petshop.model.Mascota;
import com.example.petshop.service.MascotaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/mascotas")

public class MascotaController {
    @Autowired
    private MascotaService mascotaService;

    @GetMapping
    public List<Mascota> listarMascotas(){
        return mascotaService.getMascotas();
    }

    @PostMapping
    public Mascota agregarMascota(@RequestBody Mascota mascota) {
        return mascotaService.saveMascota(mascota);
    }

    @GetMapping("{id}")
    public Mascota buscarMascota(@PathVariable int id) {
        return mascotaService.getMascotaId(id);
    }

    @DeleteMapping("{id}")
    public String eliminarMascota(@PathVariable int id) {
        return mascotaService.deleteMascota(id);
    }

    
}
