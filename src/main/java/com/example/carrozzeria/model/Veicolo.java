package com.example.carrozzeria.model;

public class Veicolo {

    private Long id;
    private String targa;
    private String modello; 
    private String marca;
    private String dataIngresso;
    private String statoRiparazione;

    public Veicolo(Long id, String targa, String modello, String marca, String dataIngresso, String statoRiparazione) {
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


    public String getDataIngresso() {
        return dataIngresso;
    }


    public String getStatoRiparazione() {
        return statoRiparazione;
    }

    public void setStatoRiparazione(String statoRiparazione2) {
        this.statoRiparazione = statoRiparazione2;
    }


}
