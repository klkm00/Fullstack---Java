package com.example.petshop.repository;

import com.example.petshop.model.Mascota;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class MascotaRepository {

    //Guardar todas las mascotas en una lista
    private List<Mascota> listaMascotas = new ArrayList<>();

    //Retorna todas las mascotas de la lista
    public List<Mascota> obtenerMascotas() {
        return listaMascotas;
    }

    //Buscar una mascota por ID
    public Mascota buscarPorId(int id) {

        for (Mascota mascota : listaMascotas) {
            if (mascota.getId() == id) {
                return mascota;
            }
        }
        return null;
    }

    //Guardar una nueva mascota en la lista
    public Mascota guardar(Mascota masc) {

        listaMascotas.add(masc);
        return masc;

    }

    //Eliminar una mascota de la lista
    public void eliminar(int id) {
        Mascota mascota = buscarPorId(id);
        if (mascota != null) {
            listaMascotas.remove(mascota);
        }
    }



}