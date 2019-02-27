package com.Serveur.Serveur.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.Serveur.Serveur.Entities.Contrat;


//@RepositoryRestResource
@Repository
public interface ContratRepository extends JpaRepository<Contrat, Long> {
	  Optional<Contrat> findById(Long id);
	  void deleteById(Long id);
}
