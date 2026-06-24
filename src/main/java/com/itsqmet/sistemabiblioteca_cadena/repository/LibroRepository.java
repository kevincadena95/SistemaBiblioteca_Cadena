package com.itsqmet.sistemabiblioteca_cadena.repository;

import com.itsqmet.sistemabiblioteca_cadena.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long>{

    List<Libro>findByIsbn(String isbn);
}
