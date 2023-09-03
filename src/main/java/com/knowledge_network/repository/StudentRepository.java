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

    @Query("""
            MATCH (student:Student)
            WITH student
            MATCH (subject:Subject)
            WHERE ID(student) = $studentId AND ID(subject) = $subjectId
            CREATE (student) -[:ENROLLED_IN]-> (subject)""")
    void createRelationshipBetweenStudentAndCourse(Long studentId, Long subjectId);
}
