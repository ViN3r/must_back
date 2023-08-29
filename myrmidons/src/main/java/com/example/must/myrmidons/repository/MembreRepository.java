package com.example.must.myrmidons.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.must.myrmidons.domain.Membre;

public interface MembreRepository extends JpaRepository<Membre, Integer> {

    public Optional<Membre> findByNom(String nom);

}
