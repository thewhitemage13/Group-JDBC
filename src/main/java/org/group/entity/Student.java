package org.group.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

public class Student {
    private Long student_id;
    private String student_surname;
    private String student_first_name;
    private String student_last_name;
    private LocalDate birthday;

    public Student(Long student_id, String student_surname, String student_first_name, String student_last_name, LocalDate birthday) {
        this.student_id = student_id;
        this.student_surname = student_surname;
        this.student_first_name = student_first_name;
        this.student_last_name = student_last_name;
        this.birthday = birthday;
    }

    public Student() {
    }

    public Long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Long student_id) {
        this.student_id = student_id;
    }

    public String getStudent_surname() {
        return student_surname;
    }

    public void setStudent_surname(String student_surname) {
        this.student_surname = student_surname;
    }

    public String getStudent_first_name() {
        return student_first_name;
    }

    public void setStudent_first_name(String student_first_name) {
        this.student_first_name = student_first_name;
    }

    public String getStudent_last_name() {
        return student_last_name;
    }

    public void setStudent_last_name(String student_last_name) {
        this.student_last_name = student_last_name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return "Student{" +
               "student_id=" + student_id +
               ", student_surname='" + student_surname + '\'' +
               ", student_first_name='" + student_first_name + '\'' +
               ", student_last_name='" + student_last_name + '\'' +
               ", birthday=" + birthday +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(student_id, student.student_id) && Objects.equals(student_surname, student.student_surname) && Objects.equals(student_first_name, student.student_first_name) && Objects.equals(student_last_name, student.student_last_name) && Objects.equals(birthday, student.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(student_id, student_surname, student_first_name, student_last_name, birthday);
    }
}
