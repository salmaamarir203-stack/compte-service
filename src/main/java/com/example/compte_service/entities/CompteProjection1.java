package com.example.compte_service.entities;

import com.example.compte_service.enums.TypeCompte;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "p1", types = Compte.class)
public interface CompteProjection1 {
    String getId();
    TypeCompte getType();
    double getSolde();
}