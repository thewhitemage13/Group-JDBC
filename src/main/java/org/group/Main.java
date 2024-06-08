package org.group;

import org.group.dao.PracticGradeDao;
import org.group.dao.StudentDao;
import org.group.dao.TeacherDao;
import org.group.entity.PracticGrade;
import org.group.entity.Student;
import org.group.entity.Teacher;

import java.sql.Array;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Date.valueOf;
import static java.time.LocalDate.*;

public class Main {
    public static void main(String[] args) {
//        var studentDao = StudentDao.getInsertPerent();
//        Student student = new Student();
//        student.setStudent_first_name("Ivan");
//        student.setStudent_last_name("Bazelyan");
//        student.setStudent_surname("Ivanovich");
//
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
//        LocalDate birthday = LocalDate.parse("08.12.2007", formatter);
//        student.setBirthday(birthday);
//
//// Сохраняем студента
////        student = studentDao.save(student);
//
//        var practicGradeDao = PracticGradeDao.getInsertPerent();
//        PracticGrade practicGrade = new PracticGrade();
//        practicGrade.setStudent(student); // Устанавливаем сохраненного студента
//
//        List<Integer> praccric = new ArrayList<>();
//        praccric.add(12);
//        praccric.add(8);
//        praccric.add(8);
//        praccric.add(10);
//        practicGrade.setPractic_grade(praccric);
//
////        System.out.println(practicGradeDao.findAll());
////        practicGradeDao.save(practicGrade);
//        System.out.println(practicGradeDao.findById(1L));
    }
}