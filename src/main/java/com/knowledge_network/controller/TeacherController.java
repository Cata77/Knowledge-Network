package com.knowledge_network.controller;

import com.knowledge_network.dto.TeacherDto;
import com.knowledge_network.model.Teacher;
import com.knowledge_network.model.User;
import com.knowledge_network.service.TeacherServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@SessionAttributes("user")
@RequestMapping("/v1/teacher")
public class TeacherController {
    private final TeacherServiceImpl teacherServiceImpl;
    private final Logger logger = LogManager.getLogger(TeacherController.class.getName());

    public TeacherController(TeacherServiceImpl teacherServiceImpl) {
        this.teacherServiceImpl = teacherServiceImpl;
    }

    @PostMapping("/create")
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher) {
        logger.log(Level.INFO, teacher);
        teacherServiceImpl.saveUser(teacher);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(teacher);
    }

    @GetMapping("/profile")
    public ResponseEntity<TeacherDto> showTeacherProfile(@ModelAttribute("user") User user) {
        logger.log(Level.INFO, "Teacher details: {}", user);
        TeacherDto teacherDto = (TeacherDto) teacherServiceImpl.convertUserToDto(user);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(teacherDto);
    }
}
