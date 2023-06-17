package com.example.must.myrmidons.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.must.myrmidons.domain.Utilisateur;
import com.example.must.myrmidons.repository.UtilisateurRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthentificationService {

    private final UtilisateurRepository utilisateurRepository;

    public AuthentificationService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public Optional<Utilisateur> authentification(String email, String motDePasse) {
        return utilisateurRepository.findByEmailAndMdp(email, motDePasse);
    }
}
