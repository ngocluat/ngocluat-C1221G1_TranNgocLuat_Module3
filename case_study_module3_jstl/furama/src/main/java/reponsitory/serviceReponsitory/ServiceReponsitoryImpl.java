package reponsitory.serviceReponsitory;

import model.Service;
import reponsitory.ConnectDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceReponsitoryImpl implements IServiceReponsitory {
    private static final String SELECT_ALL_SERVICE = "SELECT * FROM dich_vu ";
    private static final String INSERT_SERVICE_SQL = "INSERT INTO dich_vu( ten_dich_vu , dien_tich , chi_phi_thue , so_nguoi_toi_da, ma_kieu_thue, ma_loai_dich_vu, tieu_chuan_phong , mo_ta_tien_nghi_khac ,dien_tich_ho_boi ,so_tang ) VALUES (?,?,?,?,?,?,?,?,?,?)";
    ConnectDatabase connectDatabase = new ConnectDatabase();

    @Override
    public List<Service> selectAllService() {
        List<Service> serviceList = new ArrayList<>();
        try {
            Connection connection = connectDatabase.getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_SERVICE) ;
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int maDichVu = rs.getInt("ma_dich_vu");
                String idDichVu = rs.getString("text_ma_dich_vu");
                String tenDichVu = rs.getString("ten_dich_vu");
                double dienTich = rs.getDouble("dien_tich");
                double chiPhiThue = rs.getDouble("chi_phi_thue");
                int soNguoiToiDa = rs.getInt("so_nguoi_toi_da");
                int maKieuThue = rs.getInt("ma_kieu_thue");
                int maLoaiDichVu = rs.getInt("ma_loai_dich_vu");
                String tieuChuanPhong = rs.getString("tieu_chuan_phong");
                String moTaTienNghiKhac = rs.getString("mo_ta_tien_nghi_khac");
                double dienTichHoBoi = rs.getDouble("dien_tich_ho_boi");
                int soTang = rs.getInt("so_tang");
                serviceList.add(new Service(maDichVu,idDichVu, tenDichVu, dienTich, chiPhiThue, soNguoiToiDa, maKieuThue,
                        maLoaiDichVu, tieuChuanPhong, moTaTienNghiKhac, dienTichHoBoi, soTang));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return serviceList;
    }


    @Override
    public void insertService(Service service) {
        try {
            Connection connection = connectDatabase.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_SERVICE_SQL);
//            preparedStatement.setInt(1, service.getMaDichVu());
            preparedStatement.setString(1, service.getTenDichVu());
            preparedStatement.setDouble(2, service.getDienTich());
            preparedStatement.setDouble(3, service.getChiPhiThue());
            preparedStatement.setInt(4, service.getSoNguoiToiDa());
            preparedStatement.setInt(5, service.getMaKieuThue());
            preparedStatement.setInt(6, service.getMaLoaiDichVu());
            preparedStatement.setString(7, service.getTieuChuanPhong());
            preparedStatement.setString(8, service.getMoTaDienTichKhac());
            preparedStatement.setDouble(9, service.getDienTichHoBoi());
            preparedStatement.setInt(10, service.getSoTang());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}
