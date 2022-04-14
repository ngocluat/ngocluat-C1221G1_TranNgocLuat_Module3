package model;

public class Product {
    private int id;
    private String tenSanPham;
    private String moTa;
    private double gia;

    public Product(int id, String tenSanPham, String moTa, double gia) {
        this.id = id;
        this.tenSanPham = tenSanPham;
        this.moTa = moTa;
        this.gia = gia;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenSanPham() {
        return tenSanPham;
    }

    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", tenSanPham='" + tenSanPham + '\'' +
                ", moTa='" + moTa + '\'' +
                ", gia=" + gia +
                '}';
    }
}
