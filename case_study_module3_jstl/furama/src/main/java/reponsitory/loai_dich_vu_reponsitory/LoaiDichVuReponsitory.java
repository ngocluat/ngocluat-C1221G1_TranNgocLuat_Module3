package reponsitory.loai_dich_vu_reponsitory;

import model.LoaiDichVu;
import reponsitory.ConnectDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LoaiDichVuReponsitory {
    ConnectDatabase connectDatabase = new ConnectDatabase();

    private static final String SELECT_ALL_DICHVU = "SELECT * FROM case_study_database_module3.loai_dich_vu";

    public List<LoaiDichVu> selectAllLoaiDichVu() {
        List<LoaiDichVu> loaiDichVus = new ArrayList<>();
        Connection connection = connectDatabase.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_ALL_DICHVU);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int maLoaiDichVu = rs.getInt("ma_loai_dich_vu");
                String tenLoaiDichVu = rs.getString("ten_loai_dich_vu");
                LoaiDichVu loaiDichVu = new LoaiDichVu(maLoaiDichVu, tenLoaiDichVu);
                loaiDichVus.add(loaiDichVu);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return loaiDichVus;
    }
}
