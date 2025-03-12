package com.example.carrozzeria.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.carrozzeria.model.Veicolo;
import com.example.carrozzeria.repository.VeicoloRepository;

@Service
public class VeicoloService {

    private final VeicoloRepository veicoloRepository;

    public VeicoloService(VeicoloRepository veicoloRepository) {
        this.veicoloRepository = veicoloRepository;
    }

    public List<Veicolo> getVeicoli() {
        return veicoloRepository.findAll();
    }

    public Veicolo getVeicoloById(Long id) {
        return veicoloRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Veicolo with id " + id + " not found"));
    }

    @Transactional
    public Veicolo addVeicolo(Veicolo veicolo) {
        return veicoloRepository.save(veicolo);
    }

    public Optional<Veicolo> findByTarga(String targa) {
        return veicoloRepository.findByTarga(targa);
    }

    public List<Veicolo> findByMarca(String marca) {
        return veicoloRepository.findByMarca(marca);
    }

    @Transactional
    public void deleteVeicoloByTarga(String targa) {
        veicoloRepository.findByTarga(targa).ifPresentOrElse(
                veicoloRepository::delete,
                () -> {
                    throw new RuntimeException("Veicolo with targa " + targa + " not found");
                }
        );
    }

    public Veicolo updateStatoRiparazione(String targa, String statoRiparazione) {
        Veicolo veicolo = veicoloRepository.findByTarga(targa)
                .orElseThrow(() -> new RuntimeException("Veicolo with targa " + targa + " not found"));
        veicolo.setStatoRiparazione(statoRiparazione);
        return veicoloRepository.save(veicolo);
    }

   
}
