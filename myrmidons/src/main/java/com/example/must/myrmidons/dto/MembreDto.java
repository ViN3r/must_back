package com.example.must.myrmidons.dto;

import java.io.Serializable;

import com.example.must.myrmidons.enumModel.Categorie;
import com.example.must.myrmidons.enumModel.Section;
import com.example.must.myrmidons.enumModel.TypeMembre;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@JsonIgnoreProperties
@NoArgsConstructor
public class MembreDto implements Serializable {

    private int id;
    private TypeMembre typeMembre;
    private Section section;
    private Categorie categorie;

    @NotNull
    private String prenom;

    @NotNull
    private String nom;

}
