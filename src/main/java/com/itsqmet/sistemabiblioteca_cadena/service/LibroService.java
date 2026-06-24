package com.itsqmet.sistemabiblioteca_cadena.service;

import com.itsqmet.sistemabiblioteca_cadena.model.Libro;
import com.itsqmet.sistemabiblioteca_cadena.repository.LibroRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LibroService {

    @Autowired
    private LibroRepository libroRepository;

    public List<Libro> obtenerTodo(){
        return libroRepository.findAll();
    }

    public Optional<Libro> buscarporId(Long id){
        return libroRepository.findById(id);
    }

    public Libro crearlibro(Libro libro){
        return libroRepository.save(libro);
    }

    public boolean eliminar(Long id) {
        if (libroRepository.existsById(id)) {
            libroRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Libro> actualizar(Long id, Libro libroActualizado) {
        return libroRepository.findById(id).map(libro -> {
            libro.setTitulo(libroActualizado.getTitulo());
            libro.setIsbn(libroActualizado.getIsbn());
            libro.setSinopsis(libroActualizado.getSinopsis());
            libro.setFechaPublicacion(libroActualizado.getFechaPublicacion());
            libro.setAutor(libroActualizado.getAutor());
            libro.setPrecio(libroActualizado.getPrecio());
            libro.setStock(libroActualizado.getStock());

            return libroRepository.save(libro);
        });
    }
}
