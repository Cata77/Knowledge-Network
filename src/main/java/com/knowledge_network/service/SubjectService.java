package com.knowledge_network.service;

import com.knowledge_network.model.Subject;
import com.knowledge_network.repository.SubjectRepository;
import org.springframework.stereotype.Service;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public void saveSubject(Subject subject) {
        subjectRepository.save(subject);
    }
}
