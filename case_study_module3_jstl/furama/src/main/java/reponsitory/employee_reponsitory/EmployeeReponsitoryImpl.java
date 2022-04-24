package reponsitory.employee_reponsitory;

import model.Employee;
import reponsitory.ConnectDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeReponsitoryImpl implements ICRUDEmployeeReponsitory {
    ConnectDatabase connectDatabase = new ConnectDatabase();
    private static final String INSERT_EMPLOYEE_SQL = "INSERT INTO nhan_vien(`ma_nhan_vien`, `ho_ten`, `ngay_sinh`, `so_cmnd`, `luong`, `so_dien_thoai`, `email`, `dia_chi`, `ma_vi_tri`, `ma_trinh_do`, `ma_bo_phan`) VALUES (?,?,?,?,?,?,?,?,?,?,?)";
    private static final String SEARCH_EMPLOYEE = " select * from khach_hang where ho_ten like ? or dia_chi like ?";
    private static final String SELECT_EMPLOYEE_BY_ID = " select * from nhan_vien where id_ma_nhan_vien = ? ";
    private static final String SELECT_ALL_EMPLOYEE = "SELECT * FROM nhan_vien";
    private static final String DELETE_EMPLOYEE_SQL = "delete from nhan_vien where id_ma_nhan_vien = ?";
    private static final String UPDATE_CUSTOMER_SQL = "update nhan_vien set   ho_ten = ? , ngay_sinh= ? , so_cmnd = ? , luong= ? , so_dien_thoai= ? , email= ? , dia_chi= ? , ma_vi_tri= ? , ma_trinh_do=? ,ma_bo_phan = ? where  id_ma_nhan_vien = ?";

    @Override
    public void insertEmployee(Employee employee) {
        try {
            Connection connection = connectDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_EMPLOYEE_SQL);
            preparedStatement.setString(1, employee.getMaNHanVien());
            preparedStatement.setString(2, employee.getHoTen());
            preparedStatement.setString(3, employee.getNgaySinh());
            preparedStatement.setString(4, employee.getSoCmnd());
            preparedStatement.setDouble(5, employee.getLuong());
            preparedStatement.setString(6, employee.getSoDienThoai());
            preparedStatement.setString(7, employee.getEmail());
            preparedStatement.setString(8, employee.getDiaChi());
            preparedStatement.setInt(9, employee.getMaViTri());
            preparedStatement.setInt(10, employee.getMaTrinhDo());
            preparedStatement.setInt(11, employee.getMaBoPhan());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Employee> searchEmployee(String hoTen, int maBoPhan, String mail) {
        List<Employee> employees = new ArrayList<>();
        try (Connection connection = connectDatabase.getConnection();

             PreparedStatement preparedStatement = connection.
                     prepareStatement("select * from nhan_vien  where ho_ten like ? and cast(ma_bo_phan as char ) like ? and email like ?")) {
            preparedStatement.setString(1, "%" + hoTen + "%");
            preparedStatement.setInt(2, maBoPhan);
            preparedStatement.setString(3, "%" + mail + "%");
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String employeeId = rs.getString("ma_nhan_vien");
                String employeeName = rs.getString("ho_ten");
                String employeeBirthday = rs.getString("ngay_sinh");
                String employeeIdCard = rs.getString("so_cmnd");
                double employeeSalary = rs.getDouble("luong");
                String employeePhone = rs.getString("so_dien_thoai");
                String employeeEmail = rs.getString("email");
                String employeeAddress = rs.getString("dia_chi");
                int employeePositionId = rs.getInt("ma_vi_tri");
                int employeeEducationDegreeId = rs.getInt("ma_trinh_do");
                int employeeDivisionId = rs.getInt("ma_bo_phan");
                employees.add(new Employee(employeeId, employeeName, employeeBirthday, employeeIdCard, employeeSalary, employeePhone, employeeEmail, employeeAddress, employeePositionId, employeeEducationDegreeId, employeeDivisionId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }



    @Override
    public List<Employee> selectAllEmployee() {
        List<Employee> employees = new ArrayList<>();
        try {
            Connection connection = connectDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_EMPLOYEE);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int idMaNhanVien = rs.getInt("id_ma_nhan_vien");
                String maNhanVien = rs.getString("ma_nhan_vien");
                String hoVaTen = rs.getString("ho_ten");
                String ngaySinh = rs.getString("ngay_sinh");
                String soCMND = rs.getString("so_cmnd");
                double luong = rs.getDouble("luong");
                String soDienThoai = rs.getString("so_dien_thoai");
                String email = rs.getString("email");
                String diaChi = rs.getString("dia_chi");
                int maViTri = rs.getInt("ma_vi_tri");
                int maTrinhDo = rs.getInt("ma_trinh_do");
                int maBoPhan = rs.getInt("ma_bo_phan");
                employees.add(new Employee(idMaNhanVien, maNhanVien, hoVaTen, ngaySinh, soCMND, luong, soDienThoai, email, diaChi, maViTri, maTrinhDo, maBoPhan));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    @Override
    public boolean deleteEmployee(String id) throws SQLException {
        PreparedStatement statement = null;
        boolean rowDeleted;
        try {
            Connection connection = connectDatabase.getConnection();
            statement = connection.prepareStatement(DELETE_EMPLOYEE_SQL);
            statement.setString(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } finally {
            statement.close();
        }

        return rowDeleted;
    }

    @Override
    public void updateEmployee(Employee employee) {
        try (Connection connection = connectDatabase.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER_SQL)) {
            statement.setString(1, employee.getHoTen());
            statement.setString(2, employee.getNgaySinh());
            statement.setString(3, employee.getSoCmnd());
            statement.setDouble(4, employee.getLuong());
            statement.setString(5, employee.getSoDienThoai());
            statement.setString(6, employee.getEmail());
            statement.setString(7, employee.getDiaChi());
            statement.setInt(8, employee.getMaViTri());
            statement.setInt(9, employee.getMaTrinhDo());
            statement.setInt(10, employee.getMaBoPhan());
            statement.setInt(11, employee.getIdMaNHanVien());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Employee getEmployee(int idMaNhanVien) {
        Employee employee = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connectDatabase.getConnection().prepareStatement(SELECT_EMPLOYEE_BY_ID);
            preparedStatement.setInt(1, idMaNhanVien);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                employee = new Employee();
                employee.setIdMaNHanVien(resultSet.getInt("id_ma_nhan_vien"));
                employee.setMaNHanVien(resultSet.getString("ma_nhan_vien"));
                employee.setHoTen(resultSet.getString("ho_ten"));
                employee.setNgaySinh(resultSet.getString("ngay_sinh"));
                employee.setSoCmnd(resultSet.getString("so_cmnd"));
                employee.setLuong(resultSet.getDouble("luong"));
                employee.setSoDienThoai(resultSet.getString("so_dien_thoai"));
                employee.setEmail(resultSet.getString("email"));
                employee.setDiaChi(resultSet.getString("dia_chi"));
                employee.setMaViTri(resultSet.getInt("ma_vi_tri"));
                employee.setMaTrinhDo(resultSet.getInt("ma_trinh_do"));
                employee.setMaBoPhan(resultSet.getInt("ma_bo_phan"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return employee;
    }


}
