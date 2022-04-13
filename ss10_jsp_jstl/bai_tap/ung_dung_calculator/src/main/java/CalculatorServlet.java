import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CalculatorServlet", urlPatterns = "/tinh-toan")
public class CalculatorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        double one = Double.parseDouble(request.getParameter("numberFirst"));
        double two = Double.parseDouble(request.getParameter("numberSeconse"));
        String ex = null;
        char phepTinh = request.getParameter("phepTinh").charAt(0);
        Double ketQua = null;
        try {
            ketQua = MayTinh.tinhToan(one, phepTinh, two);
            request.setAttribute("ketQua", ketQua);

        } catch (Exception e) {
            ex = "Lỗi   Mẫu Không đượng bằng không ";
            request.setAttribute("suCo", ex);
        }
        request.getRequestDispatcher("calculator.jsp").forward(request, response);



    }
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
