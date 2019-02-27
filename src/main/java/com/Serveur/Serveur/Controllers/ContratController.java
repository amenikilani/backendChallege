package com.Serveur.Serveur.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Serveur.Serveur.Entities.Contrat;
import com.Serveur.Serveur.Repositories.ContratRepository;
import java.net.URI;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
public class ContratController {
    private ContratRepository repository;

    public ContratController(ContratRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/contrats")
    public List<Contrat> retrieveAllContrats() {
        return repository.findAll();
    }


    @PostMapping("/contrats")
    public ResponseEntity<Object> createContrat(@RequestBody Contrat contrat) {
        Contrat savedContrat = repository.save(contrat);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedContrat.getId()).toUri();
        return ResponseEntity.created(location).build();

    }

    @PutMapping("/contrats/{id}")
    public ResponseEntity<Object> updateContrat(@RequestBody Contrat contrat, @PathVariable long id) {
        Optional<Contrat> contratOptional = repository.findById(id);
        if (!contratOptional.isPresent())
            return ResponseEntity.notFound().build();
        contrat.setId(id);
        repository.save(contrat);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/contrats/{id}")
    public void deleteVol(@PathVariable long id) {
        repository.deleteById(id);
    }


}
