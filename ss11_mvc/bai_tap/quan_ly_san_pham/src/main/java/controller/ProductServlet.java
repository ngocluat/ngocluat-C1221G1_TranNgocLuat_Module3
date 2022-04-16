package controller;

import model.Product;
import model.reponsitory.ProductseviceImp;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ProductServlet", urlPatterns = {"/product", "/"})
public class ProductServlet extends HttpServlet {
    ProductseviceImp produceServiceimp = new ProductseviceImp();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }

        System.out.println(action);
        switch (action) {
            case "create":
                createProduct(request, response);
                break;
            case "delete":
                deleteProduct(request, response);
                break;
            case "update":
                updateProduct(request, response);
                break;

        }
    }

    private void deleteProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product customer = this.produceServiceimp.findById(id);
        RequestDispatcher dispatcher;
        if (customer == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            produceServiceimp.delete(id);
            try {
                response.sendRedirect("/product");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }


    private void createProduct(HttpServletRequest request, HttpServletResponse response) {

        String tenSanPham = request.getParameter("tenSanPham");
        String moTa = request.getParameter("moTa");
        double gia = Double.parseDouble(request.getParameter("gia"));
        int id = (int) (Math.random() * 10000);

        Product product = new Product(id, tenSanPham, moTa, gia);
        produceServiceimp.save(product);

        request.setAttribute("product", produceServiceimp);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/them_moi.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void viewCustomer(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setAttribute("product", produceServiceimp.display());
        request.getRequestDispatcher("/hien_thi.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        System.out.println(action);
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "update":
                showUpdateProduct(request, response);
                break;
            case "delete":
                showDleteForm(request, response);
                break;
            case "search":
               search(request, response);
                break;
            default:
                viewCustomer(request, response);
                break;
        }
    }

    private void search(HttpServletRequest request, HttpServletResponse response) {
        String name  = request.getParameter("name");
        Product product = produceServiceimp.seach(name);
        request.setAttribute("products", product);
        try {
            request.getRequestDispatcher("tim.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showUpdateProduct(HttpServletRequest request, HttpServletResponse response) {
            int id = Integer.parseInt(request.getParameter("id"));
        Product product = produceServiceimp.findById(id);
        request.setAttribute("products", product);
        try {
            request.getRequestDispatcher("sua.jsp").forward(request,response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

    private void showDleteForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = this.produceServiceimp.findById(id);
        System.out.println(product.getId());
        request.setAttribute("product", product);
        try {
            request.getRequestDispatcher("/xoa.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("them_moi.jsp").forward(request, response);
    }

    private void updateProduct(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        String tenSanPham = request.getParameter("tenSanPham");
        String moTa = request.getParameter("moTa");
        String gia =request.getParameter("gia");
        Product product = produceServiceimp.findById(id);
        RequestDispatcher dispatcher;
        if (product == null) {
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            product.setTenSanPham(tenSanPham);
            product.setMoTa(moTa);
            product.setGia(Double.parseDouble(gia));
             produceServiceimp.update(id, product);
            request.setAttribute("product", product);
            request.setAttribute("message", "Product information was updated");
            dispatcher = request.getRequestDispatcher("sua.jsp");
//            try {
//                response.sendRedirect("/product?cation=false");
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }
    }

}

