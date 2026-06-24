package com.itsqmet.sistemabiblioteca_cadena.repository;

import com.itsqmet.sistemabiblioteca_cadena.model.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EditorialRepository extends JpaRepository<Editorial, Long> {

    List<Editorial> findByNombre(String nombre);
}
