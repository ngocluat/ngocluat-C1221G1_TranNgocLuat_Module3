package model;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
     void insertUser(User user) throws SQLException;

    public User selectUser(int id);

    public List<User> selectAllUsers();

    public boolean deleteUser(int id) throws SQLException;

    public boolean updateUser(User user) throws SQLException;

}
