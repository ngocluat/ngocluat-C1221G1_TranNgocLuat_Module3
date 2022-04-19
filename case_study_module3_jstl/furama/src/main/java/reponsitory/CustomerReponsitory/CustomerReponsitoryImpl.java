package reponsitory.CustomerReponsitory;

import model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerReponsitoryImpl implements ICRUDReponsitory {

    private String jdbcURL = "jdbc:mysql://localhost:3306/case_study_database_module3";
    private String jdbcUsername = "root";
    private String jdbcPassword = "18082003";

    private static final String INSERT_CUSTOMER_SQL = "INSERT INTO  khach_hang( ma_loai_khach, ho_ten, ngay_sinh, gioi_tinh, so_cmnd, so_dien_thoai, email, dia_chi) VALUES (?,?,?,?,?,?,?,?)";
    private static final String SEARCH_CUSTOMER = " select * from khach_hang where ho_ten like ? or dia_chi like ?";
    private static final String SELECT_CUSTOMER_BY_ID = " select * from khach_hang where ma_khach_hang = ? ";
    private static final String SELECT_ALL_CUSTOMER = "SELECT * FROM case_study_database_module3.khach_hang;";
    private static final String DELETE_CUSTOMER_SQL = "delete from khach_hang where ma_khach_hang = ?     ";
    private static final String UPDATE_CUSTOMER_SQL = "update khach_hang set ma_loai_khach = ? , ho_ten= ? , ngay_sinh= ? , gioi_tinh= ? , so_cmnd= ? , so_dien_thoai= ? , email= ? , dia_chi= ?   where ma_khach_hang = ?";

    public CustomerReponsitoryImpl() {
    }

    protected Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }


    @Override
    public void insertCustomer(Customer customer) {
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_SQL)) {
            preparedStatement.setInt(1, customer.getLoaiKhachHang());
            preparedStatement.setString(2, customer.getHoVaTen());
            preparedStatement.setString(3, customer.getNgaySinh());
            preparedStatement.setInt(4, customer.getGioiTinh());
            preparedStatement.setString(5, customer.getSoCMND());
            preparedStatement.setString(6, customer.getSoDienThoai());
            preparedStatement.setString(7, customer.geteMail());
            preparedStatement.setString(8, customer.getDiaChi());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    @Override
    public List<Customer> searchCustomer(String ho_ten) {
        List<Customer> customerList = new ArrayList<>();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(SEARCH_CUSTOMER);
            preparedStatement.setString(1, "%" + ho_ten + "%");
            preparedStatement.setString(2, "%" + ho_ten + "%");
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

        try (Connection connection = getConnection();
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
                String maKhachHang = rs.getString("ma_khach_hang");
                int loaiKhachHang = rs.getInt("ma_loai_khach");
                String diaChi = rs.getString("dia_chi");
                customers.add(new Customer(hoVaTen, ngaySinh, gioiTinh, soCMND, email, soDienThoai, maKhachHang, loaiKhachHang, diaChi));
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
            Connection connection = getConnection();
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
        try (Connection connection = getConnection();
             PreparedStatement statement = connection.prepareStatement(UPDATE_CUSTOMER_SQL)) {
            statement.setInt(1, customer.getLoaiKhachHang());
            statement.setString(2, customer.getHoVaTen());
            statement.setString(3, customer.getNgaySinh());
            statement.setInt(4, customer.getGioiTinh());
            statement.setString(5, customer.getSoDienThoai());
            statement.setString(6, customer.geteMail());
            statement.setString(7, customer.getDiaChi());
            statement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
// sai sai
    @Override
    public Customer getCusstomer(String ma_khach_hang) {
        Customer  customer = null;
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = getConnection().prepareStatement(SELECT_CUSTOMER_BY_ID);
            preparedStatement.setString(1, ma_khach_hang );
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
//                customer = new Customer();
//                customer.setMaKhachHang(resultSet.getString("ma_khach_hang"));
//                customer.setLoaiKhachHang(resultSet.getInt(""));
//                customer.setHoVaTen(resultSet.getString(""));
//                customer.setNgaySinh(resultSet.getString(""));
//                customer.setGioiTinh(resultSet.getInt(""));
//                customer.setSoCMND(resultSet.getString(""));
//                customer.setSoDienThoai(resultSet.getString(""));
//                customer.seteMail(resultSet.getString(""));
//                customer.setDiaChi(resultSet.getString(""));
                String maKhachHang= resultSet.getString("ma_khach_hang");
                int loaiKhachHang= resultSet.getInt("ma_loai_khach");
                String hoVaTen= resultSet.getString("ho_ten");
                String ngaySinh= resultSet.getString("ngay_sinh");
                int gioi_tinh= resultSet.getInt("gioi_tinh");
                String soCmnd= resultSet.getString("so_cmnd");
                String soDienThoai= resultSet.getString("so_dien_thoai");
                String email= resultSet.getString("email");
                String diaChi= resultSet.getString("dia_chi");
                customer= new Customer(hoVaTen , ngaySinh, gioi_tinh,soCmnd,email,soDienThoai,maKhachHang,loaiKhachHang,diaChi);
                //   User user = null;
                //        try (Connection connection = getConnection();
                //             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
                //            preparedStatement.setInt(1, id);
                //            ResultSet rs = preparedStatement.executeQuery();
                //
                //            while (rs.next()) {
                //                String name = rs.getString("name");
                //                String email = rs.getString("email");
                //                String country = rs.getString("country");
                //                user = new User(id, name, email, country);
                //            }
                //        } catch (SQLException e) {
                //            e.printStackTrace();
                //        }
                //        return user;
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
