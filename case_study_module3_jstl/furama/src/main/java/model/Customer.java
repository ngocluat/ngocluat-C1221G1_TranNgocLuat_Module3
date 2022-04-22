package model;

public class Customer extends Person {
    int idMaKhachHang;



    private String soDienThoai;
    private String maKhachHang;
    private int loaiKhachHang;
    private String diaChi;


    public Customer(String hoVaTen, String ngaySinh, int gioiTinh, String soCMND, String eMail, int idMaKhachHang, String soDienThoai, String maKhachHang, int loaiKhachHang, String diaChi) {
        super(hoVaTen, ngaySinh, gioiTinh, soCMND, eMail);
        this.idMaKhachHang = idMaKhachHang;
        this.soDienThoai = soDienThoai;
        this.maKhachHang = maKhachHang;
        this.loaiKhachHang = loaiKhachHang;
        this.diaChi = diaChi;
    }

    public int getIdMaKhachHang() {
        return idMaKhachHang;
    }

    public void setIdMaKhachHang(int idMaKhachHang) {
        this.idMaKhachHang = idMaKhachHang;
    }

    public Customer() {
    }

    public String getSoDienThoai() {
        return soDienThoai;
    }

    public void setSoDienThoai(String soDienThoai) {
        this.soDienThoai = soDienThoai;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public int getLoaiKhachHang() {
        return loaiKhachHang;
    }

    public void setLoaiKhachHang(int loaiKhachHang) {
        this.loaiKhachHang = loaiKhachHang;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "maKhachHang='" + maKhachHang + '\'' +
                super.toString() +
                ", loaiKhachHang='" + loaiKhachHang + '\'' +
                ", diaChi='" + diaChi + '\'' +
                '}';
    }
}
