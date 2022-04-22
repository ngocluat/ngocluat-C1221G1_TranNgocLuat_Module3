package controller;

import model.BoPhan;
import model.Employee;
import model.TrinhDo;
import model.ViTri;
import reponsitory.bo_phan_reponsitory.BoPhanReponsitory;
import service.employee.EmployeeServiceImpl;
import service.employee.ICRUDEmployeeService;
import service.trinh_do.TrinhDoService;
import service.vi_tri.VitriService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "EmployeeServlet", urlPatterns = "/employee")
public class EmployeeServlet extends HttpServlet {
    ICRUDEmployeeService icrudEmployeeService = new EmployeeServiceImpl();
    TrinhDoService trinhDoService = new TrinhDoService();
    VitriService vitriService = new VitriService();

    BoPhanReponsitory boPhanReponsitory = new BoPhanReponsitory();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("actionEmployee");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createEmployee(request, response);
                break;
            case "edit":
                editEmployee(request, response);
                break;
            case "delete":
                deleteEmployee(request, response);
                break;

        }

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("actionEmployee");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateEmployee(request, response);
                break;
            case "edit":
                showEditEmployee(request, response);
                break;
            case "search":
                searchingEmployee(request, response);
                break;
            default:
                listEmployee(request, response);

        }
    }

    private void deleteEmployee(HttpServletRequest request, HttpServletResponse response) {
        String maNhanVien = request.getParameter("id");
        try {
            icrudEmployeeService.deleteEmployee(maNhanVien);
            response.sendRedirect("/employee");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void editEmployee(HttpServletRequest request, HttpServletResponse response) {
        int idMaNhanVien = Integer.parseInt(request.getParameter("id_ma_nhan_vien"));
        String maNhanVien = request.getParameter("ma_nhan_vien");
        String hoTen = request.getParameter("ho_ten");
        String ngaySinh = request.getParameter("ngay_sinh");
        String socmnd = request.getParameter("so_cmnd");
        double luong = Double.parseDouble(request.getParameter("luong"));
        String soDienThoai = request.getParameter("so_dien_thoai");
        String email = request.getParameter("email");
        String diaChi = request.getParameter("dia_chi");
        int maViTRi = Integer.parseInt(request.getParameter("ma_vi_tri"));
        int maTrinhDo = Integer.parseInt(request.getParameter("ma_trinh_do"));
        int maBoPhan = Integer.parseInt(request.getParameter("ma_bo_phan"));
        Employee employee = new Employee(idMaNhanVien, maNhanVien, hoTen, ngaySinh, socmnd, luong,
                soDienThoai, email, diaChi, maViTRi, maBoPhan, maTrinhDo);
        System.out.println(employee);
        icrudEmployeeService.updateEmployee(employee);
        try {
            response.sendRedirect("/employee");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private void createEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String maNhanVien = request.getParameter("maNhanVien");
        String hoTen = request.getParameter("hoTen");
        String ngaySinh = request.getParameter("ngaySinh");
        String soCmnd = request.getParameter("soCmnd");
        double luong = Double.parseDouble(request.getParameter("luong"));
        String soDienThoai = request.getParameter("soDienThoai");
        String email = request.getParameter("email");
        String diaChi = request.getParameter("diaChi");
        int maViTri = Integer.parseInt(request.getParameter("maViTri"));
        int maTrinhDo = Integer.parseInt(request.getParameter("maTrinhDo"));
        int maBoPhan = Integer.parseInt(request.getParameter("maBoPhan"));

        Map<String, String> stringStringMap = icrudEmployeeService.insertEmployee(new Employee(maNhanVien, hoTen, ngaySinh, soCmnd, luong, soDienThoai, email, diaChi, maViTri, maTrinhDo, maBoPhan));

        if (stringStringMap.isEmpty()) {
            request.setAttribute("message", "đã thêm mới thành công");
            request.getRequestDispatcher("view/employee/create.jsp").forward(request, response);
        } else {
            request.setAttribute("error", stringStringMap);
            request.getRequestDispatcher("view/employee/create.jsp").forward(request, response);

        }


    }


    private void searchingEmployee(HttpServletRequest request, HttpServletResponse response) {
        List<TrinhDo> trinhDos = trinhDoService.selectAllTrinhDo();
        request.setAttribute("trinhDo", trinhDos);
        List<ViTri> viTris = vitriService.selectAllViTri();
        request.setAttribute("viTri", viTris);
        List<BoPhan> boPhans = boPhanReponsitory.selectAllBoPhan();
        request.setAttribute("boPhan", boPhans);



        String hoTen = request.getParameter("hoTen");
        int maBoPhan = Integer.parseInt(request.getParameter("maBoPhan"));
        String mail = request.getParameter("mail");
        List<Employee> employeeList = icrudEmployeeService.seachEmployee(hoTen, maBoPhan, mail);
        System.out.println(employeeList);
        request.setAttribute("employee", employeeList);
        try {
            request.getRequestDispatcher("view/employee/list.jsp").forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }


    }

    private void listEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = icrudEmployeeService.selectAllEmployeer();
        request.setAttribute("employee", employeeList);

        List<TrinhDo> trinhDos = trinhDoService.selectAllTrinhDo();
        request.setAttribute("trinhDo", trinhDos);
        List<ViTri> viTris = vitriService.selectAllViTri();
        request.setAttribute("viTri", viTris);
        List<BoPhan> boPhans = boPhanReponsitory.selectAllBoPhan();
        request.setAttribute("boPhan", boPhans);


        RequestDispatcher dispatcher = request.getRequestDispatcher("view/employee/list.jsp");
        dispatcher.forward(request, response);

    }

    private void showEditEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("message", "đã sữa thành công");
        int idMaNHanVien = Integer.parseInt(request.getParameter("idMaNhanVien"));
        Employee employee = icrudEmployeeService.getEmployee(idMaNHanVien);
        request.setAttribute("employee", employee);
        request.getRequestDispatcher("view/employee/edit.jsp").forward(request, response);

    }

    private void showCreateEmployee(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<TrinhDo> trinhDos = trinhDoService.selectAllTrinhDo();
        request.setAttribute("trinhDo", trinhDos);
        List<ViTri> viTris = vitriService.selectAllViTri();
        request.setAttribute("viTri", viTris);
        List<BoPhan> boPhans = boPhanReponsitory.selectAllBoPhan();
        request.setAttribute("boPhan", boPhans);


        request.getRequestDispatcher("view/employee/create.jsp").forward(request, response);

    }

}
