package com.knowledge_network.dto;

import com.knowledge_network.model.Subject;

import java.math.BigDecimal;
import java.util.List;

public record StudentDto(
        Long id,
        String firstName,
        String lastName,
        int age,
        BigDecimal credits,
        List<Subject> trackSubjects
) {}
