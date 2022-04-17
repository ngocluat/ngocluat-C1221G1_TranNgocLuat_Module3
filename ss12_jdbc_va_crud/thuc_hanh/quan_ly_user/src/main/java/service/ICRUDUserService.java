package service;

import model.model.User;

import java.util.List;

public interface ICRUDUserService {
    void insertUserSv(User user);

    User selectUserSv(int id);

    List<User> selectAllUsersSv();

    void deleteUserSv(int id);


    void updateUserSv(User user);

    List<User> seachSv (String  user);
}
