package model.service;

import model.model.User;
import reponsitory.impl.CRUDUserREponsitory;

import java.util.List;
// tầng sữ lý và validate

public class CRUDServiceImpl implements ICRUDService {
    CRUDUserREponsitory crudUserREponsitory = new CRUDUserREponsitory();

    @Override
    public void create(User user) {

    }

    @Override
    public void selectUsrt(int id) {

    }

    @Override
    public List<User> selectAll() {
        List<User> studentList = crudUserREponsitory.display();
        return studentList;
    }

    @Override
    public boolean deleteUser(int id) {
        return false;
    }

    @Override
    public boolean update(User user) {
        return false;
    }
}
