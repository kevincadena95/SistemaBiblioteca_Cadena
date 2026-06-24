package com.itsqmet.sistemabiblioteca_cadena.service;
import com.itsqmet.sistemabiblioteca_cadena.model.Autor;
import com.itsqmet.sistemabiblioteca_cadena.model.Carnet;
import com.itsqmet.sistemabiblioteca_cadena.repository.CarnetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarnetService {
    @Autowired
    private CarnetRepository carnetRepository;

    public List<Carnet> obtenerTodo() {
        return carnetRepository.findAll();
    }

    public Optional<Carnet> buscarporId(Long id) {
        return carnetRepository.findById(id);
    }

    public Carnet crearCarnet(Carnet carnet) {
        return carnetRepository.save(carnet);
    }

    public boolean eliminar(Long id) {
        if (carnetRepository.existsById(id)) {
            carnetRepository.deleteById(id);
            return true;
        }
        return false;
    }

   public Optional<Carnet> actualizar(Long id, Carnet carnetActualizo){
        return carnetRepository.findById(id).map(carnet -> {
           carnet.setCodigoCarnet(carnetActualizo.getCodigoCarnet());
           carnet.setFechaEmision(carnetActualizo.getFechaEmision());
           carnet.setFechaVencimiento(carnetActualizo.getFechaVencimiento());

           return carnetRepository.save(carnet);
        });
   }



}
