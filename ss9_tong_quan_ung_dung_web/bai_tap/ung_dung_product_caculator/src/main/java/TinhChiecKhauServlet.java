import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TinhChiecKhauServlet" ,urlPatterns = "/percent")
public class TinhChiecKhauServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        double price = Double.parseDouble(request.getParameter("price"));
        double discount= Double.parseDouble(request.getParameter("discount"));
        double result = price * discount * 0.01;
        double afterdiscount= price-result;
        request.setAttribute("ketQua", result);
        request.setAttribute("ketQua1", afterdiscount);
        request.getRequestDispatcher("/tinh_chiec_khau.jsp").forward(request, response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
