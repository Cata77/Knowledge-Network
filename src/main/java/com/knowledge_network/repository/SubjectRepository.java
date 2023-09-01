package com.knowledge_network.repository;

import com.knowledge_network.model.Subject;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends Neo4jRepository<Subject, Long> {
}
