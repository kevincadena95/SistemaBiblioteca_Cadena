package com.itsqmet.sistemabiblioteca_cadena.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "carnets")
public class Carnet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El campo cédula es obligatoria")
    @Pattern(regexp = "\\d{10}", message = "La codigo debe tener 10 dígitos")
    private String codigoCarnet;

    @NotBlank(message = "La fecha de emisión es obligatoria")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "La fecha debe tener el formato yyyy-MM-dd")
    private String fechaEmision;

    @NotBlank(message = "La fecha de vencimiento es obligatoria")
    @Pattern(regexp = "\\d{4}-\\d{2}-\\d{2}", message = "La fecha debe tener el formato yyyy-MM-dd")
    private String fechaVencimiento;

    @NotBlank(message = "El campo estado es obligatoria")
    private String estado;

    @OneToOne
    @JoinColumn(name="usuario_id", nullable = false)
    @JsonBackReference("carnet-usuario")
    private Usuario usuario;

    public Carnet() {
    }

    public Carnet(Long id, String codigoCarnet, String fechaEmision, String fechaVencimiento, String estado) {
        this.id = id;
        this.codigoCarnet = codigoCarnet;
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigoCarnet() {
        return codigoCarnet;
    }

    public void setCodigoCarnet(String codigoCarnet) {
        this.codigoCarnet = codigoCarnet;
    }

    public String getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(String fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}


