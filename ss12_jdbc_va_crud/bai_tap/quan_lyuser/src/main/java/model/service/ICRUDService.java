package model.service;

import model.model.User;

import java.util.List;

public interface ICRUDService {
    void create(User user);

    void selectUsrt(int id);

    List<User> selectAll();

    boolean deleteUser(int id);


    boolean update(User user);
}
