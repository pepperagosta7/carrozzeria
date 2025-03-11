package com.example.carrozzeria.model;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class Veicolo {

    private Long id;

    @NotBlank(message = "La targa è obbligatoria")
    @Pattern(regexp = "^[A-Z]{2}[0-9]{3}[A-Z]{2}$", message = "Formato targa non valido (es: AB123CD)")
    private String targa;

    @NotBlank(message = "Il modello è obbligatorio")
    @Size(min = 2, max = 50, message = "Il modello deve avere tra 2 e 50 caratteri")
    private String modello; 

    @NotBlank(message = "La marca è obbligatoria")
    @Size(min = 2, max = 50, message = "La marca deve avere tra 2 e 50 caratteri")
    private String marca;

    @PastOrPresent(message = "La data di nascita deve essere nel passato")
    private LocalDate dataIngresso;

    @NotBlank(message = "Lo stato della riparazione è obbligatorio")
    @Pattern(regexp = "^(In attesa|In corso|Completata)$", message = "Lo stato può essere solo 'In attesa', 'In corso' o 'Completata'")
    private String statoRiparazione;

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
