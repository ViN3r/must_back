package com.example.must.myrmidons.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.must.myrmidons.domain.Utilisateur;
import com.example.must.myrmidons.service.AuthentificationService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping
@Slf4j
public class AuthentificationController {

    private final AuthentificationService authentificationService;

    @Autowired
    public AuthentificationController(AuthentificationService authentificationService) {
        this.authentificationService = authentificationService;
    }

    @GetMapping("/api/authentification")
    @CrossOrigin(origins = "http://localhost:4200")
    public ResponseEntity authentification(@RequestParam("email") String email,
            @RequestParam("password") String password) {
        log.info("AuthentificationController en cours");
        Optional<Utilisateur> utilisateur = authentificationService.authentification(email, password);
        if (utilisateur.isPresent()) {
            log.info("AuthentificationController authentification ok");
            return ResponseEntity.ok().body(utilisateur.get());
        }
        log.info("AuthentificationController authentification refusé");
        return ResponseEntity.badRequest().build();
    }
}
