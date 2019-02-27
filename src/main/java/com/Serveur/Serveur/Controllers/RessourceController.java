package com.Serveur.Serveur.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.Serveur.Serveur.Entities.Ressource;
import com.Serveur.Serveur.Repositories.RessourceRepository;

import java.net.URI;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*")
@RestController
public class RessourceController {
    private RessourceRepository repository;

    public RessourceController(RessourceRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/ressources")
    public List<Ressource> retrieveAllRessources() {
        return repository.findAll();
    }


    @PostMapping("/ressources")
    public ResponseEntity<Object> createRessource(@RequestBody Ressource ressource) {
        Ressource savedRessource = repository.save(ressource);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedRessource.getId()).toUri();
        return ResponseEntity.created(location).build();

    }

    @PutMapping("/ressources/{id}")
    public ResponseEntity<Object> updateRessource(@RequestBody Ressource ressource, @PathVariable long id) {
        Optional<Ressource> ressourceOptional = repository.findById(id);
        if (!ressourceOptional.isPresent())
            return ResponseEntity.notFound().build();
        ressource.setId(id);
        repository.save(ressource);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/ressources/{id}")
    public void deleteVol(@PathVariable long id) {
        repository.deleteById(id);
    }


}
