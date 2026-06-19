package com.itsqmet.sistemabiblioteca_cadena.service;

import com.itsqmet.sistemabiblioteca_cadena.model.Autor;
import com.itsqmet.sistemabiblioteca_cadena.repository.AutorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> obtenerTodo() {
        return autorRepository.findAll();
    }

    public Optional<Autor> buscarporId(Long id) {
        return autorRepository.findById(id);
    }

    public Autor crearAutor(Autor autor) {
        return autorRepository.save(autor);
    }

    public boolean eliminar(Long id) {
        if (autorRepository.existsById(id)) {
            autorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Autor> actualizar(Long id, Autor autorActualizado) {
        return autorRepository.findById(id).map(autor -> {
            autor.setNombre(autorActualizado.getNombre());
            autor.setApellido(autorActualizado.getApellido());
            autor.setNacionalidad(autorActualizado.getNacionalidad());
            autor.setBiografiaCorta(autorActualizado.getBiografiaCorta());

            return autorRepository.save(autor);
        });
    }
}
