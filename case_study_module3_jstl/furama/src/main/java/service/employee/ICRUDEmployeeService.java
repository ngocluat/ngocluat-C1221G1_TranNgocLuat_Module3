package service.employee;

import model.Customer;
import model.Employee;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ICRUDEmployeeService {
    Map<String , String> insertEmployee(Employee employee);

    List<Employee> selectEmployee(String id);

    List<Employee> selectAllEmployeer();

    boolean deleteEmployee(String id) throws SQLException;

    void updateEmployee(Employee customer);

    List<Employee> seachEmployee(String hoTen, int maBoPhan, String mail);

    Employee getEmployee(int id);
}
