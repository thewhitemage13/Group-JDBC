package org.group.dao;

import org.group.database.utils.ConnectionManager;
import org.group.entity.Teacher;
import org.group.exception.DaoException;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TeacherDao {
    private final static TeacherDao INSERT_TEACHER = new TeacherDao();

    private final static String SAVE_SQL = """
                                    INSERT INTO teachers
                                    (teacher_surname, teacher_first_name, teacher_last_name, birthday)
                                    VALUES (?, ?, ?, ?)
                                    """;

    private final static String DELETE_SQL = """
                                    DELETE FROM teachers
                                    WHERE teachers.teacher_id = ?
                                    """;

    private final static String FIND_ALL_SQL = """
                                    SELECT teacher_id, teacher_surname,teacher_first_name, teacher_last_name, birthday
                                    FROM teachers
                                    """;

    private final static String FIND_BY_ID_SQL = FIND_ALL_SQL + """
                                    WHERE teachers.teacher_id = ?
                                    """;

    private final static String UPDATE_SQL = """
                                    UPDATE teachers
                                    SET teacher_surname = ?,
                                        teacher_first_name = ?,
                                        teacher_last_name = ?,
                                        birthday = ?
                                    WHERE teachers.teacher_id = ?
                                    """;

    public List<Teacher> findAll() {
        try(var connection = ConnectionManager.get();
            var statement = connection.prepareStatement(FIND_ALL_SQL)) {
            List<Teacher> perents = new ArrayList<>();

            var result = statement.executeQuery();
            while(result.next())
                perents.add(
                        new Teacher(result.getLong("teacher_id"),
                                result.getString("teacher_surname"),
                                result.getString("teacher_first_name"),
                                result.getString("teacher_last_name"),
                                result.getDate("birthday").toLocalDate()
                        )
                );

            return perents;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public Teacher save(Teacher teacher) {
        try(var connection = ConnectionManager.get();
            var statement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)){

            statement.setString(1, teacher.getTeacher_surname());
            statement.setString(2, teacher.getTeacher_first_name());
            statement.setString(3, teacher.getTeacher_last_name());
            statement.setDate(4, Date.valueOf(teacher.getBirthday()));

            statement.executeUpdate();
            var keys = statement.getGeneratedKeys();
            if(keys.next()){
                teacher.setTeacher_id(keys.getLong(1));
            }

            return teacher;
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

    public Optional<Teacher> FindById(Long id) {
        try (var connection = ConnectionManager.get();
             var statement = connection.prepareStatement(FIND_BY_ID_SQL)){
            statement.setLong(1,id);
            var result = statement.executeQuery();
            Teacher teacher = null;
            if(result.next())

                teacher = new Teacher(result.getLong("teacher_id"),
                        result.getString("teacher_surname"),
                        result.getString("teacher_first_name"),
                        result.getString("teacher_last_name"),
                        result.getDate("birthday").toLocalDate()
                );

            return Optional.ofNullable(teacher);

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public boolean Update(Teacher teacher) {
        try(var connection = ConnectionManager.get();
            var statement = connection.prepareStatement(UPDATE_SQL)) {

            statement.setString(1, teacher.getTeacher_last_name());
            statement.setString(2, teacher.getTeacher_surname());
            statement.setString(3, teacher.getTeacher_first_name());
            statement.setDate(4, Date.valueOf(teacher.getBirthday()));
            statement.setLong(5, teacher.getTeacher_id());

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public static TeacherDao getInsertPerent() {
        return INSERT_TEACHER;
    }

    private TeacherDao(){}
}
