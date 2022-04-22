package reponsitory.CustomerReponsitory;

import model.Customer;
import reponsitory.ConnectDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerReponsitoryImpl implements ICRUDReponsitory {

    ConnectDatabase connectDatabase = new ConnectDatabase();
    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO  khach_hang(ma_khach_hang, ma_loai_khach, ho_ten, ngay_sinh, gioi_tinh, so_cmnd, so_dien_thoai, email, dia_chi) VALUES (?,?,?,?,?,?,?,?,?)";
    private static final String SEARCH_CUSTOMER = " select * from khach_hang where ho_ten like ? and dia_chi like ? and email like ?";
    private static final String SELECT_CUSTOMER_BY_ID = " select * from khach_hang where id_ma_khach_hang = ? ";
    private static final String SELECT_ALL_CUSTOMER = "SELECT * FROM khach_hang";
    private static final String DELETE_CUSTOMER_SQL = "delete from khach_hang where id_ma_khach_hang = ?     ";
    private static final String UPDATE_CUSTOMER_SQL = "update khach_hang set ma_khach_hang= ?, ma_loai_khach = ? , ho_ten= ? , ngay_sinh= ? , gioi_tinh= ? , so_cmnd= ? , so_dien_thoai= ? , email= ? , dia_chi= ?   where id_ma_khach_hang = ?";


    @Override
    public void insertCustomer(Customer customer) {
        try {

            Connection connection = connectDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL);
            preparedStatement.setString(1, customer.getMaKhachHang());
            preparedStatement.setInt(2, customer.getLoaiKhachHang());
            preparedStatement.setString(3, customer.getHoVaTen());
            preparedStatement.setString(4, customer.getNgaySinh());
            preparedStatement.setInt(5, customer.getGioiTinh());
            preparedStatement.setString(6, customer.getSoCMND());
            preparedStatement.setString(7, customer.getSoDienThoai());
            preparedStatement.setString(8, customer.geteMail());
            preparedStatement.setString(9, customer.getDiaChi());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    @Override
    public List<Customer> searchCustomer(String ho_ten, String diaChi, String email) {
        List<Customer> customerList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connectDatabase.getConnection().prepareStatement(SEARCH_CUSTOMER);
            preparedStatement.setString(1, "%" + ho_ten + "%");
            preparedStatement.setString(2, "%" + diaChi + "%");
            preparedStatement.setString(3, "%" + email + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            Customer customer;
            while (resultSet.next()) {
                customer = new Customer();
                customer.setMaKhachHang(resultSet.getString("ma_khach_hang"));
                customer.setLoaiKhachHang(resultSet.getInt("ma_loai_khach"));
                customer.setHoVaTen(resultSet.getString("ho_ten"));
                customer.setNgaySinh(resultSet.getString("ngay_sinh"));
                customer.setGioiTinh(resultSet.getInt("gioi_tinh"));
                customer.setSoCMND(resultSet.getString("so_cmnd"));
                customer.setSoDienThoai(resultSet.getString("so_dien_thoai"));
                customer.seteMail(resultSet.getString("email"));
                customer.setDiaChi(resultSet.getString("dia_chi"));
                customerList.add(customer);
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
        return customerList;
    }



    @Override
    public List<Customer> selectAllCustomer() {
        List<Customer> customers = new ArrayList<>();
        try (Connection connection = connectDatabase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                String hoVaTen = rs.getString("ho_ten");
                String ngaySinh = rs.getString("ngay_sinh");
                int gioiTinh = rs.getInt("gioi_tinh");
                String soCMND = rs.getString("so_cmnd");
                String soDienThoai = rs.getString("so_dien_thoai");
                String email = rs.getString("email");
                int idMaKhachHang = rs.getInt("id_ma_khach_hang");
                String maKhachHang = rs.getString("ma_khach_hang");
                int loaiKhachHang = rs.getInt("ma_loai_khach");
                String diaChi = rs.getString("dia_chi");
                customers.add(new Customer(hoVaTen, ngaySinh, gioiTinh, soCMND, email, idMaKhachHang, soDienThoai, maKhachHang, loaiKhachHang, diaChi));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }


    @Override
    public boolean deleteCustomer(String id) throws SQLException {
        PreparedStatement statement = null;
        boolean rowDeleted;
        try {
            Connection connection = connectDatabase.getConnection();
            statement = connection.prepareStatement(DELETE_CUSTOMER_SQL);
            statement.setString(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } finally {
            statement.close();
        }

        return rowDeleted;
    }

    @Override
    public void updateCustomer(Customer customer) {
        try (Connection connection = connectDatabase.getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER_SQL)) {
            statement.setString(1, customer.getMaKhachHang());
            statement.setInt(2, customer.getLoaiKhachHang());
            statement.setString(3, customer.getHoVaTen());
            statement.setString(4, customer.getNgaySinh());
            statement.setInt(5, customer.getGioiTinh());
            statement.setString(6, customer.getSoCMND());
            statement.setString(7, customer.getSoDienThoai());
            statement.setString(8, customer.geteMail());
            statement.setString(9, customer.getDiaChi());
            statement.setInt(10, customer.getIdMaKhachHang());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


    @Override
    public Customer getCusstomer(int ma_khach_hang) {
        Customer customer = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connectDatabase.getConnection().prepareStatement(SELECT_CUSTOMER_BY_ID);
            preparedStatement.setInt(1, ma_khach_hang);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                customer = new Customer();
                customer.setIdMaKhachHang(resultSet.getInt("id_ma_khach_hang"));
                customer.setMaKhachHang(resultSet.getString("ma_khach_hang"));
                customer.setLoaiKhachHang(resultSet.getInt("ma_loai_khach"));
                customer.setHoVaTen(resultSet.getString("ho_ten"));
                customer.setNgaySinh(resultSet.getString("ngay_sinh"));
                customer.setGioiTinh(resultSet.getInt("gioi_tinh"));
                customer.setSoCMND(resultSet.getString("so_cmnd"));
                customer.setSoDienThoai(resultSet.getString("so_dien_thoai"));
                customer.seteMail(resultSet.getString("email"));
                customer.setDiaChi(resultSet.getString("dia_chi"));
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
        return customer;
    }

}