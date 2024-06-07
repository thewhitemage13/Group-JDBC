package org.group.entity;


import java.time.LocalDate;
import java.util.Objects;

public class Teacher {
    private Long teacher_id;
    private String teacher_surname;
    private String teacher_first_name;
    private String teacher_last_name;
    private LocalDate birthday;

    public Teacher() {
    }

    public Teacher(Long teacher_id, String teacher_surname, String teacher_first_name, String teacher_last_name, LocalDate birthday) {
        this.teacher_id = teacher_id;
        this.teacher_surname = teacher_surname;
        this.teacher_first_name = teacher_first_name;
        this.teacher_last_name = teacher_last_name;
        this.birthday = birthday;
    }

    public Long getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Long teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getTeacher_surname() {
        return teacher_surname;
    }

    public void setTeacher_surname(String teacher_surname) {
        this.teacher_surname = teacher_surname;
    }

    public String getTeacher_first_name() {
        return teacher_first_name;
    }

    public void setTeacher_first_name(String teacher_first_name) {
        this.teacher_first_name = teacher_first_name;
    }

    public String getTeacher_last_name() {
        return teacher_last_name;
    }

    public void setTeacher_last_name(String teacher_last_name) {
        this.teacher_last_name = teacher_last_name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(teacher_id, teacher.teacher_id) && Objects.equals(teacher_surname, teacher.teacher_surname) && Objects.equals(teacher_first_name, teacher.teacher_first_name) && Objects.equals(teacher_last_name, teacher.teacher_last_name) && Objects.equals(birthday, teacher.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(teacher_id, teacher_surname, teacher_first_name, teacher_last_name, birthday);
    }

    @Override
    public String toString() {
        return "Teacher{" +
               "teacher_id=" + teacher_id +
               ", teacher_surname='" + teacher_surname + '\'' +
               ", teacher_first_name='" + teacher_first_name + '\'' +
               ", teacher_last_name='" + teacher_last_name + '\'' +
               ", birthday=" + birthday +
               '}';
    }
}
