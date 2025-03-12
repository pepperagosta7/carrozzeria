package com.example.carrozzeria.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.carrozzeria.model.Veicolo;
import com.example.carrozzeria.service.VeicoloService;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/veicoli")
public class VeicoloControllerAPI {
    
    private final VeicoloService veicoloService;

    public VeicoloControllerAPI(VeicoloService veicoloService){
        this.veicoloService = veicoloService;
    }

    @GetMapping
    public List<Veicolo> getAllVeicolos(){
        return veicoloService.getVeicoli();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Veicolo> getVeicolobyId(@PathVariable Long id){
        Veicolo veicolo = veicoloService.getVeicoloById(id);
        return ResponseEntity.ok(veicolo);
    }

    @GetMapping("/search/targa")
    public Optional<Veicolo> findVeicolobyTarga(@RequestParam String targa){
        return veicoloService.findByTarga(targa);
    }

    @GetMapping("/search/marca")
    public List<Veicolo> findVeicolobyMarca(@RequestParam String marca){
        return veicoloService.findByMarca(marca);
    }

    @PostMapping
    public ResponseEntity<Veicolo> addVeicolo(@RequestBody Veicolo veicolo){
        Veicolo newVeicolo = veicoloService.addVeicolo(veicolo);
        URI location = URI.create("/api/users/" + newVeicolo.getId());
        return ResponseEntity.created(location).body(newVeicolo);
    }

    @DeleteMapping("/{targa}")
    public List<Veicolo> deleteVeicolo(@PathVariable String targa){
        veicoloService.deleteVeicoloByTarga(targa);
        return veicoloService.getVeicoli();
    }

    @PutMapping("/{targa}/stato")   
    public ResponseEntity<Veicolo> updateVeicolo(@PathVariable String targa, @RequestBody Veicolo veicolo){
        Veicolo updatedVeicolo = veicoloService.updateStatoRiparazione(targa, veicolo.getStatoRiparazione());
        return ResponseEntity.ok(updatedVeicolo);
    }

}
