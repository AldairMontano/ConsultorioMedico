package com.kosmos.model.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "consultorios")
public class Consultorio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numero;

    private int piso;

    public Consultorio() {
    }

    public Consultorio(int numero, int piso) {
        this.numero = numero;
        this.piso = piso;
    }

    public Consultorio(int numero, int piso, Long id) {
        this.numero = numero;
        this.piso = piso;
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getPiso() {
        return piso;
    }

    public void setPiso(int piso) {
        this.piso = piso;
    }
}
