package reponsitory.vi_tri_reponsitory;

import model.TrinhDo;
import model.ViTri;
import reponsitory.ConnectDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VitriReponsitory {
    ConnectDatabase connectDatabase = new ConnectDatabase();

    private static final String SELECT_ALL_VITRI = "SELECT * FROM case_study_database_module3.vi_tri";

    public List<ViTri> selectAllViTri() {
        List<ViTri> viTriList = new ArrayList<>();
        Connection connection = connectDatabase.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_ALL_VITRI);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int maViTRi = rs.getInt("ma_vi_tri");
                String tenViTri = rs.getString("ten_vi_tri");
                ViTri viTri = new ViTri(maViTRi, tenViTri);
                viTriList.add(viTri);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return viTriList;
    }

}
