package controller;

import model.Customer;
import model.CustomerServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CusstomerServlet", urlPatterns = { "/customer", "/"})
public class CusstomerServlet extends HttpServlet {
    CustomerServiceImpl customerService = new CustomerServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("actionTest");
        if (action == null) {
            action = "";
        }
        System.out.println(action);
        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "view":
                viewCustomer(request, response);
                break;
            default:
                viewCustomer(request, response);
                break;
        }
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) {

        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int id = (int) (Math.random() * 10000);

        Customer customer = new Customer(id, name, email, address);
        customerService.save(customer);

        request.setAttribute("customer", customerService);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


    private void viewCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("customer", customerService.display());
        request.getRequestDispatcher("customer/display.jsp").forward(request, response);
    }
}