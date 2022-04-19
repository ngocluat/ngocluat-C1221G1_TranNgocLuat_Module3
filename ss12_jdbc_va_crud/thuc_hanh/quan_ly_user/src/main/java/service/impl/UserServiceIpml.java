package service.impl;

import model.model.User;
import reponsitory.reponsitoryy.IUserDAO;
import reponsitory.reponsitoryy.impl.UserDAO;
import service.ICRUDUserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceIpml  implements ICRUDUserService {

    IUserDAO iUserDAO= new UserDAO();
    @Override
    public void insertUserSv(User user) {
        try {
            iUserDAO.insertUser(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public User selectUserSv(int id) {
        return iUserDAO.selectUser(id);
    }

    @Override
    public List<User> selectAllUsersSv() {
        return iUserDAO.getAllUser();
    }

    @Override
    public void deleteUserSv(int id) {
        try {
             iUserDAO.deleteUser(id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void updateUserSv(User user) {
        try {
             iUserDAO.updateUser(user);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<User> seachSv(String user) {
        return iUserDAO.seach(user);
    }

    @Override
    public List<User> getAllUser() {
        return iUserDAO.getAllUser();
    }

    @Override
    public void deleteUser(int user) throws SQLException {
        iUserDAO.deleteUser(user);
    }

//    IUserDAO iUserDAO = new UserDAO();
//
//    @Override
//    public void insertUser(User user) throws SQLException {
//        iUserDAO.insertUser(user);
//    }
//
//    @Override
//    public void insertUser(User user) {
//
//    }
//
//    @Override
//    public User selectUser(int id) {
//        return iUserDAO.selectUser(id);
//    }
//
//    @Override
//    public List<User> selectAllUsers() {
//        return iUserDAO.selectAllUsers();
//    }
//
//    @Override
//    public boolean deleteUser(int id) {
//        try {
//            return iUserDAO.deleteUser(id);
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return false;
//    }
//
//    @Override
//    public boolean updateUser(User user) throws SQLException {
//        return iUserDAO.updateUser(user);
//    }
//
//    @Override
//    public List<User> seach(String user) {
//        return iUserDAO.seach(user);
//    }
}
