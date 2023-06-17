package com.example.must.myrmidons.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.must.myrmidons.domain.Utilisateur;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

    Optional<Utilisateur> findByEmailAndMdp(String email, String password);
}
