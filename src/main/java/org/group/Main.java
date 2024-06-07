package org.group;

import org.group.dao.TeacherDao;
import org.group.entity.Teacher;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.sql.Date.valueOf;

public class Main {
    public static void main(String[] args) {




//        var teacherDao = TeacherDao.getInsertPerent();
//        Teacher teacher = teacherDao.FindById(3L).get();
//        System.out.println(teacher);
//        teacher.setTeacher_surname("LULU");
//        System.out.println(teacherDao.Update(teacher));
//        System.out.println(teacher);

//        Teacher teacher2 = new Teacher();
//
//        teacher2.setTeacher_first_name("Mukhammed");
//        teacher2.setTeacher_surname("Lolo");
//        teacher2.setTeacher_last_name("Kamel");
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
//        LocalDate birthday = LocalDate.parse("04.02.2000", formatter);
//        teacher2.setBirthday(birthday);
//
//        teacherDao.save(teacher2);
//        System.out.println(teacherDao.findAll());
    }
}