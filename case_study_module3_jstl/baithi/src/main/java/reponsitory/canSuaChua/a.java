package reponsitory.canSuaChua;

import reponsitory.ConnectDatabase;

public class a implements  IFunctionReponsitory{

    ConnectDatabase connectDatabase = new ConnectDatabase();
    private static final String INSERT__SQL = "INSERT INTO  khach_hang(ma_khach_hang, ma_loai_khach, ho_ten, ngay_sinh) VALUES (?,?,?,?,?,?,?,?,?)";
    private static final String SEARCH_ = " select * from khach_hang where ho_ten like ? and dia_chi like ?";
    private static final String SELECT_CUSTOMER_BY_ID = " select * from khach_hang where id_ma_khach_hang = ? ";
    private static final String SELECT_ALL_CUSTOMER = "SELECT * FROM khach_hang";
    private static final String DELETE_CUSTOMER_SQL = "delete from khach_hang where id_ma_khach_hang = ?     ";
    private static final String UPDATE_CUSTOMER_SQL = "update khach_hang set ma_khach_hang= ?, ma_loai_khach = ? , ho_ten= ? , ngay_sinh= ?  , dia_chi= ?   where id_ma_khach_hang = ?";
    private static final String SELECT_ALL_CUSTOMER_TYPE = "SELECT * FROM loai_khach";





}
