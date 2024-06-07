package org.group.entity;

import java.util.Objects;

public class HomeWorkGrade {
    private Long home_work_grade_id;
    private Integer home_work_grade;
    private Student student;

    public HomeWorkGrade() {
    }

    public HomeWorkGrade(Long home_work_grade_id, Student student, Integer home_work_grade) {
        this.home_work_grade_id = home_work_grade_id;
        this.student = student;
        this.home_work_grade = home_work_grade;
    }

    public Long getHome_work_grade_id() {
        return home_work_grade_id;
    }

    public void setHome_work_grade_id(Long home_work_grade_id) {
        this.home_work_grade_id = home_work_grade_id;
    }

    public Integer getHome_work_grade() {
        return home_work_grade;
    }

    public void setHome_work_grade(Integer home_work_grade) {
        this.home_work_grade = home_work_grade;
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
        HomeWorkGrade that = (HomeWorkGrade) o;
        return Objects.equals(home_work_grade_id, that.home_work_grade_id) && Objects.equals(home_work_grade, that.home_work_grade) && Objects.equals(student, that.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(home_work_grade_id, home_work_grade, student);
    }

    @Override
    public String toString() {
        return "HomeWorkGrade{" +
               "home_work_grade_id=" + home_work_grade_id +
               ", home_work_grade=" + home_work_grade +
               ", student=" + student +
               '}';
    }
}
