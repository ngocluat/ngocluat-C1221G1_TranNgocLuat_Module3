public class MayTinh {
    public static Double tinhToan(double soMot, char phepTinh, double soHai)  throws Exception{
        Double ketQua = null;
        switch (phepTinh) {
            case '+':
                ketQua = soMot + soHai;
                break;
            case '-':
                ketQua = soMot - soHai;
                break;
            case '*':
                ketQua = soMot * soHai;
                break;
            case '/':
                if (soHai== 0){
                   throw new Exception();
                }else
                ketQua = soMot / soHai;
                break;
        }
        return ketQua;
    }
}
