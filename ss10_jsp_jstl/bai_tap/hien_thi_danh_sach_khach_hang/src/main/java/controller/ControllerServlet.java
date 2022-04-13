package controller;

import models.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@WebServlet(name = "ControllerServlet", urlPatterns = "/display-test")
public class ControllerServlet extends HttpServlet {
    ArrayList<Customer> customers;

    @Override
    public void init() throws ServletException {

        customers = new ArrayList<>();
        customers.add(new Customer("Luật", "18/08/2003", "Quang Nam", "https://img.websosanh.vn/v2/users/review/images/4wvuq0i4ozs1q.jpg?compress=85"));
        customers.add(new Customer("Luật", "18/08/2003", "Quang Nam", "https://img.websosanh.vn/v2/users/review/images/4wvuq0i4ozs1q.jpg?compress=85"));
        customers.add(new Customer("Luật", "18/08/2003", "Quang Nam", "https://img.websosanh.vn/v2/users/review/images/4wvuq0i4ozs1q.jpg?compress=85"));
        customers.add(new Customer("Luật", "18/08/2003", "Quang Nam", "https://img.websosanh.vn/v2/users/review/images/4wvuq0i4ozs1q.jpg?compress=85"));
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        request.setAttribute("khachHang", customers);
        request.getRequestDispatcher("display.jsp").forward(request, response);
    }
}
