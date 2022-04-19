package service.customer;

import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICRUDCustomer {
    void insertCustomer(Customer customer);

    List<Customer> selectCustomer(String id);

    List<Customer> selectAllCustomer();

    boolean deleteCustomer(String id) throws SQLException;

    void updateCustomer(Customer customer);

    List<Customer> seachCustomerSv(String user);

    Customer getCusstomer(String id);
}
