package com.knowledge_network.repository;

import com.knowledge_network.model.Teacher;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends Neo4jRepository<Teacher, Long> {
}
