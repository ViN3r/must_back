package com.example.must.myrmidons.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping
@Slf4j
public class AuthentificationController {
    
    @Autowired
    public  AuthentificationController() {

    }


    @GetMapping("/authentification")
    public ResponseEntity authentification()  {
        log.info("AuthentificationController en cours");
        return ResponseEntity.ok().build();
    }
}

