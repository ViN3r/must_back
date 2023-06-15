package com.example.must.myrmidons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @GetMapping("/authentification")
    public ResponseEntity authentification(@RequestParam("email") String email,
            @RequestParam("password") String password) {
        log.info("AuthentificationController en cours");
        if (authentificationService.authentification(email, password)) {
            log.info("AuthentificationController authentification ok");
            return ResponseEntity.ok().build();
        }
        log.info("AuthentificationController authentification refusé");
        return ResponseEntity.badRequest().build();
    }
}
