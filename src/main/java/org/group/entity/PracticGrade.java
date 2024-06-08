package org.group.entity;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class PracticGrade {
    Long practic_id;
    List<Integer> practic_grade = new ArrayList<>();
    Student student;

    public PracticGrade() {
    }

    public PracticGrade(Long practic_id, List<Integer> practic_grade, Student student) {
        this.practic_id = practic_id;
        this.practic_grade = practic_grade;
        this.student = student;
    }

    public Long getPractic_id() {
        return practic_id;
    }

    public void setPractic_id(Long practic_id) {
        this.practic_id = practic_id;
    }

    public List<Integer> getPractic_grade() {
        return practic_grade;
    }

    public void setPractic_grade(List<Integer> practic_grade) {
        this.practic_grade = practic_grade;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PracticGrade that = (PracticGrade) o;
        return Objects.equals(practic_id, that.practic_id) && Objects.equals(practic_grade, that.practic_grade) && Objects.equals(student, that.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(practic_id, practic_grade, student);
    }

    @Override
    public String toString() {
        return "PracticGrade{" +
                "practic_id=" + practic_id +
                ", practic_grade=" + practic_grade +
                ", student=" + student +
                '}';
    }
}
