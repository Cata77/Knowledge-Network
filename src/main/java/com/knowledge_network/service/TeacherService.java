package com.knowledge_network.service;

import com.knowledge_network.model.Teacher;
import com.knowledge_network.repository.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public TeacherService(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public void saveTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }
}
