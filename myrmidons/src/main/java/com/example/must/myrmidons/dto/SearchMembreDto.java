package com.example.must.myrmidons.dto;

import java.io.Serializable;
import java.util.Collection;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SearchMembreDto implements Serializable {

    private Collection<MembreDto> data;
    private long totalElement;
    private int currentPage;
}