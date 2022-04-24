package controller;

import model.Customer;
import model.Employee;
import model.HopDong;
import model.Service;
import service.customer.CustomerServiceImpl;
import service.customer.ICRUDCustomer;
import service.employee.EmployeeServiceImpl;
import service.employee.ICRUDEmployeeService;
import service.hop_dong_service.HopDongSeviceIpml;
import service.hop_dong_service.IHopDongService;
import service.service.ICRUDServiceServeice;
import service.service.ServiceServeiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ContractServlet", urlPatterns = "/contract")
public class ContractServlet extends HttpServlet {
    ICRUDEmployeeService icrudEmployeeService = new EmployeeServiceImpl();
    ICRUDCustomer icrudCustomer = new CustomerServiceImpl();
    ICRUDServiceServeice icrudServiceServeice = new ServiceServeiceImpl();

    IHopDongService ihopDongSevice = new HopDongSeviceIpml();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("actionContract");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                createContract(request, response);
                break;

        }
    }

    private void createContract(HttpServletRequest request, HttpServletResponse response) {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("actionContract");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateContract(request, response);
                break;
            default:
                listContract(request, response);
                break;

        }
    }

    private void listContract(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Employee> employeeList = icrudEmployeeService.selectAllEmployeer();
        request.setAttribute("employee", employeeList);

        List<Customer> customerList = icrudCustomer.selectAllCustomer();
        request.setAttribute("customerLists", customerList);

        List<Service> serviceList = icrudServiceServeice.selectAllService();
        request.setAttribute("serviceLists", serviceList);

        List<HopDong> hopDongList = ihopDongSevice.listHopDong();
        request.setAttribute("hopDong", hopDongList);
        request.getRequestDispatcher("view/contract/list.jsp").forward(request, response);


    }

    private void showCreateContract(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("view/contract/create.jsp").forward(request, response);
    }
}
