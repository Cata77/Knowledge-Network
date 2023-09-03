package com.knowledge_network.service;

import com.knowledge_network.exception.SubjectNotFoundException;
import com.knowledge_network.model.Subject;
import com.knowledge_network.repository.SubjectRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SubjectService {
    private final SubjectRepository subjectRepository;

    public SubjectService(SubjectRepository subjectRepository) {
        this.subjectRepository = subjectRepository;
    }

    public void saveSubject(Subject subject) {
        subjectRepository.save(subject);
    }

    public Subject findSubjectById(Long id) {
        Optional<Subject> subject = subjectRepository.findById(id);
        if (subject.isPresent())
            return subject.get();
        throw new SubjectNotFoundException();
    }
}
