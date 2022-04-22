package service.vi_tri;

import model.ViTri;
import reponsitory.vi_tri_reponsitory.VitriReponsitory;

import java.util.List;

public class VitriService {
    VitriReponsitory vitriReponsitory= new VitriReponsitory();

    public List<ViTri> selectAllViTri() {
        return vitriReponsitory.selectAllViTri();
    }
}
