package reponsitory.kieu_thue_reponsitory;

import model.KieuThue;
import model.TrinhDo;
import reponsitory.ConnectDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class KieuThueReponsitory {
    ConnectDatabase connectDatabase = new ConnectDatabase();

    private static final String SELECT_ALL_KIEUTHUE = "SELECT * FROM case_study_database_module3.kieu_thue";

    public List<KieuThue> selectAllKieuThue() {
        List<KieuThue> kieuThues = new ArrayList<>();
        Connection connection = connectDatabase.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_ALL_KIEUTHUE);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int maKieuThue = rs.getInt("ma_kieu_thue");
                String tenKieuThue = rs.getString("ten_kieu_thue");
                KieuThue trinhDo = new KieuThue(maKieuThue, tenKieuThue);
                kieuThues.add(trinhDo);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return kieuThues;
    }
}
