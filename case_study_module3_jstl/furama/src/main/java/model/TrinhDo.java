package model;

public class    TrinhDo {
    int maTrinhDo;
    String tenTrinhDo ;

    public TrinhDo(int maTrinhDo, String tenTrinhDo) {
        this.maTrinhDo = maTrinhDo;
        this.tenTrinhDo = tenTrinhDo;
    }

    public TrinhDo() {
    }

    public int getMaTrinhDo() {
        return maTrinhDo;
    }

    public void setMaTrinhDo(int maTrinhDo) {
        this.maTrinhDo = maTrinhDo;
    }

    public String getTenTrinhDo() {
        return tenTrinhDo;
    }

    public void setTenTrinhDo(String tenTrinhDo) {
        this.tenTrinhDo = tenTrinhDo;
    }

    @Override
    public String toString() {
        return "TrinhDo{" +
                "maTrinhDo=" + maTrinhDo +
                ", tenTrinhDo='" + tenTrinhDo + '\'' +
                '}';
    }

}
