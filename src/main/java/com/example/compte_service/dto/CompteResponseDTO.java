package com.example.compte_service.dto;

import com.example.compte_service.enums.TypeCompte;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompteResponseDTO {
    private String id;
    private Date dateCreation;
    private double solde;
    private String devise;
    private TypeCompte type;
}