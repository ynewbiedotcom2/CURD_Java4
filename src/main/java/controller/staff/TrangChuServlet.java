package controller.staff;

import Repositories.ChiTietSanPhamRepo;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "TrangChuServlet", value = {
        "/trang_chu/home",
        "/trang_chu/error",
})
public class TrangChuServlet extends HttpServlet {
    private ChiTietSanPhamRepo ctspRepo;

    public TrangChuServlet() {
        this.ctspRepo = new ChiTietSanPhamRepo();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("home")) {
            this.home(request, response);
        } else if (uri.contains("error")) {
            this.error(request, response);
//        } else if (uri.contains("delete")) {
//            this.delete(request, response);
//        } else {
//            this.index(request, response);
        }
    }
    protected void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("curentPage", "Bán Hàng");
        session.setAttribute("listError", null);
        request.setAttribute("lssp", this.ctspRepo.findAll());
        request.setAttribute("view", "/views/ban_hang/thuNgan.jsp");
        request.getRequestDispatcher("/views/trang_chu/layout.jsp")
                .forward(request, response);
    }protected void error(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("curentPage", "Thong Bao Loi");


        request.setAttribute("view", "/views/trang_chu/errorMessage.jsp");
        request.getRequestDispatcher("/views/trang_chu/layout.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
