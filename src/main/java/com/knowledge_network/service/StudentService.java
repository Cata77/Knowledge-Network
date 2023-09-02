package com.knowledge_network.service;

import com.knowledge_network.dto.StudentDto;
import com.knowledge_network.model.Student;
import com.knowledge_network.model.User;
import com.knowledge_network.repository.StudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    public StudentDto convertStudentToDto(User user) {
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
