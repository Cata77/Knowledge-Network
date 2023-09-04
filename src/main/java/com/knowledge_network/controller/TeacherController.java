package com.knowledge_network.controller;

import com.knowledge_network.dto.TeacherDto;
import com.knowledge_network.model.Teacher;
import com.knowledge_network.service.TeacherServiceImpl;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes("user")
@RequestMapping("/v1/teacher")
public class TeacherController {
    private final TeacherServiceImpl teacherServiceImpl;
    private final Logger logger = LogManager.getLogger(TeacherController.class.getName());

    public TeacherController(TeacherServiceImpl teacherServiceImpl) {
        this.teacherServiceImpl = teacherServiceImpl;
    }

    @GetMapping("/register")
    public String showTeacherRegisterForm(Model model) {
        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);
        return "teacherRegister.html";
    }

    @PostMapping("/register")
    public String createTeacher(@ModelAttribute Teacher teacher) {
        logger.log(Level.INFO, teacher);
        teacherServiceImpl.saveUser(teacher);
        return "redirect:/v1/authenticate";
    }

    @GetMapping("/profile")
    public ResponseEntity<TeacherDto> showTeacherProfile(@ModelAttribute("user") TeacherDto teacher) {
        logger.log(Level.INFO, "Teacher details: {}", teacher);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(teacher);
    }
}
