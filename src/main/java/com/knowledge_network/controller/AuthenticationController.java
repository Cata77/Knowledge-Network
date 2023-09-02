package com.knowledge_network.controller;

import com.knowledge_network.dto.AuthenticatedUserDto;
import com.knowledge_network.dto.StudentDto;
import com.knowledge_network.dto.TeacherDto;
import com.knowledge_network.model.Student;
import com.knowledge_network.model.User;
import com.knowledge_network.service.AuthenticationService;
import com.knowledge_network.service.StudentServiceImpl;
import com.knowledge_network.service.TeacherServiceImpl;
import jakarta.servlet.http.HttpSession;
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
@RequestMapping("/v1/authenticate")
public class AuthenticationController {
    private final AuthenticationService authenticationService;
    private final StudentServiceImpl studentService;
    private final TeacherServiceImpl teacherService;
    private final Logger logger = LogManager.getLogger(AuthenticationController.class.getName());

    public AuthenticationController(AuthenticationService authenticationService, StudentServiceImpl studentService, TeacherServiceImpl teacherService) {
        this.authenticationService = authenticationService;
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    @PostMapping
    public ResponseEntity<User> authenticateUser(
            @RequestBody AuthenticatedUserDto authenticatedUserDto,
            HttpSession session) {
        User user = authenticationService.authenticateUser(authenticatedUserDto);
        if (user instanceof Student) {
            StudentDto studentDto = (StudentDto) studentService.convertUserToDto(user);
            session.setAttribute("user", studentDto);
        } else {
            TeacherDto teacherDto = (TeacherDto) teacherService.convertUserToDto(user);
            session.setAttribute("user", teacherDto);
        }
        logger.log(Level.INFO, "Authenticated user: {}.", user);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(user);
    }
}
