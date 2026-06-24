package com.itsqmet.sistemabiblioteca_cadena.model;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "carnets")
public class Carnet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "El número de carnet es obligatorio")
    @Column(unique = true, nullable = false)
    private String numero;

    private String anioVigencia;

    //uno a uno
    @OneToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    @JsonBackReference("usuario-carnet")
    private  Usuario usuario;


    public Carnet() {

    }
    public Carnet(Long id, String numero, String anioVigencia, Usuario usuario) {
        this.id = id;
        this.numero = numero;
        this.anioVigencia = anioVigencia;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getAnioVigencia() {
        return anioVigencia;
    }

    public void setAnioVigencia(String anioVigencia) {
        this.anioVigencia = anioVigencia;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
