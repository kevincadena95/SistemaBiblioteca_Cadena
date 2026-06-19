package com.itsqmet.sistemabiblioteca_cadena.repository;

import com.itsqmet.sistemabiblioteca_cadena.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {

    List<Autor> findByApellido(String apellido);

}
