package model;

public class HopDong {

    int  maHopDong;
    String ngayLamHopDong;
    String ngayKetThuc;
    double tienDatCoc;
    int idMaNhanVien;
    int idMaKhachHang;
    int idMaDichVu;


    public HopDong(int maHopDong, String ngayLamHopDong, String ngayKetThuc, double tienDatCoc, int idMaNhanVien, int idMaKhachHang, int idMaDichVu) {
        this.maHopDong = maHopDong;
        this.ngayLamHopDong = ngayLamHopDong;
        this.ngayKetThuc = ngayKetThuc;
        this.tienDatCoc = tienDatCoc;
        this.idMaNhanVien = idMaNhanVien;
        this.idMaKhachHang = idMaKhachHang;
        this.idMaDichVu = idMaDichVu;
    }

    public HopDong() {
    }

    public int getMaHopDong() {
        return maHopDong;
    }

    public void setMaHopDong(int maHopDong) {
        this.maHopDong = maHopDong;
    }

    public String getNgayLamHopDong() {
        return ngayLamHopDong;
    }

    public void setNgayLamHopDong(String ngayLamHopDong) {
        this.ngayLamHopDong = ngayLamHopDong;
    }

    public String getNgayKetThuc() {
        return ngayKetThuc;
    }

    public void setNgayKetThuc(String ngayKetThuc) {
        this.ngayKetThuc = ngayKetThuc;
    }

    public double getTienDatCoc() {
        return tienDatCoc;
    }

    public void setTienDatCoc(double tienDatCoc) {
        this.tienDatCoc = tienDatCoc;
    }

    public int getIdMaNhanVien() {
        return idMaNhanVien;
    }

    public void setIdMaNhanVien(int idMaNhanVien) {
        this.idMaNhanVien = idMaNhanVien;
    }

    public int getIdMaKhachHang() {
        return idMaKhachHang;
    }

    public void setIdMaKhachHang(int idMaKhachHang) {
        this.idMaKhachHang = idMaKhachHang;
    }

    public int getIdMaDichVu() {
        return idMaDichVu;
    }

    public void setIdMaDichVu(int idMaDichVu) {
        this.idMaDichVu = idMaDichVu;
    }

    @Override
    public String toString() {
        return "HopDong{" +
                "maHopDong=" + maHopDong +
                ", ngayLamHopDong='" + ngayLamHopDong + '\'' +
                ", ngayKetThuc='" + ngayKetThuc + '\'' +
                ", tienDatCoc=" + tienDatCoc +
                ", idMaNhanVien=" + idMaNhanVien +
                ", idMaKhachHang=" + idMaKhachHang +
                ", idMaDichVu=" + idMaDichVu +
                '}';
    }
}
