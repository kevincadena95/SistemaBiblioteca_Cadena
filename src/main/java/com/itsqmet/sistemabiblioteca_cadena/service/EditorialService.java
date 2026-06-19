package com.itsqmet.sistemabiblioteca_cadena.service;

import com.itsqmet.sistemabiblioteca_cadena.model.Editorial;
import com.itsqmet.sistemabiblioteca_cadena.repository.EditorialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EditorialService {

    @Autowired
    private EditorialRepository editorialRepository;

    public List<Editorial> obtenerTodo() {
        return editorialRepository.findAll();
    }

    public Optional<Editorial> buscarporId(Long id) {
        return editorialRepository.findById(id);
    }

    public Editorial crearEditorial(Editorial editorial) {
        return editorialRepository.save(editorial);
    }

    public boolean eliminar(Long id) {
        if (editorialRepository.existsById(id)) {
            editorialRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Optional<Editorial> actualizar(Long id, Editorial editorialActualizada) {
        return editorialRepository.findById(id).map(editorial -> {
            editorial.setNombre(editorialActualizada.getNombre());
            editorial.setPaisOrigen(editorialActualizada.getPaisOrigen());
            editorial.setDireccion(editorialActualizada.getDireccion());
            editorial.setTelefonoContacto(editorialActualizada.getTelefonoContacto());
            editorial.setCorreo(editorialActualizada.getCorreo());
            editorial.setRepresentante(editorialActualizada.getRepresentante());

            return editorialRepository.save(editorial);
        });
    }
}