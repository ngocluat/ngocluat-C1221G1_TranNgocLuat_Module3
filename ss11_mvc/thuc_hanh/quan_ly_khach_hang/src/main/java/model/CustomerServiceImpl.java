package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements CustomerService {
    private static Map<Integer, Customer> customersMap;

    static {
        customersMap = new HashMap<>();
        customersMap.put(1, new Customer(1, "John", "john@codegym.vn", "Hanoi"));
        customersMap.put(2, new Customer(2, "Bill", "bill@codegym.vn", "Danang"));
        customersMap.put(3, new Customer(3, "Alex", "alex@codegym.vn", "Saigon"));
        customersMap.put(4, new Customer(4, "Adam", "adam@codegym.vn", "Beijin"));
        customersMap.put(5, new Customer(5, "Sophia", "sophia@codegym.vn", "Miami"));
        customersMap.put(6, new Customer(6, "Rose", "rose@codegym.vn", "Newyork"));
    }

    @Override
    public List<Customer> display() {
        return new ArrayList<>(customersMap.values());
    }

    @Override
    public void save(Customer customer) {
        customersMap.put(customer.getId(), customer);
    }

    @Override
    public Customer findById(int id) {
        return customersMap.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customersMap.put(id, customer);
    }

    @Override
    public void delete (int id) {
        customersMap.remove(id);
    }
}
