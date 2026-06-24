package com.itsqmet.sistemabiblioteca_cadena.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.util.*;


@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El campo titulo no puede estar vacio")
    @Size(min = 2, max = 100, message = ("El titulo no cumple con el rango de caracteres de 2-15"))
    @Column(nullable = false)
    private String titulo;

    @NotBlank(message = "El campo IDBN no puede estar vacio")
    private String isbn;

    @Size(max = 500, message = "La sinopsis no puede superar 500 caracteres")
    private String sinopsis;

    @NotBlank(message = "El campo autor no puede estar vacio")
    @Size(min = 2, max = 25, message = ("El autor no cumple con el rango de caracteres de 2-25"))
    private String autor;

    @NotBlank(message = "La fecha de publicacion es obligatoria")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "La fecha debe tener el formato yyyy-MM-dd")
    private String fechaPublicacion;

    @NotNull(message = "El precio es obligatorio")
    @Min(value = 0, message = "El precio no puede ser negativo")
    @Column(nullable = false)
    private Double precio;

    @NotNull(message = "El stock es obligatorio")
    @Min(value = 0, message = "El stock no puede ser negativo")
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "editorial_id")
    @JsonBackReference("editorial-libros")
    private Editorial editorial;

    @ManyToMany(mappedBy = "libros")
    private List<Autor> autores = new ArrayList<>();

    @ManyToMany(mappedBy = "libros")
    private List<Usuario> usuarios = new ArrayList<>();

//hola
    public Libro() {
    }

    public Libro(Long id, String titulo, String isbn, String sinopsis, String autor, String fechaPublicacion, Double precio, Integer stock) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.sinopsis = sinopsis;
        this.autor = autor;
        this.fechaPublicacion = fechaPublicacion;
        this.precio = precio;
        this.stock = stock;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }



    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }
}
