package com.example.compte_service.web;

import com.example.compte_service.dto.CompteRequestDTO;
import com.example.compte_service.dto.CompteResponseDTO;
import com.example.compte_service.service.CompteService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CompteRestController {

    private final CompteService compteService;

    public CompteRestController(CompteService compteService) {
        this.compteService = compteService;
    }

    @GetMapping("/comptes")
    public List<CompteResponseDTO> comptes() {
        return compteService.getComptes();
    }

    @GetMapping("/comptes/{id}")
    public CompteResponseDTO compte(@PathVariable String id) {
        return compteService.getCompte(id);
    }

    @PostMapping("/comptes")
    public CompteResponseDTO save(@RequestBody CompteRequestDTO dto) {
        return compteService.addCompte(dto);
    }

    @PutMapping("/comptes/{id}")
    public CompteResponseDTO update(@PathVariable String id, @RequestBody CompteRequestDTO dto) {
        return compteService.updateCompte(id, dto);
    }

    @DeleteMapping("/comptes/{id}")
    public void delete(@PathVariable String id) {
        compteService.deleteCompte(id);
    }
}