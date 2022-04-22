package model;

public class KieuThue {
    int maKieuThue;
    String tenKieuThue;

    public KieuThue(int maKieuThue, String tenKieuThue) {
        this.maKieuThue = maKieuThue;
        this.tenKieuThue = tenKieuThue;
    }

    public KieuThue() {
    }

    public int getMaKieuThue() {
        return maKieuThue;
    }

    public void setMaKieuThue(int maKieuThue) {
        this.maKieuThue = maKieuThue;
    }

    public String getTenKieuThue() {
        return tenKieuThue;
    }

    public void setTenKieuThue(String tenKieuThue) {
        this.tenKieuThue = tenKieuThue;
    }

    @Override
    public String toString() {
        return "KieuThue{" +
                "maKieuThue=" + maKieuThue +
                ", tenKieuThue='" + tenKieuThue + '\'' +
                '}';
    }
}
