package com.example.carrozzeria.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.carrozzeria.model.Veicolo;

@Service
public class VeicoloService {
    
    private final List<Veicolo> veicoli = new ArrayList<>(List.of(
            new Veicolo(1L, "AA111BB", "Panda", "Fiat", "2021-01-01", "In lavorazione"),
            new Veicolo(2L, "CC222DD", "Ypsilon", "Lancia", "2021-01-02", "In attesa"),
            new Veicolo(3L, "EE333FF", "3008", "Peugeot", "2021-01-03", "In lavorazione"),
            new Veicolo(4L, "GG444HH", "Punto", "Fiat", "2021-01-04", "Completato"),
            new Veicolo(5L, "II555JJ", "Panda", "Fiat", "2021-01-05", "In attesa")
    ));

    public List<Veicolo> getVeicoli() {
        return veicoli;
    }

    public Optional<Veicolo> getVeicoloById(Long id) {
        return veicoli.stream().filter(veicolo -> veicolo.getId().equals(id)).findFirst();
    }

    public Veicolo addVeicolo(Veicolo veicolo) {
        veicoli.add(veicolo);
        return veicolo;
    }

    public List<Veicolo> deleteVeicoloIfRepaired(String targa) {
        veicoli.removeIf(veicolo -> veicolo.getTarga().equals(targa) && veicolo.getStatoRiparazione().equals("Completato"));
        return veicoli;
    }

    public Veicolo updateStatoRiparazione(String targa, String statoRiparazione) {
        for (Veicolo veicolo : veicoli) {
            if (veicolo.getTarga().equals(targa)) {
                veicolo.setStatoRiparazione(statoRiparazione);
                return veicolo;
            }
        }
        return null;
    }

    public List<Veicolo> findByTarga (String targa){
        return veicoli.stream()
                    .filter(veicolo -> veicolo.getTarga().toLowerCase().contains(targa.toLowerCase()))
                    .toList();
    }

    public List<Veicolo> findByMarca (String marca){
        return veicoli.stream()
                    .filter(veicolo -> veicolo.getMarca().toLowerCase().contains(marca.toLowerCase()))
                    .toList();
    }
}
