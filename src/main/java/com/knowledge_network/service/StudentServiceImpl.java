package com.knowledge_network.service;

import com.knowledge_network.dto.StudentDto;
import com.knowledge_network.model.Student;
import com.knowledge_network.model.User;
import com.knowledge_network.model.UserService;
import com.knowledge_network.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements UserService {
    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void saveUser(User user) {
        studentRepository.save((Student) user);
    }

    @Override
    public Record convertUserToDto(User user) {
        Student student = (Student) user;

        return new StudentDto(
                student.getFirstName(),
                student.getLastName(),
                student.getAge(),
                student.getCredits(),
                student.getTrackSubjects()
        );
    }
}
