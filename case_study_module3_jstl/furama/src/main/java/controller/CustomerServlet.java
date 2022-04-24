package controller;

import model.Customer;
import model.CustomerType;
import reponsitory.CustomerReponsitory.CustomerReponsitoryImpl;
import service.customer.CustomerServiceImpl;
import service.customer.ICRUDCustomer;
import service.cusumer_type_reponsitory.CustomertypeService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "CustomerServlet", urlPatterns = "/customer")
public class CustomerServlet extends HttpServlet {
    ICRUDCustomer icrudCustomer = new CustomerServiceImpl();
    CustomertypeService customertypeService = new CustomertypeService();
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
        List<CustomerType> customerListType = customertypeService.selectCustomerType();
        request.setAttribute("customerTypeLists", customerListType);
        request.getRequestDispatcher("view/customer/create.jsp").forward(request, response);

    }

    private void listCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CustomerType> customerListType = customertypeService.selectCustomerType();
        request.setAttribute("customerTypeLists", customerListType);

        List<Customer> customerList = icrudCustomer.selectAllCustomer();
        request.setAttribute("customerLists", customerList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/list.jsp");
        dispatcher.forward(request, response);
    }

    private void searchingCustomer(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String diaChi = request.getParameter("diaChi");
        String mail = request.getParameter("mail");
        List<Customer> customerList = icrudCustomer.seachCustomerSv(name, diaChi, mail);
        System.out.println(customerList);
        request.setAttribute("customerLists", customerList);
        try {
            request.getRequestDispatcher("view/customer/list.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }


    private void showEditCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<CustomerType> customerListType = customertypeService.selectCustomerType(); //
        request.setAttribute("customerTypeLists", customerListType);//

        int idMaKhachHang = Integer.parseInt(request.getParameter("id_ma_khach_hang"));
        request.setAttribute("idMaKhachHang", idMaKhachHang);
        Customer customer = icrudCustomer.getCusstomer(idMaKhachHang);
        request.setAttribute("customers", customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("view/customer/edit.jsp");
        dispatcher.forward(request, response);
    }

    private void createCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int idMaKhachHang = Integer.parseInt(request.getParameter("idMaKhachHang"));
        String name = request.getParameter("name");
        String ngaySinh = request.getParameter("ngaySinh");
        int gioiTinh = Integer.parseInt(request.getParameter("gioiTinh"));
        String soCMND = request.getParameter("soCMND");
        String soDienThoai = request.getParameter("soDienThoai");
        String email = request.getParameter("email");
        String maKhachHang = request.getParameter("maKhachHang");
        int loaiKhachHang = Integer.parseInt(request.getParameter("loaiKhachHang"));
        String diaChi = request.getParameter("diaChi");
        Map<String, String> stringStringMap = icrudCustomer.insertCustomer(new Customer(name, ngaySinh, gioiTinh, soCMND, email, idMaKhachHang, soDienThoai, maKhachHang, loaiKhachHang, diaChi));
        if (stringStringMap.isEmpty()) {
            request.setAttribute("message", "đã thêm mới thành công");
            request.setAttribute("check", stringStringMap);
            request.getRequestDispatcher("view/customer/create.jsp").forward(request, response);
            List<CustomerType> customerListType = customertypeService.selectCustomerType();
            request.setAttribute("customerTypeLists", customerListType);
        } else {
            request.setAttribute("error", stringStringMap);
            request.getRequestDispatcher("view/customer/create.jsp").forward(request, response);

            List<CustomerType> customerListType = customertypeService.selectCustomerType();
            request.setAttribute("customerTypeLists", customerListType);

        }


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
        int idMaKhachHang = Integer.parseInt(request.getParameter("id_ma_khach_hang"));
        String ho_ten = request.getParameter("ho_ten");
        String ngay_sinh = request.getParameter("ngay_sinh");
        int gioi_tinh = Integer.parseInt(request.getParameter("gioi_tinh"));
        String so_cmnd = request.getParameter("so_cmnd");
        String email = request.getParameter("email");
        String so_dien_thoai = request.getParameter("so_dien_thoai");
        String ma_khach_hang = request.getParameter("ma_khach_hang");
        int ma_loai_khach = Integer.parseInt(request.getParameter("ma_loai_khach"));
        String dia_chi = request.getParameter("dia_chi");
        Customer customer = new Customer(ho_ten, ngay_sinh, gioi_tinh, so_cmnd, email, idMaKhachHang, so_dien_thoai, ma_khach_hang, ma_loai_khach, dia_chi);
        System.out.println(customer);
        icrudCustomer.updateCustomer(customer);
        request.setAttribute("message", "update success");
        response.sendRedirect("/customer");
    }


}

