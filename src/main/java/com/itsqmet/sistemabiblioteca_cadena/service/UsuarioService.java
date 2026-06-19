package com.itsqmet.sistemabiblioteca_cadena.service;

import com.itsqmet.sistemabiblioteca_cadena.model.Usuario;
import com.itsqmet.sistemabiblioteca_cadena.model.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public List<Usuario> obtenerTodo() {
        return usuarioRepository.findAll();
    }

    public Optional<Usuario> buscarporId(Long id) {
        return usuarioRepository.findById(id);
    }

    public Usuario crearUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    public boolean eliminar(Long id) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Usuario> actualizar(Long id, Usuario usuarioActualizado) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setCedula(usuarioActualizado.getCedula());
            usuario.setNombreCompleto(usuarioActualizado.getNombreCompleto());
            usuario.setCorreo(usuarioActualizado.getCorreo());
            usuario.setTelefono(usuarioActualizado.getTelefono());
            usuario.setContrasenia(usuarioActualizado.getContrasenia());
            usuario.setFechaRegistro(usuarioActualizado.getFechaRegistro());

            return usuarioRepository.save(usuario);
        });
    }
}