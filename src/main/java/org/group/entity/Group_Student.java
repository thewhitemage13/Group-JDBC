package org.group.entity;

import java.util.Objects;

public class Group_Student {
    private Group group;
    private Student student;

    public Group_Student() {
    }

    public Group_Student(Group group, Student student) {
        this.group = group;
        this.student = student;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
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
        Group_Student that = (Group_Student) o;
        return Objects.equals(group, that.group) && Objects.equals(student, that.student);
    }

    @Override
    public int hashCode() {
        return Objects.hash(group, student);
    }

    @Override
    public String toString() {
        return "Group_Student{" +
               "group=" + group +
               ", student=" + student +
               '}';
    }
}
