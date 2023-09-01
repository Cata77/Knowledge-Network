package com.knowledge_network.controller;

import com.knowledge_network.model.Teacher;
import com.knowledge_network.service.TeacherService;
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
@RequestMapping("/v1/teacher")
public class TeacherController {
    private final TeacherService teacherService;
    private final Logger logger = LogManager.getLogger(TeacherController.class.getName());

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @PostMapping("/create")
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher){
        logger.log(Level.INFO, teacher);
        teacherService.saveTeacher(teacher);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(teacher);
    }
}
