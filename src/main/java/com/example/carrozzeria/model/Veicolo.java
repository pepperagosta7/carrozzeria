package com.example.carrozzeria.model;

import jakarta.persistence.*;
import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "veicoli")
public class Veicolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String targa;

    @Column(nullable = false, length = 50)
    private String modello; 

    @Column(nullable = false, length = 50)
    private String marca;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dataIngresso;

    @Column(nullable = false, length = 50)
    private String statoRiparazione;

    public Veicolo(){
    }

    public Veicolo(Long id, String targa, String modello, String marca, LocalDate dataIngresso, String statoRiparazione) {
        this.id = id;
        this.targa = targa;
        this.modello = modello;
        this.marca = marca;
        this.dataIngresso = dataIngresso;
        this.statoRiparazione = statoRiparazione;
    }

    public Long getId() {
        return id;
    }


    public String getTarga() {
        return targa;
    }


    public String getModello() {
        return modello;
    }


    public String getMarca() {
        return marca;
    }


    public LocalDate getDataIngresso() {
        return dataIngresso;
    }


    public String getStatoRiparazione() {
        return statoRiparazione;
    }

    public void setStatoRiparazione(String statoRiparazione2) {
        this.statoRiparazione = statoRiparazione2;
    }


}
