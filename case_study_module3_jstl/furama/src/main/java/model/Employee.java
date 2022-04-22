package model;

public class Employee {
    private int idMaNHanVien;
    private String maNHanVien;
    private String hoTen;
    private String ngaySinh;
    private String soCmnd;
    private double luong;
    private String soDienThoai;
    private String email;
    private String diaChi;
    int maViTri;
    int maTrinhDo;
    int maBoPhan;

    public Employee(int idMaNHanVien, String maNHanVien, String hoTen, String ngaySinh, String soCmnd, double luong, String soDienThoai, String email, String diaChi, int maViTri, int maTrinhDo, int maBoPhan) {
        this.idMaNHanVien = idMaNHanVien;
        this.maNHanVien = maNHanVien;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.soCmnd = soCmnd;
        this.luong = luong;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
        this.maViTri = maViTri;
        this.maTrinhDo = maTrinhDo;
        this.maBoPhan = maBoPhan;
    }

    public Employee() {
    }

    public Employee(String maNHanVien, String hoTen, String ngaySinh, String soCmnd, double luong, String soDienThoai, String email, String diaChi, int maViTri, int maTrinhDo, int maBoPhan) {
        this.maNHanVien = maNHanVien;
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.soCmnd = soCmnd;
        this.luong = luong;
        this.soDienThoai = soDienThoai;
        this.email = email;
        this.diaChi = diaChi;
        this.maViTri = maViTri;
        this.maTrinhDo = maTrinhDo;
        this.maBoPhan = maBoPhan;
    }

    public int getIdMaNHanVien() {
        return idMaNHanVien;
    }

    public void setIdMaNHanVien(int idMaNHanVien) {
        this.idMaNHanVien = idMaNHanVien;
    }

    public String getMaNHanVien() {
        return maNHanVien;
    }

    public void setMaNHanVien(String maNHanVien) {
        this.maNHanVien = maNHanVien;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(String ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getSoCmnd() {
        return soCmnd;
    }

    public void setSoCmnd(String soCmnd) {
        this.soCmnd = soCmnd;
    }

    public double getLuong() {
        return luong;
    }

    public void setLuong(double luong) {
        this.luong = luong;
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public int getMaViTri() {
        return maViTri;
    }

    public void setMaViTri(int maViTri) {
        this.maViTri = maViTri;
    }

    public int getMaTrinhDo() {
        return maTrinhDo;
    }

    public void setMaTrinhDo(int maTrinhDo) {
        this.maTrinhDo = maTrinhDo;
    }

    public int getMaBoPhan() {
        return maBoPhan;
    }

    public void setMaBoPhan(int maBoPhan) {
        this.maBoPhan = maBoPhan;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "idMaNHanVien=" + idMaNHanVien +
                ", maNHanVien='" + maNHanVien + '\'' +
                ", hoTen='" + hoTen + '\'' +
                ", ngaySinh='" + ngaySinh + '\'' +
                ", soCmnd='" + soCmnd + '\'' +
                ", luong=" + String.format("%,.0f", luong) +
                ", soDienThoai='" + soDienThoai + '\'' +
                ", email='" + email + '\'' +
                ", diaChi='" + diaChi + '\'' +
                ", maViTri=" + maViTri +
                ", maTrinhDo=" + maTrinhDo +
                ", maBoPhan=" + maBoPhan +
                '}';
    }
}
