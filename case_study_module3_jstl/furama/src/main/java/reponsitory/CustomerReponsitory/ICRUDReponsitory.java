package reponsitory.CustomerReponsitory;

import model.Customer;
import model.CustomerType;

import java.sql.SQLException;
import java.util.List;

public interface ICRUDReponsitory {
    void insertCustomer(Customer customer);

    List<Customer> searchCustomer(String id , String diaChi, String email);

    List<Customer> selectAllCustomer();

    boolean deleteCustomer(String id) throws SQLException;


    void updateCustomer(Customer customer);

    Customer getCusstomer(int ma_khach_hang);

}
