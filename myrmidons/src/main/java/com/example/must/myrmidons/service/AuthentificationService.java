package com.example.must.myrmidons.service;

import org.springframework.stereotype.Service;

import com.example.must.myrmidons.domain.Utilisateur;
import com.example.must.myrmidons.repository.UtilisateurRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthentificationService {
    
    private final UtilisateurRepository utilisateurRepository;

    public AuthentificationService( UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }
    
    public boolean authentification(String email, String motDePasse) {
        return utilisateurRepository.findByEmailAndPassword(email, motDePasse).isPresent(); 
    }
}
