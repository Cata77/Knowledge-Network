package com.knowledge_network.service;

import com.knowledge_network.dto.AuthenticatedUserDto;
import com.knowledge_network.exception.UserNotFoundException;
import com.knowledge_network.model.Student;
import com.knowledge_network.model.Teacher;
import com.knowledge_network.model.User;
import com.knowledge_network.repository.StudentRepository;
import com.knowledge_network.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;

    public AuthenticationService(StudentRepository studentRepository, TeacherRepository teacherRepository) {
        this.studentRepository = studentRepository;
        this.teacherRepository = teacherRepository;
    }

    public User authenticateUser(AuthenticatedUserDto authenticatedUserDto) {
        Optional<Student> student = studentRepository.findStudentByUsernameAndPassword(
                authenticatedUserDto.getUserName(), authenticatedUserDto.getPassword());
        if (student.isPresent())
            return student.get();

        Optional<Teacher> teacher = teacherRepository.findTeacherByUsernameAndPassword(
                authenticatedUserDto.getUserName(), authenticatedUserDto.getPassword());
        if (teacher.isPresent())
            return teacher.get();

        throw new UserNotFoundException();
    }
}
