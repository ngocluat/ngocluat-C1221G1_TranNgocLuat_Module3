package service.customer;

import common.Validate;
import model.Customer;
import reponsitory.CustomerReponsitory.CustomerReponsitoryImpl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CustomerServiceImpl implements ICRUDCustomer {

    CustomerReponsitoryImpl customerReponsitory = new CustomerReponsitoryImpl();


//    public  Map<String, String> insertCustomer(Customer customer) {
//        Map<String, String>map = new HashMap<>();
//        if(customer.getMaKhachHang().equals("")) {
//            map.put("name","mã KHách Hàng không được để trống");
//        } else if(!customer.getMaKhachHang().matches(MAKHACHHANG)) {
//            map.put("name","mã Khách Hàng không hợp lệ");
//        }
//        if(map.isEmpty()) {
//            customerReponsitory.insertCustomer(customer);
//        }
//        return map;
//    }


    @Override
    public Map<String, String> insertCustomer(Customer customer) {
        Map<String, String> error = new HashMap<>();
        if (customer.getMaKhachHang().equals("")) {
            error.put("name", "mã KHách Hàng không được để trống");
        } else if (!customer.getMaKhachHang().matches(Validate.MAKHACHHANG)) {
            error.put("name", "mã Khách Hàng không hợp lệ");
        }
        if (customer.getSoDienThoai().equals("")) {
            error.put("sodienthoai", "số điện thoại không được dể trống ");
        } else if (!customer.getSoDienThoai().matches(Validate.SODIENTHOAI)) {
            error.put("sodienthoai", "số điẹn thoại  không đứng định dạng ");
        }
        if (error.isEmpty()) {
            customerReponsitory.insertCustomer(customer);
        }
        return error;
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
    public List<Customer> seachCustomerSv(String name, String diaChhi, String mail) {
        return customerReponsitory.searchCustomer(name, diaChhi, mail);
    }

    @Override
    public Customer getCusstomer(int id) {
        return customerReponsitory.getCusstomer(id);
    }


}
