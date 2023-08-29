package com.example.must.myrmidons.service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.must.myrmidons.domain.Membre;
import com.example.must.myrmidons.dto.MembreDto;
import com.example.must.myrmidons.mapper.MembreMapper;
import com.example.must.myrmidons.repository.MembreRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MembreService {

    private final MembreRepository membreRepository;

    public MembreService(MembreRepository membreRepository) {
        this.membreRepository = membreRepository;
    }

    public MembreDto saveOrUpdateMembre(MembreDto membreDto) {
        log.info("Dans service saveOrUpdateMembre");
        if (Objects.isNull(membreDto.getId())) {
            Optional<Membre> membre = membreRepository.findByNom(membreDto.getNom());
            if (membre.isPresent()) {
                log.error("Membre existe déjà");
                return null;
            }
        }
        Membre membre = MembreMapper.INSTANCE.membreDtoToMembre(membreDto);

        this.membreRepository.save(membre);
        return MembreMapper.INSTANCE.membreToMembreDto(membre);
    }

    public List<MembreDto> getListMembreDto() {
        return MembreMapper.INSTANCE.map(this.membreRepository.findAll());
    }
}