package com.example.must.myrmidons.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.must.myrmidons.domain.Membre;

public interface MembreRepository extends JpaRepository<Membre, Integer>, JpaSpecificationExecutor<Membre> {

    public Optional<Membre> findByNom(String nom);

}
