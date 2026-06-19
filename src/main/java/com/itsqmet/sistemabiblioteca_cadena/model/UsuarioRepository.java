package com.itsqmet.sistemabiblioteca_cadena.model;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    List<Usuario> findByCedula(String cedula);
}
