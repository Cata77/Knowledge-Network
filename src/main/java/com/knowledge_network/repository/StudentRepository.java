package com.knowledge_network.repository;

import com.knowledge_network.model.Student;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends Neo4jRepository<Student, Long> {
}
