package com.knowledge_network.controller;

import com.knowledge_network.model.Subject;
import com.knowledge_network.service.SubjectService;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/subject")
public class SubjectController {
    private final SubjectService subjectService;
    private final Logger logger = LogManager.getLogger(SubjectController.class.getName());

    public SubjectController(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    @PostMapping("/create")
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject) {
        logger.log(Level.INFO, subject);
        subjectService.saveSubject(subject);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(subject);
    }
}
