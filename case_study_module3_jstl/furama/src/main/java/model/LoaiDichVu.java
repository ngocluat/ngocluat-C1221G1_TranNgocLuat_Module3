package model;

public class LoaiDichVu {
    int maLoaiDichVu;
    String tenLoaiDichVu;

    public LoaiDichVu(int maLoaiDichVu, String tenLoaiDichVu) {
        this.maLoaiDichVu = maLoaiDichVu;
        this.tenLoaiDichVu = tenLoaiDichVu;
    }

    public LoaiDichVu() {
    }

    public int getMaLoaiDichVu() {
        return maLoaiDichVu;
    }

    public void setMaLoaiDichVu(int maLoaiDichVu) {
        this.maLoaiDichVu = maLoaiDichVu;
    }

    public String getTenLoaiDichVu() {
        return tenLoaiDichVu;
    }

    public void setTenLoaiDichVu(String tenLoaiDichVu) {
        this.tenLoaiDichVu = tenLoaiDichVu;
    }

    @Override
    public String toString() {
        return "LoaiDichVu{" +
                "maLoaiDichVu=" + maLoaiDichVu +
                ", tenLoaiDichVu='" + tenLoaiDichVu + '\'' +
                '}';
    }
}
