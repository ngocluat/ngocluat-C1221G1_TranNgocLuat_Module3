package reponsitory.employee_reponsitory;

import model.Employee;

import java.sql.SQLException;
import java.util.List;

public interface ICRUDEmployeeReponsitory {
    void insertEmployee(Employee customer);

    List<Employee> searchEmployee(String hoTen, int maBoPhan, String mail);

    List<Employee> selectAllEmployee();

    boolean deleteEmployee(String id) throws SQLException;


    void updateEmployee(Employee customer);

    Employee getEmployee(int ma_khach_hang);
}
