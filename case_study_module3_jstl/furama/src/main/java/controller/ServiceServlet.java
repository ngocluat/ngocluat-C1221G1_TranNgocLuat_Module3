package controller;

import model.KieuThue;
import model.LoaiDichVu;
import model.Service;
import reponsitory.kieu_thue_reponsitory.KieuThueReponsitory;
import reponsitory.loai_dich_vu_reponsitory.LoaiDichVuReponsitory;
import service.loai_dich_vu.LoaiDichVuSrevice;
import service.service.ICRUDServiceServeice;
import service.service.ServiceServeiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(name = "ServiceServlet", urlPatterns = "/service")
public class ServiceServlet extends HttpServlet {
    ICRUDServiceServeice icrudServiceServeice = new ServiceServeiceImpl();
    KieuThueReponsitory kieuThueReponsitory = new KieuThueReponsitory();
    LoaiDichVuReponsitory loaiDichVuReponsitory = new LoaiDichVuReponsitory();
    LoaiDichVuSrevice loaiDichVuSrevice= new LoaiDichVuSrevice();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("actionService");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createService(request, response);
                break;

        }
    }

    private void deleteService(HttpServletRequest request, HttpServletResponse response) {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");

        String action = request.getParameter("actionService");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateService(request, response);
                break;
            default:
                listService(request, response);

        }
    }


    private void createService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String tenDichVu = request.getParameter("tenDichVu");
        double dienTich = Double.parseDouble(request.getParameter("dienTich"));
        double chiPhiThue = Double.parseDouble(request.getParameter("chiPhiThue"));
        int soNguoiToiDa = Integer.parseInt(request.getParameter("soNguoiToiDa"));
        int maKieuThue = Integer.parseInt(request.getParameter("maKieuThue"));
        int maLoaiDichVu = Integer.parseInt(request.getParameter("maLoaiDichVu"));
        String tieuChuanPhong = request.getParameter("tieuChuanPhong");
        String moTaTienNghiKhac = request.getParameter("moTaTienNghiKhac");
        double dienTichHoBoi = Double.parseDouble(request.getParameter("dienTichHoBoi"));
        int soTang = Integer.parseInt(request.getParameter("soTang"));

        Map<String, String> stringStringMap = icrudServiceServeice.insertService(new Service(tenDichVu, dienTich, chiPhiThue, soNguoiToiDa,
                maKieuThue, maLoaiDichVu, tieuChuanPhong, moTaTienNghiKhac, dienTichHoBoi, soTang));
        if (stringStringMap.isEmpty()) {
            request.setAttribute("message", "đã thêm mới thành công");
            request.getRequestDispatcher("view/service/create.jsp").forward(request, response);
        } else {
            request.setAttribute("error", stringStringMap);
            request.getRequestDispatcher("view/service/create.jsp").forward(request, response);
        }

    }

    private void listService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Service> serviceList = icrudServiceServeice.selectAllService();
        request.setAttribute("serviceLists", serviceList);
        List<KieuThue> kieuThueList = kieuThueReponsitory.selectAllKieuThue();
        request.setAttribute("kieuThue", kieuThueList);
        List<LoaiDichVu> loaiDichVus = loaiDichVuSrevice.selectAllLoaiDichVu();
        request.setAttribute("maLoaiDichVu", loaiDichVus);

        request.getRequestDispatcher("/view/service/list.jsp").forward(request, response);

    }

    private void showCreateService(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("view/service/create.jsp").forward(request, response);

    }
}
