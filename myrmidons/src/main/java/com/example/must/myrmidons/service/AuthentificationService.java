package com.example.must.myrmidons.service;

import java.util.Collections;
import java.util.Optional;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.must.myrmidons.domain.Utilisateur;
import com.example.must.myrmidons.repository.UtilisateurRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AuthentificationService implements UserDetailsService {

    private final UtilisateurRepository utilisateurRepository;

    public AuthentificationService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public Optional<Utilisateur> authentification(String email, String motDePasse) {
        return utilisateurRepository.findByEmailAndMdp(email, motDePasse);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Utilisateur> user = utilisateurRepository.findByEmail(email);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new User(email, user.get().getPassword(), Collections.emptySet());
    }
}
