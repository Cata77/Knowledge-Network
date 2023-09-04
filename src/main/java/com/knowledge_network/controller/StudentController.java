package com.knowledge_network.controller;

import com.knowledge_network.dto.StudentDto;
import com.knowledge_network.model.Student;
import com.knowledge_network.model.Subject;
import com.knowledge_network.service.StudentServiceImpl;
import com.knowledge_network.service.SubjectService;
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
@RequestMapping("/v1/student")
public class StudentController{
    private final StudentServiceImpl studentServiceImpl;
    private final SubjectService subjectService;
    private final Logger logger = LogManager.getLogger(StudentController.class.getName());

    public StudentController(StudentServiceImpl studentServiceImpl, SubjectService subjectService) {
        this.studentServiceImpl = studentServiceImpl;
        this.subjectService = subjectService;
    }

    @GetMapping("/register")
    public String showStudentRegisterForm(Model model) {
        Student student = new Student();
        model.addAttribute("student", student);
        return "studentRegister.html";
    }

    @PostMapping("/register")
    public String createStudent(@ModelAttribute Student student) {
        logger.log(Level.INFO, student);
        studentServiceImpl.saveUser(student);
        return "redirect:/v1/authenticate";
    }

    @GetMapping("/profile")
    public ResponseEntity<StudentDto> showStudentProfile(@ModelAttribute("user") StudentDto student) {
        logger.log(Level.INFO, "Student details: {}", student);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(student);
    }

    @GetMapping("/course/{id}")
    public ResponseEntity<String> enrollStudentToCourse(@PathVariable("id") String id,
            @ModelAttribute("user") StudentDto student) {
        Subject subject = subjectService.findSubjectById(Long.valueOf(id));
        studentServiceImpl.createRelationship(student.id(), subject.getId());
        logger.log(Level.INFO, "Student #{} enrolled to {} course", student.id(), subject.getName());
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Successfully enrolled to " + subject.getName() + " course!");
    }
}
