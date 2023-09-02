package com.knowledge_network.service;

import com.knowledge_network.dto.TeacherDto;
import com.knowledge_network.model.Teacher;
import com.knowledge_network.model.User;
import com.knowledge_network.model.UserService;
import com.knowledge_network.repository.TeacherRepository;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImpl implements UserService {
    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public void saveUser(User user) {
        teacherRepository.save((Teacher) user);
    }

    @Override
    public Record convertUserToDto(User user) {
        Teacher teacher = (Teacher) user;

        return new TeacherDto(
                teacher.getId(),
                teacher.getFirstName(),
                teacher.getLastName(),
                teacher.getAge(),
                teacher.getSubjects()
        );
    }
}
