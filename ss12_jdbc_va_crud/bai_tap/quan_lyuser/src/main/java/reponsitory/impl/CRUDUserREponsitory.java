package reponsitory.impl;

import model.model.User;
import reponsitory.ICRUDReponsitory;
import reponsitory.KetNoiDataBase;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CRUDUserREponsitory implements ICRUDReponsitory {

    KetNoiDataBase ketNoiDataBase = new KetNoiDataBase();

    @Override
    public void create(User user) {

    }

    @Override
    public List<User> display() {
        List<User> userList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = ketNoiDataBase.getConnectionJavaToDB().prepareStatement("select id, `name`, email, country from usertest");
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();
            Integer id;
            String name;
            String email;
            String country;

            while (resultSet.next()) {

                id = resultSet.getInt("id");
                name = resultSet.getString("name");
                email = resultSet.getString("email");
                country = resultSet.getString("country");

                userList.add(new User(id, name, email, country));
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
    public boolean delete(int id) {
        return false;
    }

    @Override
    public List<User> search(int id) {
        return null;
    }

    @Override
    public boolean update(User user) {
        return false;
    }
}
