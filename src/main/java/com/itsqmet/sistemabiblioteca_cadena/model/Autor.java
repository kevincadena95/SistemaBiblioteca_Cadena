package com.itsqmet.sistemabiblioteca_cadena.model;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.*;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El campo nombre no puede estar vacío")
    @Size(min = 2, max = 25, message = "El nombre debe tener entre 2 y 25 caracteres")
    private String nombre;

    @NotBlank(message = "El campo apellido no puede estar vacío")
    @Size(min = 2, max = 25, message = "El apellido debe tener entre 2 y 25 caracteres")
    private String apellido;

    @NotBlank(message = "El campo nacionalidad no puede estar vacío")
    @Size(min = 2, max = 50, message = "La nacionalidad debe tener entre 2 y 50 caracteres")
    @Column(nullable = false)
    private String nacionalidad;

    @Size(max = 500, message = "La biografía corta no puede superar 500 caracteres")
    private String biografiaCorta;

    @ManyToMany
    @JoinTable(
            name = "autor_libro",
            joinColumns = @JoinColumn(name = "autor_id"),
            inverseJoinColumns = @JoinColumn(name = "libro_id")
    )
    @JsonIgnoreProperties("autores")
    private List<Libro> libros = new ArrayList<>();


    public Autor() {
    }

    public Autor(Long id, String nombre, String apellido, String nacionalidad, String biografiaCorta) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.nacionalidad = nacionalidad;
        this.biografiaCorta = biografiaCorta;
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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getBiografiaCorta() {
        return biografiaCorta;
    }

    public void setBiografiaCorta(String biografiaCorta) {
        this.biografiaCorta = biografiaCorta;
    }
}
