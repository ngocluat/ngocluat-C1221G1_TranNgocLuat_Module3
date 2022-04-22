package reponsitory.trinh_do_reponsitory;

import model.Service;
import model.TrinhDo;
import reponsitory.ConnectDatabase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TrinhDoReponsitory {
    ConnectDatabase connectDatabase = new ConnectDatabase();

    private static final String SELECT_ALL_TRINH_DO = "SELECT * FROM case_study_database_module3.trinh_do";

    public  List<TrinhDo> selectAllTrinhDo() {
        List<TrinhDo> trinhDos = new ArrayList<>();
        Connection connection = connectDatabase.getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(SELECT_ALL_TRINH_DO);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int maTrinhDo = rs.getInt("ma_trinh_do");
                String tenTrinhDo = rs.getString("ten_trinh_do");
                TrinhDo trinhDo = new TrinhDo(maTrinhDo, tenTrinhDo);
                trinhDos.add(trinhDo);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return trinhDos;
    }
}
