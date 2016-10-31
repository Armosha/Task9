package nb.bean.dao.impl;

import nb.bean.dao.TestDAO;
import nb.bean.dao.exeption.DAOException;
import nb.bean.dao.impl.pool.ConnectionPool;
import nb.bean.entity.Questions;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


public class TestDAOImpl implements TestDAO {

    @Override
    public List<Questions> findByTest(int id) throws DAOException {

        Connection connection = null;

        List<Questions> list = new ArrayList<>();
        System.out.println("==============" + id);
        try {
            ResultSet resultSet;
            connection = ConnectionPool.getInstance().getConnection();
            try (Statement statement = connection.createStatement()) {

                resultSet = statement.executeQuery(
                        "SELECT Question,  IdTest, IdRightAnswer FROM QUESTIONS WHERE idTest='" + id + "';");
                while (resultSet.next()) {
                    list.add(new Questions(resultSet.getString(1), resultSet.getInt(2), resultSet.getInt(3)));
                }
            }

        } catch (InterruptedException | SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            try {
                ConnectionPool.getInstance().returnConnection(connection);
            } catch (SQLException | InterruptedException e) {
                throw new DAOException(e.getMessage());
            }
        }
        return list;
    }

    @Override
    public List<Questions> findForAddingTest(int subject, int numberOfTest, int amtOfQuest) throws DAOException {
        Connection connection = null;
        List<Questions> list = new ArrayList<>();

        try {
            ResultSet resultSet = null;
            connection = ConnectionPool.getInstance().getConnection();
            try (Statement statement = connection.createStatement()) {
                System.out.println("==============" + amtOfQuest);
                resultSet = statement.executeQuery(
                        "SELECT Question, IdTest, IdCorrectAnswer FROM QUESTIONS WHERE IdSubject=" + subject + ";");

                while (resultSet.next()) {
                    list.add(new Questions(resultSet.getString(1), resultSet.getInt(2), resultSet.getInt(3)));

                    try (Statement statement2 = connection.createStatement()) {
                        int result = statement2.executeUpdate(
                                "UPDATE QUESTIONS set IdTest =" + numberOfTest + " WHERE IdSubject=" + subject);
                    }

                }
            }

        } catch (InterruptedException | SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            try {
                ConnectionPool.getInstance().returnConnection(connection);
            } catch (SQLException | InterruptedException e) {
                throw new DAOException(e.getMessage());
            }
        }
        return list;
    }

    @Override
    public void addQuestion(Questions questions) throws DAOException {

        Connection connection = null;
        try {
            connection = ConnectionPool.getInstance().getConnection();
            System.out.println(questions.getData());
            try (Statement statement = connection.createStatement()) {

                connection.setAutoCommit(false);
                int idanswer = 0;

                String SQL = "INSERT INTO allanswers (answer) " + "VALUES( '" + questions.getAnswer() + "')";
                statement.addBatch(SQL);

                String SQL2 = "INSERT INTO allanswers (answer) " + "VALUES( '" + questions.getWrongAnsw() + "')";
                statement.addBatch(SQL2);
                int[] count = statement.executeBatch();
                connection.commit();
                ResultSet resultSet = null;

                try (Statement statement2 = connection.createStatement()) {

                    resultSet = statement2
                            .executeQuery("SELECT idanswer FROM allanswers WHERE Answer='" + questions.getAnswer() + "';");
                    while (resultSet.next()) {
                        idanswer = resultSet.getInt(1);
                    }
                }
                System.out.println(idanswer);

                String SQL3 = "INSERT INTO QUESTIONS (Question, IdSubject, IdRightAnswer) " + "VALUES( '" + questions.getData()
                        + "', '" + questions.getSubject() + "', '" + idanswer + "')";
                statement.addBatch(SQL3);
                int[] count2 = statement.executeBatch();
                connection.commit();

            }
        } catch (InterruptedException | SQLException e) {
            throw new DAOException(e.getMessage());
        } finally {
            try {
                ConnectionPool.getInstance().returnConnection(connection);
            } catch (SQLException | InterruptedException e) {
                throw new DAOException(e.getMessage());
            }
        }
    }
}

