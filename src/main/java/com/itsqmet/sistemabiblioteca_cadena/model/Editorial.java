package com.itsqmet.sistemabiblioteca_cadena.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


@Entity
@Table(name="editoriales")
public class Editorial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El campo nombre no puede estar vacio")
    @Size(min = 2, max = 25, message = ("El nombre no cumple con el rango de caracteres de 2-50"))
    @Column(nullable = false)
    private String nombre;

    @NotBlank(message = "El campo pais de origen no puede estar vacio")
    @Size(min = 2, max = 50, message = ("El pais de origen no cumple con el rango de caracteres de 2-50"))
    @Column(nullable = false)
    private String paisOrigen;

    @NotBlank(message = "El campo direccion no puede estar vacio")
    @Size(min = 5, max = 100, message = ("La direccion no cumple con el rango de caracteres de 5-100"))
    private String direccion;

    @NotBlank(message = "El campo teléfono de contacto es obligatorio")
    @Pattern(regexp = "\\d{9,10}", message = "El teléfono de contacto debe tener entre 9 y 10 dígitos")
    private String telefonoContacto;

    @NotBlank(message = "El campo correo no puede estar vacio")
    @Email(message = "El correo no tiene un formato valido")
    private String correo;

    @NotBlank(message = "El campo representante no puede estar vacio")
    @Size(min = 2, max = 50, message = ("El representante no cumple con el rango de caracteres de 2-50"))
    private String representante;

    public Editorial() {
    }

    public Editorial(Long id, String nombre, String paisOrigen, String direccion, String telefonoContacto, String correo, String representante) {
        this.id = id;
        this.nombre = nombre;
        this.paisOrigen = paisOrigen;
        this.direccion = direccion;
        this.telefonoContacto = telefonoContacto;
        this.correo = correo;
        this.representante = representante;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPaisOrigen() {
        return paisOrigen;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonoContacto() {
        return telefonoContacto;
    }

    public void setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getRepresentante() {
        return representante;
    }

    public void setRepresentante(String representante) {
        this.representante = representante;
    }
}
