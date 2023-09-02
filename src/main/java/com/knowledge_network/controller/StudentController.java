package com.knowledge_network.controller;

import com.knowledge_network.dto.StudentDto;
import com.knowledge_network.model.Student;
import com.knowledge_network.model.User;
import com.knowledge_network.service.StudentService;
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
    private final StudentService studentService;
    private final Logger logger = LogManager.getLogger(StudentController.class.getName());

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        logger.log(Level.INFO, student);
        studentService.saveStudent(student);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(student);
    }

    @GetMapping("/profile")
    public ResponseEntity<StudentDto> showStudentProfile(@ModelAttribute("user") User user) {
        logger.log(Level.INFO, "Student details: {}", user);
        StudentDto studentDto = studentService.convertStudentToDto(user);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(studentDto);
    }
}
