package model.reponsitory;

import model.Product;
import model.service.CrudSevice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductseviceImp implements CrudSevice {
    private static Map<Integer, Product> productMap;


    static {
        productMap = new HashMap<>();
        productMap.put(1, new Product(1, "bánh", "ngon ngọt", 111));
        productMap.put(2, new Product(2, "kẹo", "kẹo mút ", 11111));
        productMap.put(3, new Product(3, "máy tính ", "windown 11", 1111));
        productMap.put(4, new Product(4, "vỡ ", "Thiên Long n", 222));
        productMap.put(5, new Product(5, "sách ", "Sách giáo khoa", 3333));
        productMap.put(6, new Product(6, "heo đất ", "được làm từ đất sét", 333));
    }
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
        productMap.remove(id);
    }

    @Override
    public Product findById(int id) {
        return productMap.get(id);
    }

    @Override
    public void update(int id, Product product) {
        productMap.put(id, product);
    }
}
