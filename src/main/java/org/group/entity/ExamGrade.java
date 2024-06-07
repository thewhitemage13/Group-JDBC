package org.group.entity;

import java.util.Objects;

public class ExamGrade {
    private Long exams_grade_id;
    private Integer exams_grade;
    private Student student;

    public ExamGrade(Long exams_grade_id, Student student, Integer exams_grade) {
        this.exams_grade_id = exams_grade_id;
        this.student = student;
        this.exams_grade = exams_grade;
    }

    public ExamGrade() {
    }

    public Long getExams_grade_id() {
        return exams_grade_id;
    }

    public void setExams_grade_id(Long exams_grade_id) {
        this.exams_grade_id = exams_grade_id;
    }

    public Integer getExams_grade() {
        return exams_grade;
    }

    public void setExams_grade(Integer exams_grade) {
        this.exams_grade = exams_grade;
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
        ExamGrade examGrade = (ExamGrade) o;
        return Objects.equals(exams_grade_id, examGrade.exams_grade_id) && Objects.equals(exams_grade, examGrade.exams_grade) && Objects.equals(student, examGrade.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(exams_grade_id, exams_grade, student);
    }

    @Override
    public String toString() {
        return "ExamGrade{" +
               "exams_grade_id=" + exams_grade_id +
               ", exams_grade=" + exams_grade +
               ", student=" + student +
               '}';
    }
}
