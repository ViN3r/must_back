package com.example.must.myrmidons.service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import com.example.must.myrmidons.domain.Membre;
import com.example.must.myrmidons.dto.MembreDto;
import com.example.must.myrmidons.dto.SearchMembreDto;
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
        if (Objects.isNull(membreDto.getId())) {
            Optional<Membre> membre = membreRepository.findByNom(membreDto.getNom());
            if (membre.isPresent()) {
                //TODO Modification d'un membre
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

    public SearchMembreDto search(int pageIndex, int pageSize) {
        final Pageable page = PageRequest.of(pageIndex, pageSize);
        Page<Membre> pageMembre = null;
        Specification<Membre> spec = null;

        if (Objects.isNull(spec)) {
            pageMembre = this.membreRepository.findAll(page);
        } else {
            log.info("Pas encore fait");
        }
        return SearchMembreDto.builder().data(MembreMapper.INSTANCE.map(pageMembre.getContent()))
                .totalElement(pageMembre.getTotalElements()).currentPage(pageIndex).build();
    }
}