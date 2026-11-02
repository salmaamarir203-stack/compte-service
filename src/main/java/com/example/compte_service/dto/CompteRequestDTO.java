package com.example.compte_service.dto;

import com.example.compte_service.enums.TypeCompte;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CompteRequestDTO {
    private Double solde;
    private String devise;
    private TypeCompte type;
}