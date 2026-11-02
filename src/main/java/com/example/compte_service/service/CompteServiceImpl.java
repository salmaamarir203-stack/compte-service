package com.example.compte_service.service;

import com.example.compte_service.dto.CompteRequestDTO;
import com.example.compte_service.dto.CompteResponseDTO;
import com.example.compte_service.entities.Compte;
import com.example.compte_service.mappers.CompteMapper;
import com.example.compte_service.repositories.CompteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional
public class CompteServiceImpl implements CompteService {

    private final CompteRepository compteRepository;
    private final CompteMapper compteMapper;

    public CompteServiceImpl(CompteRepository compteRepository, CompteMapper compteMapper) {
        this.compteRepository = compteRepository;
        this.compteMapper = compteMapper;
    }

    @Override
    public CompteResponseDTO addCompte(CompteRequestDTO dto) {
        Compte compte = Compte.builder()
                .id(UUID.randomUUID().toString())
                .dateCreation(new Date())
                .solde(dto.getSolde() != null ? dto.getSolde() : 0)
                .devise(dto.getDevise())
                .type(dto.getType())
                .build();
        Compte saved = compteRepository.save(compte);
        return compteMapper.fromCompte(saved);
    }

    @Override
    public List<CompteResponseDTO> getComptes() {
        return compteRepository.findAll()
                .stream()
                .map(compteMapper::fromCompte)
                .toList();
    }

    @Override
    public CompteResponseDTO getCompte(String id) {
        Compte compte = compteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Compte %s introuvable", id)));
        return compteMapper.fromCompte(compte);
    }

    @Override
    public CompteResponseDTO updateCompte(String id, CompteRequestDTO dto) {
        Compte compte = compteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(String.format("Compte %s introuvable", id)));
        if (dto.getSolde() != null) compte.setSolde(dto.getSolde());
        if (dto.getDevise() != null) compte.setDevise(dto.getDevise());
        if (dto.getType() != null) compte.setType(dto.getType());
        Compte saved = compteRepository.save(compte);
        return compteMapper.fromCompte(saved);
    }

    @Override
    public void deleteCompte(String id) {
        compteRepository.deleteById(id);
    }
}