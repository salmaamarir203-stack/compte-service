package com.example.compte_service.entities;

import com.example.compte_service.enums.TypeCompte;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Compte {
    @Id
    private String id;
    private Date dateCreation;
    private double solde;
    private String devise;
    @Enumerated(EnumType.STRING)
    private TypeCompte type;
}