package controller.staff;

import Repositories.CuaHangRepo;
import domain_model.CuaHangEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "CuaHangServlet", value = {
        "/cua_hang/index",
        "/cua_hang/create",
        "/cua_hang/edit",
        "/cua_hang/delete",
        "/cua_hang/store",
        "/cua_hang/update"
})
public class CuaHangServlet extends HttpServlet {
    private CuaHangRepo chRepo;

    public CuaHangServlet() {
        this.chRepo = new CuaHangRepo();
    }

    @Override
    protected void doGet(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("create")) {
            this.create(request, response);
        } else if (uri.contains("edit")) {
            this.edit(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else {
            this.index(request, response);
        }
    }

    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {HttpSession session = request.getSession();
        session.setAttribute("curentPage", "Sửa Thông Tin Cửa Hàng");

        String ma = request.getParameter("id");
        CuaHangEntity domainModelKH = this.chRepo.findById(UUID.fromString(ma));
        request.setAttribute("nv", domainModelKH);
        request.setAttribute("view", "/views/cua_hang/edit.jsp");
        request.getRequestDispatcher("/views/trang_chu/layout.jsp")
                .forward(request, response);
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("curentPage", "Danh Sách Cửa Hàng");
        request.setAttribute("list", this.chRepo.findAll());
        request.setAttribute("view", "/views/cua_hang/index.jsp");
        request.getRequestDispatcher("/views/trang_chu/layout.jsp")
                .forward(request, response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("curentPage", "Thêm Cửa Hàng");
        request.setAttribute("view", "/views/cua_hang/create.jsp");
        request.getRequestDispatcher("/views/trang_chu/layout.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("id");
        CuaHangEntity domainModelKH = this.chRepo.findById(UUID.fromString(ma));
        domainModelKH.setTen(null);
        domainModelKH.setDiaChi("Đã xóa");
        this.chRepo.update(domainModelKH);


        response.sendRedirect("/CURD_war_exploded/cua_hang/index");

    }

    @Override
    protected void doPost(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        } else {
            response.sendRedirect("/CURD_war_exploded/cua_hang/index");
        }
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("idx");
        CuaHangEntity domainModelKH = new CuaHangEntity();
        try {
            BeanUtils.populate(domainModelKH, request.getParameterMap());
            domainModelKH.setId(UUID.fromString(ma));

            if (validateCuaHangEntity2(domainModelKH)) {
                this.chRepo.update(domainModelKH);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("/CURD_war_exploded/cua_hang/index");
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        CuaHangEntity domainModelKH = new CuaHangEntity();
        try {
            BeanUtils.populate(domainModelKH, request.getParameterMap());
            if (validateCuaHangEntity(domainModelKH)) {
                this.chRepo.insert(domainModelKH);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Thêm thành công");
        response.sendRedirect("/CURD_war_exploded/cua_hang/index");
    }

    public boolean validateCuaHangEntity(CuaHangEntity kh) {
        int check = 0;
        if (kh.getMa() == null || kh.getMa().trim().isEmpty()) {
            System.out.println("Mã không được để trống!");
            check--;
        }
        if (this.chRepo.findByMa(kh.getMa()) != null ) {
            System.out.println("Mã đã tồn tại!");
            check--;
        }

        if (kh.getTen() == null || kh.getTen().trim().isEmpty()) {
            System.out.println("Tên không được để trống!");
            check--;
        }


        if (kh.getDiaChi() == null || kh.getDiaChi().trim().isEmpty()) {
            System.out.println("Địa chỉ không được để trống!");
            check--;
        }


        if (check < 0) {
            return false;
        }
        return true;


    } public boolean validateCuaHangEntity2(CuaHangEntity kh) {
        int check = 0;
        if (kh.getMa() == null || kh.getMa().trim().isEmpty()) {
            System.out.println("Mã không được để trống!");
            check--;
        }


        if (kh.getTen() == null || kh.getTen().trim().isEmpty()) {
            System.out.println("Tên không được để trống!");
            check--;
        }


        if (kh.getDiaChi() == null || kh.getDiaChi().trim().isEmpty()) {
            System.out.println("Địa chỉ không được để trống!");
            check--;
        }


        if (check < 0) {
            return false;
        }
        return true;


    }
}
