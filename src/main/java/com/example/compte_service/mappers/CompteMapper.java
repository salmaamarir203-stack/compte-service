package com.example.compte_service.mappers;

import com.example.compte_service.dto.CompteResponseDTO;
import com.example.compte_service.entities.Compte;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CompteMapper {

    public CompteResponseDTO fromCompte(Compte compte) {
        CompteResponseDTO dto = new CompteResponseDTO();
        BeanUtils.copyProperties(compte, dto);
        return dto;
    }
}