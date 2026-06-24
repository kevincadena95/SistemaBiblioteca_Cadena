package com.itsqmet.sistemabiblioteca_cadena.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El campo cédula es obligatoria")
    @Pattern(regexp = "\\d{10}", message = "La cédula debe tener 10 dígitos")
    private String cedula;

    @NotBlank(message = "El campo nombre es obligatorio")
    @Size(min = 2, max = 75, message = "El nombre debe tener entre 2 y 75 caracteres")
    private String nombreCompleto;

    @NotBlank(message = "El campo correo es obligatorio")
    @Email(message = "Correo inválido")
    private String correo;

    @NotBlank(message = "El campo teléfono es obligatorio")
    @Pattern(regexp = "\\d{9,10}", message = "El teléfono debe tener entre 9 y 10 dígitos")
    private String telefono;

    @NotBlank(message = "El campo contraseña es obligatoria")
    @Size(min = 8, max = 25, message = "La contraseña debe tener entre 8 y 100 caracteres")
    private String contrasenia;

    @NotBlank(message = "La fecha de registro es obligatoria")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "La fecha debe tener el formato yyyy-MM-dd")
    private String fechaRegistro;


    // RELACION 1:1
    @OneToOne(mappedBy = "usuario")
    @JsonManagedReference("usuario-carnet")
    private Carnet carnet;

    //Relacion N:N con libros
    @ManyToMany
    @JoinTable(
            name = "usuario_libro",
            joinColumns = @JoinColumn(name = "usuario_id"),
            inverseJoinColumns = @JoinColumn(name = "libro_id")
    )
    @JsonManagedReference("usuario-libro")
    private List<Libro> libros = new ArrayList<>();


    public Usuario() {
    }

    public Usuario(Long id, String cedula, String nombreCompleto, String correo, String telefono, String contrasenia, String fechaRegistro) {
        this.id = id;
        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.correo = correo;
        this.telefono = telefono;
        this.contrasenia = contrasenia;
        this.fechaRegistro = fechaRegistro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(String fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
}