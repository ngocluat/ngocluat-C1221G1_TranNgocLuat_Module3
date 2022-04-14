package controller;

import model.Product;
import model.service.Produceseviceimp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductServlet", urlPatterns = {"/product", "/"})
public class ProductServlet extends HttpServlet {
    Produceseviceimp produceseviceimp = new Produceseviceimp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        System.out.println(action);
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "hienThi":

                break;
            default:
                viewCustomer(request, response);
                break;
        }
    }


    private void createProduct(HttpServletRequest request, HttpServletResponse response) {

        String tenSanPham = request.getParameter("tenSanPham");
        String moTa = request.getParameter("moTa");
        double gia = Double.parseDouble(request.getParameter("gia"));
        int id = (int) (Math.random() * 10000);

        Product product = new Product(id, tenSanPham, moTa, gia);
        produceseviceimp.save(product);

        request.setAttribute("product", produceseviceimp);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/them-moi.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void viewCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("product", produceseviceimp);
        request.getRequestDispatcher("/hien-thi.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        System.out.println(action);
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "laoxao":
                break;
        }
    }
}
