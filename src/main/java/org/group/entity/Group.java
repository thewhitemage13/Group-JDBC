package org.group.entity;

import java.util.Objects;

public class Group {
    private Long group_academy_id;
    private String group_name;

    public Group() {
    }

    public Group(Long group_academy_id, String group_name) {
        this.group_academy_id = group_academy_id;
        this.group_name = group_name;
    }

    public String getGroup_name() {
        return group_name;
    }

    public void setGroup_name(String group_name) {
        this.group_name = group_name;
    }

    public Long getGroup_academy_id() {
        return group_academy_id;
    }

    public void setGroup_academy_id(Long group_academy_id) {
        this.group_academy_id = group_academy_id;
    }

    @Override
    public String toString() {
        return "Group{" +
               "group_academy_id=" + group_academy_id +
               ", group_name='" + group_name + '\'' +
               '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return Objects.equals(group_academy_id, group.group_academy_id) && Objects.equals(group_name, group.group_name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(group_academy_id, group_name);
    }
}
