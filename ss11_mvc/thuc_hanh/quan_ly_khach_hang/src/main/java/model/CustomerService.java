package model;

import java.util.List;

public interface CustomerService {
    List<Customer> display();

    void save(Customer customer);

    void delete(int id);

    Customer findById(int id);

    void update(int id, Customer customer);
}
