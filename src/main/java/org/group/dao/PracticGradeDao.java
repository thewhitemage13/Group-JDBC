package org.group.dao;

import org.group.database.utils.ConnectionManager;
import org.group.entity.PracticGrade;
import org.group.entity.Student;
import org.group.exception.DaoException;
import org.group.interfaces.Dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PracticGradeDao implements Dao<Long, PracticGrade> {
    private final static PracticGradeDao INSERT_PRACTICGRADE = new PracticGradeDao();

    private final static String FIND_ALL_SQL = """
                                    SELECT practic_id, practic_grade, student_id, student_surname, student_first_name, student_last_name, birthday
                                    FROM practics_grade
                                    JOIN students USING(student_id)
                                    """;

    private final static String SAVE_SQL = """
                                    INSERT INTO practics_grade
                                    (practic_grade, student_id)
                                    VALUES (?, ?)
                                    """;

    private final static String DELETE_SQL = """
                                    DELETE FROM practics_grade
                                    WHERE practics_grade.practic_id = ?
                                    """;

    private final static String FIND_BY_ID_SQL = FIND_ALL_SQL + """
                                    WHERE practic_id = ?
                                    """;

    private final static String UPDATE_SQL = """
                                    UPDATE practics_grade
                                    SET practic_grade = ?,
                                        student_id = ?
                                    WHERE practics_grade.practic_id = ?
                                    """;

    private List<Integer> parsePracticGrades(Array sqlArray) throws SQLException {
        Integer[] array = (Integer[]) sqlArray.getArray();
        return List.of(array);
    }

    @Override
    public List<PracticGrade> findAll() {
        try(var connection = ConnectionManager.get();
            var statement = connection.prepareStatement(FIND_ALL_SQL)) {
            List<PracticGrade> perents = new ArrayList<>();

            var result = statement.executeQuery();
            while(result.next()) {
                build(result);
            }
            return perents;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    private PracticGrade build(ResultSet result) throws SQLException {
        var student = new Student(result.getLong("student_id"),
                result.getString("student_surname"),
                result.getString("student_first_name"),
                result.getString("student_last_name"),
                result.getDate("birthday").toLocalDate()
        );

        return new PracticGrade(result.getLong("practic_id"),
                parsePracticGrades(result.getArray("practic_grade")),
                student
        );
    }

    @Override
    public PracticGrade save(PracticGrade practicGrade) {
        try(var connection = ConnectionManager.get();
            var statement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)){

            statement.setArray(1, connection.createArrayOf("INTEGER", practicGrade.getPractic_grade().toArray()));
            statement.setLong(2, practicGrade.getStudent().getStudent_id());

            statement.executeUpdate();
            var keys = statement.getGeneratedKeys();
            if(keys.next()){
                practicGrade.setPractic_id(keys.getLong(1));
            }

            return practicGrade;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean delete(Long id) {
        try(var connection = ConnectionManager.get();
            var statement = connection.prepareStatement(DELETE_SQL)) {
            statement.setLong(1, id);
            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public Optional<PracticGrade> findById(Long id) {
        try (var connection = ConnectionManager.get();
             var statement = connection.prepareStatement(FIND_BY_ID_SQL)){
            statement.setLong(1,id);
            var result = statement.executeQuery();

            PracticGrade practicGrade = null;
            if(result.next())
                practicGrade = build(result);
            return Optional.ofNullable(practicGrade);

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    @Override
    public boolean Update(PracticGrade practicGrade) {
        try(var connection = ConnectionManager.get();
            var statement = connection.prepareStatement(UPDATE_SQL)) {

            statement.setArray(1, connection.createArrayOf("INTEGER", practicGrade.getPractic_grade().toArray()));
            statement.setLong(2, practicGrade.getStudent().getStudent_id());
            statement.setLong(3, practicGrade.getPractic_id());

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public static PracticGradeDao getInsertPerent() {
        return INSERT_PRACTICGRADE;
    }

    private PracticGradeDao(){}
}
