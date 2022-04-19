package reponsitory.reponsitoryy.impl;

import model.model.User;
import reponsitory.reponsitoryy.IUserDAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements IUserDAO {
    private String jdbcURL = "jdbc:mysql://localhost:3306/demo";
    private String jdbcUsername = "root";
    private String jdbcPassword = "18082003";

    private static final String INSERT_USERS_SQL = "INSERT INTO users" + "  (`name`, email, country) VALUES " + " (?, ?, ?)";
    private static final String SELECT_USER_BY_ID = "select id,`name`,email,country from users where id =?";
    private static final String SELECT_ALL_USERS = "SELECT * FROM users order by `name` asc  ;";
//    private static final String DELETE_USERS_SQL = "delete from users where id = ?;";
//    private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";


    public UserDAO() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public void insertUser(User user) throws SQLException {
        System.out.println(INSERT_USERS_SQL);
        try (Connection connection = getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getCountry());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    public User selectUser(int id) {
        User user = null;
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                user = new User(id, name, email, country);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public List<User> selectAllUsers() {
        List<User> users = new ArrayList<>();
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String country = rs.getString("country");
                users.add(new User(id, name, email, country));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    public boolean deleteUser(int id) throws SQLException {

        boolean rowDeleted = false;
        PreparedStatement preparedStatement = null;
        try {
            CallableStatement callableStatement = getConnection().prepareCall("call delete_user(?)");
            callableStatement.setInt(1, id);
            rowDeleted = callableStatement.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                assert preparedStatement != null;
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return rowDeleted;

    }

    public boolean updateUser(User user) throws SQLException {
        boolean rowUpdated = false;
//        try (Connection connection = getConnection();
//             PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL)) {
//            statement.setString(1, user.getName());
//            statement.setString(2, user.getEmail());
//            statement.setString(3, user.getCountry());
//            statement.setInt(4, user.getId());
//            rowUpdated = statement.executeUpdate() > 0;
//        }
//        return rowUpdated;

        CallableStatement callableStatement = null;
        try {
            callableStatement = getConnection().prepareCall("call edit_user(?,?,?,?)");
            callableStatement.setInt(1, user.getId());
            callableStatement.setString(2, user.getName());
            callableStatement.setString(3, user.getEmail());
            callableStatement.setString(4, user.getCountry());
            rowUpdated = callableStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return rowUpdated;
    }

    @Override
    public List<User> seach(String user) {
        List<User> userList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement("select id, `name` , email, country from users where  `name` like ? or country like ?");
            preparedStatement.setString(1, "%" + user + "%");
            preparedStatement.setString(2, "%" + user + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            User user1;
            while (resultSet.next()) {
                user1 = new User();
                user1.setId(resultSet.getInt("id"));
                user1.setName(resultSet.getString("name"));
                user1.setEmail(resultSet.getString("email"));
                user1.setCountry(resultSet.getString("country"));
                userList.add(user1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userList;
    }

    @Override

    public List<User> getAllUser() {
        List<User> userList = new ArrayList<>();
        CallableStatement callableStatement = null;
        try {
            callableStatement = getConnection().prepareCall("call get_all_user");
            ResultSet resultSet = callableStatement.executeQuery();
            User user;
            while (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getInt("id"));
                user.setName(resultSet.getString("name"));
                user.setEmail(resultSet.getString("email"));
                user.setCountry(resultSet.getString("country"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                callableStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return userList;
    }


    @Override

    public void insertUserStore(User user) throws SQLException {

        try (Connection connection = getConnection();
             CallableStatement callableStatement = connection.prepareCall("CALL insert_user(?,?,?)");) {
            callableStatement.setString(1, user.getName());
            callableStatement.setString(2, user.getEmail());
            callableStatement.setString(3, user.getCountry());
            System.out.println(callableStatement);
            callableStatement.executeUpdate();
        } catch (SQLException e) {

            e.printStackTrace();

        }

    }


//    private void printSQLException(SQLException ex) {
//        for (Throwable e : ex) {
//            if (e instanceof SQLException) {
//                e.printStackTrace(System.err);
//                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
//                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
//                System.err.println("Message: " + e.getMessage());
//                Throwable t = ex.getCause();
//                while (t != null) {
//                    System.out.println("Cause: " + t);
//                    t = t.getCause();
//                }
//            }
//        }
//    }
}