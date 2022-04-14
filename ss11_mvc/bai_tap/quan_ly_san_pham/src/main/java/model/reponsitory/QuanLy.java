package model.reponsitory;

import model.Product;

import java.util.HashMap;
import java.util.Map;

public class QuanLy {

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

}
