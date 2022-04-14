package model.service;

import model.Product;

import java.util.List;

public interface CrudSevice {


    List<Product> display();

    void save(Product product);

    void delete(int id);

    Product findById(int id);

    void update(int id, Product product);
}
