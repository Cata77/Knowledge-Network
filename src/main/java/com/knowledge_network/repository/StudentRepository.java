package com.knowledge_network.repository;

import com.knowledge_network.model.Student;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends Neo4jRepository<Student, Long> {
    @Query("MATCH (student:Student) " +
            "WHERE student.userName = $userName AND student.password = $password RETURN student")
    Optional<Student> findStudentByUsernameAndPassword(String userName, String password);
}
