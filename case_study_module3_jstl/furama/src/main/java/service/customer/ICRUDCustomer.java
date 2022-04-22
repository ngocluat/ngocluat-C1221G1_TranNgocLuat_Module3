package service.customer;

import model.Customer;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ICRUDCustomer {
    Map<String, String> insertCustomer(Customer customer);



    List<Customer> selectAllCustomer();

    boolean deleteCustomer(String id) throws SQLException;

    void updateCustomer(Customer customer);

    Customer getCusstomer(int id);


    List<Customer> seachCustomerSv(String name, String diaChi , String mail);



}
