package com.example.carrozzeria.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.carrozzeria.model.Veicolo;
import com.example.carrozzeria.service.VeicoloService;

import jakarta.validation.Valid;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/veicoli")
public class VeicoloController {
    
    private final VeicoloService veicoloService;

    public VeicoloController(VeicoloService veicoloService){
        this.veicoloService = veicoloService;
    }

    @GetMapping
    public List<Veicolo> getAllVeicolos(){
        return veicoloService.getVeicoli();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veicolo> getVeicolobyId(@PathVariable Long id){
        Optional<Veicolo> veicolo = veicoloService.getVeicoloById(id);
        return veicolo.map(ResponseEntity::ok)
                        .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/search/targa")
    public List<Veicolo> findVeicolobyTarga(@RequestParam String targa){
        return veicoloService.findByTarga(targa);
    }

    @GetMapping("/search/marca")
    public List<Veicolo> findVeicolobyMarca(@RequestParam String marca){
        return veicoloService.findByMarca(marca);
    }

    @PostMapping
    public ResponseEntity<Veicolo> addVeicolo(@Valid @RequestBody Veicolo veicolo){
        Veicolo newVeicolo = veicoloService.addVeicolo(veicolo);
        URI location = URI.create(String.format("/api/users/%d", newVeicolo.getId()));
        return ResponseEntity.created(location).body(newVeicolo);
    }

    @DeleteMapping("/{targa}")
    public List<Veicolo> deleteVeicolo(@Valid @PathVariable String targa){
        return veicoloService.deleteVeicoloIfRepaired(targa);
    }

    @PutMapping("/{targa}/stato")   
    public ResponseEntity<Veicolo> updateVeicolo(@PathVariable String targa, @Valid @RequestBody Veicolo veicolo){
        Veicolo updatedVeicolo = veicoloService.updateStatoRiparazione(targa, veicolo.getStatoRiparazione());
        return updatedVeicolo != null ? ResponseEntity.ok(updatedVeicolo) : ResponseEntity.notFound().build();
    }

}
