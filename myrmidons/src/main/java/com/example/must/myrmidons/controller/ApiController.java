package com.example.must.myrmidons.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api")
@Slf4j
public class ApiController {

    @GetMapping("/hello")
    public void apiHelloConnected(Principal principal) {
        log.info("Api ok car je suis connecté, {}", principal);
    }
}
