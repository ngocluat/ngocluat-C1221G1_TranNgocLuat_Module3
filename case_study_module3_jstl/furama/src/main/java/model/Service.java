package model;

public class Service {
    String idDichVu;
    private int maDichVu;
    private String tenDichVu;
    private double dienTich;
    private double chiPhiThue;
    private int soNguoiToiDa;
    private int maKieuThue;
    private int maLoaiDichVu;
    private String tieuChuanPhong;
    private String moTaDienTichKhac;
    private double dienTichHoBoi;
    private int soTang;

    public Service(int maDichVu, String tenDichVu, double dienTich, double chiPhiThue, int soNguoiToiDa, int maKieuThue, int maLoaiDichVu, String tieuChuanPhong, String moTaDienTichKhac, double dienTichHoBoi, int soTang) {
        this.maDichVu = maDichVu;
        this.tenDichVu = tenDichVu;
        this.dienTich = dienTich;
        this.chiPhiThue = chiPhiThue;
        this.soNguoiToiDa = soNguoiToiDa;
        this.maKieuThue = maKieuThue;
        this.maLoaiDichVu = maLoaiDichVu;
        this.tieuChuanPhong = tieuChuanPhong;
        this.moTaDienTichKhac = moTaDienTichKhac;
        this.dienTichHoBoi = dienTichHoBoi;
        this.soTang = soTang;
    }

    public Service(String tenDichVu, double dienTich, double chiPhiThue, int soNguoiToiDa, int maKieuThue, int maLoaiDichVu, String tieuChuanPhong, String moTaDienTichKhac, double dienTichHoBoi, int soTang) {
        this.tenDichVu = tenDichVu;
        this.dienTich = dienTich;
        this.chiPhiThue = chiPhiThue;
        this.soNguoiToiDa = soNguoiToiDa;
        this.maKieuThue = maKieuThue;
        this.maLoaiDichVu = maLoaiDichVu;
        this.tieuChuanPhong = tieuChuanPhong;
        this.moTaDienTichKhac = moTaDienTichKhac;
        this.dienTichHoBoi = dienTichHoBoi;
        this.soTang = soTang;
    }

    public Service(String idDichVu, String tenDichVu, double dienTich, double chiPhiThue, int soNguoiToiDa, int maKieuThue, int maLoaiDichVu, String tieuChuanPhong, String moTaDienTichKhac, double dienTichHoBoi, int soTang) {
        this.idDichVu = idDichVu;
        this.tenDichVu = tenDichVu;
        this.dienTich = dienTich;
        this.chiPhiThue = chiPhiThue;
        this.soNguoiToiDa = soNguoiToiDa;
        this.maKieuThue = maKieuThue;
        this.maLoaiDichVu = maLoaiDichVu;
        this.tieuChuanPhong = tieuChuanPhong;
        this.moTaDienTichKhac = moTaDienTichKhac;
        this.dienTichHoBoi = dienTichHoBoi;
        this.soTang = soTang;
    }

    public Service(int maDichVu, String idDichVu, String tenDichVu, double dienTich, double chiPhiThue, int soNguoiToiDa, int maKieuThue, int maLoaiDichVu, String tieuChuanPhong, String moTaTienNghiKhac, double dienTichHoBoi, int soTang) {
        this.maDichVu = maDichVu;
        this.idDichVu = idDichVu;
        this.tenDichVu = tenDichVu;
        this.dienTich = dienTich;
        this.chiPhiThue = chiPhiThue;
        this.soNguoiToiDa = soNguoiToiDa;
        this.maKieuThue = maKieuThue;
        this.maLoaiDichVu = maLoaiDichVu;
        this.tieuChuanPhong = tieuChuanPhong;
        this.moTaDienTichKhac = moTaTienNghiKhac;
        this.dienTichHoBoi = dienTichHoBoi;
        this.soTang = soTang;
    }

    public int getSoTang() {
        return soTang;
    }

    public void setSoTang(int soTang) {
        this.soTang = soTang;
    }

    public Service() {
    }

    public String getIdDichVu() {
        return idDichVu;
    }

    public void setIdDichVu(String idDichVu) {
        this.idDichVu = idDichVu;
    }

    public int getMaDichVu() {
        return maDichVu;
    }

    public void setMaDichVu(int maDichVu) {
        this.maDichVu = maDichVu;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public void setTenDichVu(String tenDichVu) {
        this.tenDichVu = tenDichVu;
    }

    public double getDienTich() {
        return dienTich;
    }

    public void setDienTich(double dienTich) {
        this.dienTich = dienTich;
    }

    public double getChiPhiThue() {
        return chiPhiThue;
    }

    public void setChiPhiThue(double chiPhiThue) {
        this.chiPhiThue = chiPhiThue;
    }

    public int getSoNguoiToiDa() {
        return soNguoiToiDa;
    }

    public void setSoNguoiToiDa(int soNguoiToiDa) {
        this.soNguoiToiDa = soNguoiToiDa;
    }

    public int getMaKieuThue() {
        return maKieuThue;
    }

    public void setMaKieuThue(int maKieuThue) {
        this.maKieuThue = maKieuThue;
    }

    public int getMaLoaiDichVu() {
        return maLoaiDichVu;
    }

    public void setMaLoaiDichVu(int maLoaiDichVu) {
        this.maLoaiDichVu = maLoaiDichVu;
    }

    public String getTieuChuanPhong() {
        return tieuChuanPhong;
    }

    public void setTieuChuanPhong(String tieuChuanPhong) {
        this.tieuChuanPhong = tieuChuanPhong;
    }

    public String getMoTaDienTichKhac() {
        return moTaDienTichKhac;
    }

    public void setMoTaDienTichKhac(String moTaDienTichKhac) {
        this.moTaDienTichKhac = moTaDienTichKhac;
    }

    public double getDienTichHoBoi() {
        return dienTichHoBoi;
    }

    public void setDienTichHoBoi(double dienTichHoBoi) {
        this.dienTichHoBoi = dienTichHoBoi;
    }

    @Override
    public String toString() {
        return "Service{" +
                "maDichVu=" + maDichVu +
                ", tenDichVu='" + tenDichVu + '\'' +
                ", dienTich=" + dienTich +
                ", chiPhiThue=" + chiPhiThue +
                ", soNguoiToiDa=" + soNguoiToiDa +
                ", maKieuThue=" + maKieuThue +
                ", maLoaiDichVu=" + maLoaiDichVu +
                ", tieuChuanPhong='" + tieuChuanPhong + '\'' +
                ", moTaDienTichKhac='" + moTaDienTichKhac + '\'' +
                ", dienTichHoBoi=" + dienTichHoBoi +
                '}';
    }
}
