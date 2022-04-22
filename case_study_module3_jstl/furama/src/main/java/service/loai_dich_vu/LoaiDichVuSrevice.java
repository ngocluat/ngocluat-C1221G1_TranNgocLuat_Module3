package service.loai_dich_vu;

import model.LoaiDichVu;
import reponsitory.loai_dich_vu_reponsitory.LoaiDichVuReponsitory;

import java.util.List;

public class LoaiDichVuSrevice {
    LoaiDichVuReponsitory loaiDichVuReponsitory= new LoaiDichVuReponsitory();
    public List<LoaiDichVu> selectAllLoaiDichVu() {
       return loaiDichVuReponsitory.selectAllLoaiDichVu();
    }
}
