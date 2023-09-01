package com.knowledge_network.repository;

import com.knowledge_network.model.Teacher;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends Neo4jRepository<Teacher, Long> {
    @Query("MATCH (teacher:Teacher) " +
            "WHERE teacher.userName = $userName AND teacher.password = $password RETURN teacher")
    Optional<Teacher> findTeacherByUsernameAndPassword(String userName, String password);
}
