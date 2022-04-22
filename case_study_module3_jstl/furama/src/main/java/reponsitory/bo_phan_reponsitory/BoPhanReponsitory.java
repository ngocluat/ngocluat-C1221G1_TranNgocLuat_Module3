package reponsitory.bo_phan_reponsitory;

import model.BoPhan;
import model.ViTri;
import reponsitory.ConnectDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoPhanReponsitory {


    ConnectDatabase connectDatabase = new ConnectDatabase();

    private static final String SELECT_ALL_BOPHAN = "SELECT * FROM case_study_database_module3.bo_phan";

    public List<BoPhan> selectAllBoPhan() {
        List<BoPhan> boPhans = new ArrayList<>();
        Connection connection = connectDatabase.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_ALL_BOPHAN);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int maBoPhan = rs.getInt("ma_bo_phan");
                String tenBoPhan = rs.getString("ten_bo_phan");
                BoPhan boPhan = new BoPhan(maBoPhan, tenBoPhan);
                boPhans.add(boPhan);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return boPhans;
    }
}
