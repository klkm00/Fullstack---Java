package com.example.bibliotecaduoc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bibliotecaduoc.model.Libro;
import com.example.bibliotecaduoc.repository.LibroRepository;

@Service //Define una clase como un servicio en la capa de negocio
public class LibroService {

    @Autowired // Spring puede resolver e inyectar automáticamente las dependencias de un bean

    private LibroRepository libroRepository;

    public List<Libro> getLibros() {
        return libroRepository.obtenerLibros();
    }

    public Libro saveLibro(Libro libro) {
        return libroRepository.guardar(libro);
    }

    public Libro getLibroId(int id) {
        return libroRepository.buscarPorId(id);
    }

    public Libro updateLibro(Libro libro) {
        return libroRepository.actulizar(libro);
    }

    public String deleteLibro(int id) {
        libroRepository.eliminar(id);
        return "Producto eliminado.";
    }

    public int totalLibrosV1() {
        return libroRepository.obtenerLibros().size();
    }

}
