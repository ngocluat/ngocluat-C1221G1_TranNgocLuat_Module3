package service.customer;

import model.Customer;
import reponsitory.CustomerReponsitory.CustomerReponsitoryImpl;

import java.sql.SQLException;
import java.util.List;

public class CustomerServiceImpl implements ICRUDCustomer {
    CustomerReponsitoryImpl customerReponsitory = new CustomerReponsitoryImpl();

    @Override
    public void insertCustomer(Customer customer) {
        customerReponsitory.insertCustomer(customer);
    }


    public  List<Customer>  selectCustomer(String id) {
        return customerReponsitory.searchCustomer(id);
    }

    @Override
    public List<Customer> selectAllCustomer() {
        return customerReponsitory.selectAllCustomer();
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException {
        return customerReponsitory.deleteCustomer(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        customerReponsitory.updateCustomer(customer);
    }

    @Override
    public List<Customer> seachCustomerSv(String customer) {
        return customerReponsitory.searchCustomer(customer);
    }

    @Override
    public Customer getCusstomer(String id) {
        return customerReponsitory.getCusstomer(id);
    }
}
