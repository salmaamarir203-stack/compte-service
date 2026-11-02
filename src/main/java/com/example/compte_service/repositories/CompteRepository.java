package com.example.compte_service.repositories;

import com.example.compte_service.entities.Compte;
import com.example.compte_service.enums.TypeCompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface CompteRepository extends JpaRepository<Compte, String> {

    List<Compte> findByType(@Param("t") TypeCompte type);
}