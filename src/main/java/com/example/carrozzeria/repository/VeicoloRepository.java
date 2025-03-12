package com.example.carrozzeria.repository;

import com.example.carrozzeria.model.Veicolo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VeicoloRepository extends JpaRepository<Veicolo, Long> {

    Optional<Veicolo> findByTarga(String targa);

    void deleteByTarga(String targa);

    List<Veicolo> findByMarca(String marca);

}
