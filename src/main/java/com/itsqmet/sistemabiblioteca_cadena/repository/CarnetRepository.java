package com.itsqmet.sistemabiblioteca_cadena.repository;

import com.itsqmet.sistemabiblioteca_cadena.model.Carnet;
import com.itsqmet.sistemabiblioteca_cadena.model.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarnetRepository extends JpaRepository<Carnet, Long> {
}
