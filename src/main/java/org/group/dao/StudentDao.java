package org.group.dao;

import org.group.database.utils.ConnectionManager;
import org.group.entity.Student;
import org.group.entity.Teacher;
import org.group.exception.DaoException;
import org.group.interfaces.Dao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentDao implements Dao<Long, Student> {
    private final static StudentDao INSERT_STUDENT = new StudentDao();

    private final static String SAVE_SQL = """
                                    INSERT INTO students
                                    (student_surname, student_first_name, student_last_name,birthday)
                                    VALUES (?, ?, ?, ?)
                                    """;

    private final static String DELETE_SQL = """
                                    DELETE FROM students
                                    WHERE students.student_id = ?
                                    """;

    private final static String FIND_ALL_SQL = """
                                    SELECT student_id ,student_surname, student_first_name, student_last_name, birthday
                                    FROM students
                                    """;

    private final static String FIND_BY_ID_SQL = FIND_ALL_SQL + """
                                    WHERE students.student_id = ?
                                    """;

    private final static String UPDATE_SQL = """
                                    UPDATE teachers
                                    SET teacher_surname = ?,
                                        teacher_first_name = ?,
                                        teacher_last_name = ?,
                                        birthday = ?
                                    WHERE teachers.teacher_id = ?
                                    """;

    public List<Student> findAll() {
        try(var connection = ConnectionManager.get();
            var statement = connection.prepareStatement(FIND_ALL_SQL)) {
            List<Student> perents = new ArrayList<>();

            var result = statement.executeQuery();

            while(result.next())
                perents.add(
                        build(result)
                );

            return perents;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private static Student build(ResultSet result) throws SQLException {
        return new Student(result.getLong("student_id"),
                result.getString("student_surname"),
                result.getString("student_first_name"),
                result.getString("student_last_name"),
                result.getDate("birthday").toLocalDate()
        );
    }

    public Student save(Student student) {
        try(var connection = ConnectionManager.get();
            var statement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)){

            statement.setString(1, student.getStudent_surname());
            statement.setString(2, student.getStudent_first_name());
            statement.setString(3, student.getStudent_last_name());
            statement.setDate(4, Date.valueOf(student.getBirthday()));

            statement.executeUpdate();
            var keys = statement.getGeneratedKeys();
            if(keys.next()){
                student.setStudent_id(keys.getLong(1));
            }

            return student;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public boolean delete(Long id) {
        try(var connection = ConnectionManager.get();
            var statement = connection.prepareStatement(DELETE_SQL)) {
            statement.setLong(1, id);

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public Optional<Student> findById(Long id) {
        try (var connection = ConnectionManager.get();
             var statement = connection.prepareStatement(FIND_BY_ID_SQL)){
            statement.setLong(1,id);
            var result = statement.executeQuery();

            Student student = null;
            if(result.next())
                student = build(result);
            return Optional.ofNullable(student);

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public boolean Update(Student student) {
        try(var connection = ConnectionManager.get();
            var statement = connection.prepareStatement(UPDATE_SQL)) {

            statement.setString(1, student.getStudent_last_name());
            statement.setString(2, student.getStudent_surname());
            statement.setString(3, student.getStudent_first_name());
            statement.setDate(4, Date.valueOf(student.getBirthday()));
            statement.setLong(5, student.getStudent_id());

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public static StudentDao getInsertPerent() {
        return INSERT_STUDENT;
    }

    private StudentDao(){}
}
