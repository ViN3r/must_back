package com.example.must.myrmidons.domain;

import com.example.must.myrmidons.enumModel.Categorie;
import com.example.must.myrmidons.enumModel.Section;
import com.example.must.myrmidons.enumModel.TypeMembre;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Builder
@Entity(name = "Membres")
@NoArgsConstructor
public class Membre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    private String prenom;
    private String adresse;
    private String dateNaissance;

    @Enumerated(EnumType.ORDINAL)
    private Categorie categorie;
    @Enumerated(EnumType.ORDINAL)
    private Section section;
    @Enumerated(EnumType.ORDINAL)
    private TypeMembre typeMembres;
}
