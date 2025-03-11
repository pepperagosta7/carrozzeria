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

    @GetMapping("/search/{targa}")
    public List<Veicolo> findVeicolobyTarga(@RequestParam String targa){
        return veicoloService.findByTarga(targa);
    }

    @GetMapping("/search/{marca}")
    public List<Veicolo> findVeicolobyMarca(@RequestParam String marca){
        return veicoloService.findByMarca(marca);
    }

    @PostMapping
    public ResponseEntity<Veicolo> addVeicolo(@RequestBody Veicolo veicolo){
        Veicolo newVeicolo = veicoloService.addVeicolo(veicolo);
        URI location = URI.create(String.format("/api/users/%d", newVeicolo.getId()));
        return ResponseEntity.created(location).body(newVeicolo);
    }

    @DeleteMapping("/{id}")
    public List<Veicolo> deleteVeicolo(@PathVariable Long id){
        return veicoloService.deleteVeicoloIfRepaired(id);
    }

    @PutMapping("/{id}")   
    public ResponseEntity<Veicolo> updateVeicolo(@PathVariable Long id, @RequestBody Veicolo veicolo){
        Veicolo updatedVeicolo = veicoloService.updateStatoRiparazione(id, veicolo.getStatoRiparazione());
        return updatedVeicolo != null ? ResponseEntity.ok(updatedVeicolo) : ResponseEntity.notFound().build();
    }

}
