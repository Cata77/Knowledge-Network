package com.knowledge_network.dto;

import com.knowledge_network.model.Subject;

import java.util.List;

public record TeacherDto(
        Long id,
        String firstName,
        String lastName,
        int age,
        List<Subject> subjects
) {}
