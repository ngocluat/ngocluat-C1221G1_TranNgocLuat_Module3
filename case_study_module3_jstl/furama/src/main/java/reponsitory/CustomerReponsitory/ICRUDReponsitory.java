package reponsitory.CustomerReponsitory;

import model.Customer;

import java.sql.SQLException;
import java.util.List;

public interface ICRUDReponsitory {
    void insertCustomer(Customer customer);

    List<Customer> searchCustomer(String id);

    List<Customer> selectAllCustomer();

    boolean deleteCustomer(String id) throws SQLException;


    void updateCustomer(Customer customer);

    Customer getCusstomer(String ma_khach_hang);


}
