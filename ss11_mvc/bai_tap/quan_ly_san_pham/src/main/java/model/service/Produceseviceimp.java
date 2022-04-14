package model.service;

import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Produceseviceimp implements CrudSevice {
    private static Map<Integer, Product> productMap;
    @Override
    public List<Product> display() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void save(Product product) {
        productMap.put(product.getId(), product);
    }

    @Override
    public void delete(int id) {

    }

    @Override
    public Product findById(int id) {
        return null;
    }

    @Override
    public void update(int id, Product product) {

    }
}
