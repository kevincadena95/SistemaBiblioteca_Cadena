package com.itsqmet.sistemabiblioteca_cadena.controller;

import com.itsqmet.sistemabiblioteca_cadena.model.Autor;
import com.itsqmet.sistemabiblioteca_cadena.model.Carnet;
import com.itsqmet.sistemabiblioteca_cadena.service.CarnetService;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/carnets")
@CrossOrigin("*")

public class CarnetController {
    @Autowired
    private CarnetService carnetService;

    @GetMapping
    public ResponseEntity<List<Carnet>> obtenerTodos() {
        List<Carnet> carnets = carnetService.obtenerTodo();
        return ResponseEntity.ok(carnets);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> obtenerPorId(@PathVariable Long id) {
        return carnetService.buscarporId(id)
                .map(carnet -> ResponseEntity.ok((Object) carnet))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Map.of("error", "Carnet con id " + id + " no encontrado")));
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Carnet carnet, BindingResult result) {

        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(error ->
                    errores.put(error.getField(), error.getDefaultMessage())
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errores);
        }

        Carnet nuevo = carnetService.crearCarnet(carnet);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        if (carnetService.eliminar(id)) {
            return ResponseEntity.ok(Map.of("mensaje", "Carnet eliminado correctamente"));
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Map.of("error", "Carnet con id " + id + " no encontrado"));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @Valid @RequestBody Carnet carnet,
                                        BindingResult result) {

        if (result.hasErrors()) {
            Map<String, String> errores = new HashMap<>();
            result.getFieldErrors().forEach(error ->
                    errores.put(error.getField(), error.getDefaultMessage())
            );
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errores);
        }

        return carnetService.actualizar(id, carnet)
                .map(actualizado -> ResponseEntity.ok((Object) actualizado))
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(Map.of("error", "Carnet con id " + id + " no encontrado")));
    }

}
