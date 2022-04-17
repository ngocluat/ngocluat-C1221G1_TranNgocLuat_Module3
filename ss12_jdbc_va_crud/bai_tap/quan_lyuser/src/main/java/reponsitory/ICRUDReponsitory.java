package reponsitory;

import model.model.User;

import java.util.List;

public interface ICRUDReponsitory {
    void create(User user);

    List<User> display();

    boolean delete(int id);

    List<User> search(int id);

    boolean update(User user);


}
