package model;

public class CustomerType {
    private  int maLoaiKhach;
    private   String tenLoaiKhachHang;
    public CustomerType(int maLoaiKhach, String tenLoaiKhachHang) {
        this.maLoaiKhach = maLoaiKhach;
        this.tenLoaiKhachHang = tenLoaiKhachHang;
    }

    public int getMaLoaiKhach() {
        return maLoaiKhach;
    }

    public void setMaLoaiKhach(int maLoaiKhach) {
        this.maLoaiKhach = maLoaiKhach;
    }

    public String getTenLoaiKhachHang() {
        return tenLoaiKhachHang;
    }

    public void setTenLoaiKhachHang(String tenLoaiKhachHang) {
        this.tenLoaiKhachHang = tenLoaiKhachHang;
    }

    @Override
    public String toString() {
        return "CustomerType{" +
                "maLoaiKhach=" + maLoaiKhach +
                ", tenLoaiKhachHang='" + tenLoaiKhachHang + '\'' +
                '}';
    }
}
