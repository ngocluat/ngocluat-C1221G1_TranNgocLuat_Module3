package model;

public class BoPhan {
    int maBoPhan;
    String tenBoPhan;

    public BoPhan(int maBoPhan, String tenBoPhan) {
        this.maBoPhan = maBoPhan;
        this.tenBoPhan = tenBoPhan;
    }

    public BoPhan() {
    }

    public int getMaBoPhan() {
        return maBoPhan;
    }

    public void setMaBoPhan(int maBoPhan) {
        this.maBoPhan = maBoPhan;
    }

    public String getTenBoPhan() {
        return tenBoPhan;
    }

    public void setTenBoPhan(String tenBoPhan) {
        this.tenBoPhan = tenBoPhan;
    }

    @Override
    public String toString() {
        return "BoPhan{" +
                "maBoPhan=" + maBoPhan +
                ", tenBoPhan='" + tenBoPhan + '\'' +
                '}';
    }

}
