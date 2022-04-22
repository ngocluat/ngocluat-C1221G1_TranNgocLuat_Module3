package service.trinh_do;

import model.TrinhDo;
import reponsitory.trinh_do_reponsitory.TrinhDoReponsitory;

import java.util.List;

public class TrinhDoService {
    TrinhDoReponsitory trinhDoReponsitory= new TrinhDoReponsitory();
    public List<TrinhDo> selectAllTrinhDo() {
        return trinhDoReponsitory.selectAllTrinhDo();
    }
}
