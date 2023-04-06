package controller.staff;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "TrangChuServlet", value = {
        "/trang_chu/home",
        })
public class TrangChuServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("home")) {
            this.home(request, response);
//        } else if (uri.contains("edit")) {
//            this.edit(request, response);
//        } else if (uri.contains("delete")) {
//            this.delete(request, response);
//        } else {
//            this.index(request, response);
        }
    }
    protected void home(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("view","/views/trang_chu/home.jsp");
        request.getRequestDispatcher("/views/trang_chu/layout.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
