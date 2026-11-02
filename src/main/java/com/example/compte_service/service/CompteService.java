package com.example.compte_service.service;

import com.example.compte_service.dto.CompteRequestDTO;
import com.example.compte_service.dto.CompteResponseDTO;

import java.util.List;

public interface CompteService {
    CompteResponseDTO addCompte(CompteRequestDTO dto);
    List<CompteResponseDTO> getComptes();
    CompteResponseDTO getCompte(String id);
    CompteResponseDTO updateCompte(String id, CompteRequestDTO dto);
    void deleteCompte(String id);
}