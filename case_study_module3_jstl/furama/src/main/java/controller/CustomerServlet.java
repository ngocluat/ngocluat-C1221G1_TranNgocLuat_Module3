package controller;

import model.Customer;
import service.customer.CustomerServiceImpl;
import service.customer.ICRUDCustomer;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    ICRUDCustomer icrudCustomer = new CustomerServiceImpl();


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("actionCustomer");
        if (action == null) {
            action = "";
        }

        switch (action) {
            case "create":
                createCustomer(request, response);
                break;
            case "edit":
                updateCustomer(request, response);
                break;
            case "delete":
                deleteCustomer(request, response);
                break;
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("actionCustomer");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateCustomer(request, response);
                break;
            case "edit":
                showEditCustomer(request, response);
                break;
            case "search":
                searchingCustomer(request, response);
                break;
            default:
                listCustomer(request, response);
                break;
        }
    }

    private void showCreateCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("customer_file/create-customer.jsp").forward(request, response);

    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customerList = icrudCustomer.selectAllCustomer();
        request.setAttribute("customerLists", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer_file/list-customer.jsp");
        dispatcher.forward(request, response);
    }

    private void searchingCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        List<Customer> customerList = icrudCustomer.seachCustomerSv(name);
        System.out.println(customerList);
        request.setAttribute("customerLists", customerList);
        try {
            request.getRequestDispatcher("/customer_file/list-customer.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showEditCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maKhachHang = request.getParameter("ma_khach_hang");
        Customer customer = icrudCustomer.getCusstomer(maKhachHang);
        request.setAttribute("customers", customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("customer_file/edit-customer.jsp");
        dispatcher.forward(request, response);
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String ngaySinh = request.getParameter("ngaySinh");
        int gioiTinh = Integer.parseInt(request.getParameter("gioiTinh"));
        String soCMND = request.getParameter("soCMND");
        String soDienThoai = request.getParameter("soDienThoai");
        String email = request.getParameter("email");
        String maKhachHang = request.getParameter("maKhachHang");
        int loaiKhachHang = Integer.parseInt(request.getParameter("loaiKhachHang"));
        String diaChi = request.getParameter("diaChi");
        icrudCustomer.insertCustomer(new Customer(name, ngaySinh, gioiTinh, soCMND, email, soDienThoai, maKhachHang, loaiKhachHang, diaChi));
        request.setAttribute("message", "đã thêm mới thành công");
        request.getRequestDispatcher("customer_file/create-customer.jsp").forward(request, response);
    }


    private void deleteCustomer(HttpServletRequest request, HttpServletResponse response) {
        String maKhachHang = request.getParameter("id");
        try {
            icrudCustomer.deleteCustomer(maKhachHang);
            response.sendRedirect("/customer");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateCustomer(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String ho_ten = request.getParameter("ho_ten");
        String ngay_sinh = request.getParameter("ngay_sinh");
        int gioi_tinh = Integer.parseInt(request.getParameter("gioi_tinh"));
        String so_cmnd = request.getParameter("so_cmnd");
        String email = request.getParameter("email");
        String so_dien_thoai = request.getParameter("so_dien_thoai");
        String ma_khach_hang = request.getParameter("ma_khach_hang");
        int ma_loai_khach = Integer.parseInt(request.getParameter("ma_loai_khach"));
        String dia_chi = request.getParameter("dia_chi");
        Customer customer = new Customer(ho_ten, ngay_sinh, gioi_tinh, so_cmnd, email, so_dien_thoai, ma_khach_hang, ma_loai_khach, dia_chi);
        icrudCustomer.updateCustomer(customer);
        request.setAttribute("message", "update success  ");
        RequestDispatcher dispatcher = request.getRequestDispatcher("/customer");
        dispatcher.forward(request, response);
    }


}

