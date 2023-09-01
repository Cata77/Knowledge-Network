package com.knowledge_network.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Node
public class Teacher extends User{
    @Id
    @GeneratedValue
    private Long id;
    private List<Subject> subjects;

    public Teacher(String firstName, String lastName, int age, String userName, String password, List<Subject> subjects) {
        super(firstName, lastName, age, userName, password);
        this.subjects = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<Subject> subjects) {
        this.subjects = subjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(id, teacher.id) && Objects.equals(subjects, teacher.subjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, subjects);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", subjects=" + subjects +
                "}, " + super.toString();
    }
}
