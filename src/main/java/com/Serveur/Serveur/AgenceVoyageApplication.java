package com.Serveur.Serveur;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.Serveur.Serveur.Repositories.ContratRepository;
import com.Serveur.Serveur.Entities.Contrat;
import com.Serveur.Serveur.Entities.Ressource;
import com.Serveur.Serveur.Repositories.RessourceRepository;

@SpringBootApplication
public class AgenceVoyageApplication{
     @Autowired
    private ContratRepository contratRepository ;
     @Autowired
     private RessourceRepository ressourceRepository ;
	public static void main(String[] args) {
		SpringApplication.run(AgenceVoyageApplication.class, args);
	}
	@Bean
    CommandLineRunner commandLineRunner() {
        return args -> {
            contratRepository.deleteAll();
            ressourceRepository.deleteAll();
            List<Contrat> contrats = Stream.of("COne", "CTwo", "CThree")
                    .map(Contrat::new)
                    .collect(Collectors.toList());
            System.out.println(contrats.toString());
            
            Ressource ressource = new Ressource();
            ressource.setNom("Ala");
            ressource.setPrenom("a");
            ressource.setDateEntree(new Date());
            ressource.getContrats().addAll(contrats);
            ressourceRepository.save(ressource);
        };
}}

