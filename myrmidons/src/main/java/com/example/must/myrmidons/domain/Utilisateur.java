package com.example.must.myrmidons.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "Utilisateur")
public class Utilisateur {
    
    @Id 
    private int   id;
    private String  email;
    private String password;
}
