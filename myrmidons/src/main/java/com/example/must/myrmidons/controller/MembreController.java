package com.example.must.myrmidons.controller;

import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.must.myrmidons.dto.MembreDto;
import com.example.must.myrmidons.dto.SearchMembreDto;
import com.example.must.myrmidons.enumModel.Section;
import com.example.must.myrmidons.service.MembreService;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/api/membres")
public class MembreController {

    private final MembreService membreService;

    public MembreController(MembreService membreService) {
        this.membreService = membreService;
    }

    @PostMapping(consumes = { "application/json" })
    public MembreDto ajoutMembre(@RequestBody final MembreDto membre) {
        return membreService.saveOrUpdateMembre(membre);
    }

    @GetMapping()
    public ResponseEntity<SearchMembreDto> getMembres(
            @RequestParam(name = "search", required = false) String search,
            @RequestParam(required = false) String limit,
            @RequestParam int pageIndex,
            @RequestParam int pageSize) {
        return ResponseEntity.ok(membreService.search(pageIndex, pageSize));
    }
}
