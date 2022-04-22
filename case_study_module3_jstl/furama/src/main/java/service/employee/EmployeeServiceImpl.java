package service.employee;

import common.Validate;
import model.Employee;
import reponsitory.EmployeeReponsitory.EmployeeReponsitoryImpl;
import reponsitory.EmployeeReponsitory.ICRUDEmployeeReponsitory;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements ICRUDEmployeeService {
    ICRUDEmployeeReponsitory icrudEmployeeReponsitory = new EmployeeReponsitoryImpl();

    @Override
    public Map<String, String> insertEmployee(Employee employee) {
        Map<String, String> error = new HashMap<>();
        if (employee.getSoDienThoai().equals("")) {
            error.put("sodienthoai", "số điện thoại không được để trống ");
        } else if (!employee.getSoDienThoai().matches(Validate.SODIENTHOAI)) {
            error.put("sodienthoai", "số điẹn thoại  không đứng định dạng ");
        }

        if (employee.getSoCmnd().equals("")) {
            error.put("sochungminh", "số chứng minh không được rỗng");
        } else if (!employee.getSoCmnd().matches(Validate.SOCHUNGMINH)) {
            error.put("sochungminh", "số chúng minh  không đứng định dạng ");
        }

        if (employee.getEmail().equals("")) {
            error.put("mail", "email không được rỗng ");
        } else if (!employee.getEmail().matches(Validate.EMAIL)) {
            error.put("mail", "email không đứng định dạng ");
        }

        if (employee.getLuong() < 0) {
            error.put("luong", "lương hơi ít nháaaaaaaaaaaa ");
        }

        if (error.isEmpty()) {
            icrudEmployeeReponsitory.insertEmployee(employee);
        }
        return error;

    }


    @Override
    public List<Employee> selectEmployee(String id) {
        return null;
    }

    @Override
    public List<Employee> selectAllEmployeer() {
        return icrudEmployeeReponsitory.selectAllEmployee();
    }

    @Override
    public boolean deleteEmployee(String id) throws SQLException {
        return icrudEmployeeReponsitory.deleteEmployee(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        icrudEmployeeReponsitory.updateEmployee(employee);
    }

    @Override
    public List<Employee> seachEmployee(String hoTen, int maBoPhan, String mail) {
        return icrudEmployeeReponsitory.searchEmployee(hoTen, maBoPhan, mail);
    }

    @Override
    public Employee getEmployee(int id) {
        return icrudEmployeeReponsitory.getEmployee(id);
    }
}
