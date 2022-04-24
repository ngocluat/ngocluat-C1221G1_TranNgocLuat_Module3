package reponsitory.contract_repository;

import model.HopDong;
import reponsitory.ConnectDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContracReponsitoryImpl implements IContract {
    private static final String SELECT_ALL_CONTRACT = "SELECT * FROM case_study_database_module3.hop_dong";
    ConnectDatabase connectDatabase = new ConnectDatabase();

    @Override
    public List<HopDong> listHopDong() {
        List<HopDong> hopDongs = new ArrayList<>();
        try (Connection connection = connectDatabase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_CONTRACT)) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int maHopDong = rs.getInt("ma_hop_dong");
                String ngayLamHopDong = rs.getString("ngay_lam_hop_dong");
                String ngayKetThuc = rs.getString("ngay_ket_thuc");
                double tienDatCoc = rs.getDouble("tien_dat_coc");
                int idMaNhanVien = Integer.parseInt(rs.getString("id_ma_nhan_vien"));
                int idMaKhachHang = Integer.parseInt(rs.getString("id_ma_khach_hang"));
                int maDichVu = rs.getInt("ma_dich_vu");
                hopDongs.add(new HopDong(maHopDong, ngayLamHopDong, ngayKetThuc, tienDatCoc, idMaNhanVien, idMaKhachHang, maDichVu));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hopDongs;
    }

    @Override
    public void insertCustomer(HopDong hopDong) {

    }
}
