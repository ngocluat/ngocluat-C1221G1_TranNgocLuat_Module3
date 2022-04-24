package reponsitory.customer_type;


import model.CustomerType;
import reponsitory.ConnectDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CusumerTypeReponsitoryIpml implements ICusumerTypeReponsitory {
    private static final String SELECT_ALL_CUSTOMER_TYPE ="SELECT * FROM loai_khach";
    ConnectDatabase connectDatabase= new ConnectDatabase();
    @Override
    public List<CustomerType> selectCustomerType() {

            List<CustomerType> customersType = new ArrayList<>();
            try (Connection connection = connectDatabase.getConnection();
                 PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CUSTOMER_TYPE)) {
                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                    int maLoaiKhach = rs.getInt("ma_loai_khach");
                    String tenLoaiKhachHang = rs.getString("ten_loai_khach_hang");
                    customersType.add(new CustomerType(maLoaiKhach, tenLoaiKhachHang));
                }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            return customersType;
        }
}
