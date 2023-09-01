package com.knowledge_network.model;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Node
public class Student extends User{
    @Id
    @GeneratedValue
    private Long id;
    private BigDecimal credits;
    private List<Subject> trackSubjects;

    public Student(String firstName, String lastName, int age, String userName, String password, BigDecimal credits, List<Subject> trackSubjects) {
        super(firstName, lastName, age, userName, password);
        this.credits = BigDecimal.ZERO;
        this.trackSubjects = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getCredits() {
        return credits;
    }

    public void setCredits(BigDecimal credits) {
        this.credits = credits;
    }

    public List<Subject> getTrackSubjects() {
        return trackSubjects;
    }

    public void setTrackSubjects(List<Subject> trackSubjects) {
        this.trackSubjects = trackSubjects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id) && Objects.equals(credits, student.credits) && Objects.equals(trackSubjects, student.trackSubjects);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id, credits, trackSubjects);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", credits=" + credits +
                ", trackSubjects=" + trackSubjects +
                "}, " + super.toString();
    }
}
