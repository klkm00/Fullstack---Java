package com.example.petshop.service;

import com.example.petshop.model.Mascota;
import com.example.petshop.repository.MascotaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MascotaService {
    @Autowired

    private MascotaRepository mascotaRepository;
    public List<Mascota> getMascotas() {
        return mascotaRepository.obtenerMascotas();
    }

    public Mascota saveMascota(Mascota mascota) {
        return mascotaRepository.guardar(mascota);
    }

    public Mascota getMascotaId(int id) {
        return mascotaRepository.buscarPorId(id);
    }

    public String deleteMascota(int id) {
        mascotaRepository.eliminar(id);
        return "Mascota eliminada.";
    }

}