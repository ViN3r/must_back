package com.example.must.myrmidons.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.must.myrmidons.enumModel.Categorie;
import com.example.must.myrmidons.enumModel.Section;
import com.example.must.myrmidons.enumModel.TypeMembre;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/api/referentiel")
@Slf4j
public class ReferentielController {

    @GetMapping("/section")
    public ResponseEntity<Section[]> getSectionList() {
        return ResponseEntity.ok(Section.values());
    }

    @GetMapping("/categorie")
    public ResponseEntity<Categorie[]> getCategorie() {
        log.info("{}", Categorie.values());
        return ResponseEntity.ok(Categorie.values());
    }

    @GetMapping("/type")
    public ResponseEntity<TypeMembre[]> getType() {
        log.info("{}", TypeMembre.values());
        return ResponseEntity.ok(TypeMembre.values());
    }
}
