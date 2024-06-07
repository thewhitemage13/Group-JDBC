package org.group.entity;

import java.util.Objects;

public class PracticGrade {
    private Long practic_id;
    private Integer practic_grade;
    private Student student;

    public PracticGrade() {
    }

    public PracticGrade(Long practic_id, Student student, Integer practic_grade) {
        this.practic_id = practic_id;
        this.student = student;
        this.practic_grade = practic_grade;
    }

    public Long getPractic_id() {
        return practic_id;
    }

    public void setPractic_id(Long practic_id) {
        this.practic_id = practic_id;
    }

    public Integer getPractic_grade() {
        return practic_grade;
    }

    public void setPractic_grade(Integer practic_grade) {
        this.practic_grade = practic_grade;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "PracticGrade{" +
               "practic_id=" + practic_id +
               ", practic_grade=" + practic_grade +
               ", student=" + student +
               '}';
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
}
