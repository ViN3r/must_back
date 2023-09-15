package com.example.must.myrmidons.repository.specification;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

import org.springframework.data.jpa.domain.Specification;

public class BddSpecification<T> {

    private BddSpecification() {
        throw new IllegalStateException("Utility class");
    }
}