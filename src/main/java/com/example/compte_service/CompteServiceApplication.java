package com.example.compte_service;

import com.example.compte_service.entities.Compte;
import com.example.compte_service.enums.TypeCompte;
import com.example.compte_service.repositories.CompteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class CompteServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompteServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CompteRepository compteRepository) {
		return args -> {
			for (int i = 0; i < 10; i++) {
				Compte compte = Compte.builder()
						.id(UUID.randomUUID().toString())
						.type(Math.random() > 0.5 ? TypeCompte.COURANT : TypeCompte.EPARGNE)
						.solde(1000 + Math.random() * 90000)
						.dateCreation(new Date())
						.devise("MAD")
						.build();
				compteRepository.save(compte);
			}
			compteRepository.findAll().forEach(System.out::println);
		};
	}
}