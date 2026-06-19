package com.itsqmet.sistemabiblioteca_cadena.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;


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

    @NotBlank(message = "El campo año no puede estar vacio")
    @Min(value = 0, message = "El año no puede ser negativo")
    @Max(value = 2026, message = "El año no puede ser mayor al año actual")
    private Integer anioPublicacion;

    @NotNull(message = "El precio es obligatorio")
    @Min(value = 0, message = "El precio no puede ser negativo")
    @Column(nullable = false)
    private Double precio;

    @NotNull(message = "El stock es obligatorio")
    @Min(value = 0, message = "El stock no puede ser negativo")
    private Integer stock;

    public Libro() {
    }

    public Libro(Long id, String titulo, String isbn, String sinopsis, Integer anioPublicacion, Double precio, Integer stock) {
        this.id = id;
        this.titulo = titulo;
        this.isbn = isbn;
        this.sinopsis = sinopsis;
        this.anioPublicacion = anioPublicacion;
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

    public Integer getAnioPublicacion() {
        return anioPublicacion;
    }

    public void setAnioPublicacion(Integer anioPublicacion) {
        this.anioPublicacion = anioPublicacion;
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
