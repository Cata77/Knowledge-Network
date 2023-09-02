package com.knowledge_network.controller;

import com.knowledge_network.dto.StudentDto;
import com.knowledge_network.model.Student;
import com.knowledge_network.service.StudentServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@SessionAttributes("user")
@RequestMapping("/v1/student")
public class StudentController{
    private final StudentServiceImpl studentServiceImpl;
    private final Logger logger = LogManager.getLogger(StudentController.class.getName());

    public StudentController(StudentServiceImpl studentServiceImpl) {
        this.studentServiceImpl = studentServiceImpl;
    }


    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        logger.log(Level.INFO, student);
        studentServiceImpl.saveUser(student);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(student);
    }

    @GetMapping("/profile")
    public ResponseEntity<StudentDto> showStudentProfile(@ModelAttribute("user") StudentDto student) {
        logger.log(Level.INFO, "Student details: {}", student);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(student);
    }
}
