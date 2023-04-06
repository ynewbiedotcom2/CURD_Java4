package controller.staff;

import Repositories.ChucVuRepo;
import Repositories.CuaHangRepo;
import Repositories.NhanVienRepo;
import domain_model.NhanVienEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "NhanVienServlet", value = {
        "/nhan_vien/store",
        "/nhan_vien/create",
        "/nhan_vien/delete",
        "/nhan_vien/edit",
        "/nhan_vien/index",
        "/nhan_vien/update",
        "/nhan_vien/login",
        "/nhan_vien/form",
})
public class NhanVienServlet extends HttpServlet {
    private NhanVienRepo nvRepo;
    private ChucVuRepo cvRepo;
    private CuaHangRepo chRepo;

    public NhanVienServlet() {
        this.nvRepo = new NhanVienRepo();
        this.chRepo = new CuaHangRepo();
        this.cvRepo = new ChucVuRepo();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("form")) {
            this.form(request, response);
        } else if (uri.contains("edit")) {
            this.edit(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else if (uri.contains("index")) {
            this.index(request, response);
        } else if (uri.contains("create")) {
            this.create(request, response);
        } else {
            this.index(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("login")) {
            this.login(request, response);
        } else if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        }
    }

    protected void form(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("errorMessage", null);
        request.getRequestDispatcher("/views/nhan_vien/login.jsp")
                .forward(request, response);
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        NhanVienEntity nv = new NhanVienEntity();
        try {
            BeanUtils.populate(nv, request.getParameterMap());
            nv.setChucVuByIdCv(cvRepo.findById(UUID.fromString(request.getParameter("idCv"))));
            nv.setCuaHangByIdCh(chRepo.findById(UUID.fromString(request.getParameter("idCh"))));
            this.nvRepo.update(nv);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/CURD_war_exploded/nhan_vien/index");
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        NhanVienEntity nv = new NhanVienEntity();
        try {
            BeanUtils.populate(nv, request.getParameterMap());
            nv.setChucVuByIdCv(cvRepo.findById(UUID.fromString(request.getParameter("idCv"))));
            nv.setCuaHangByIdCh(chRepo.findById(UUID.fromString(request.getParameter("idCh"))));
            this.nvRepo.insert(nv);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/CURD_war_exploded/nhan_vien/index");
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("listCh", this.chRepo.findAll());
        request.setAttribute("listCv", this.cvRepo.findAll());
        request.setAttribute("view", "/views/nhan_vien/create.jsp");
        request.getRequestDispatcher("/views/trang_chu/layout.jsp")
                .forward(request, response);
    }

    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        NhanVienEntity x = this.nvRepo.findById(UUID.fromString(request.getParameter("id")));

        request.setAttribute("listCh", this.chRepo.findAll());
        request.setAttribute("listCv", this.cvRepo.findAll());
        request.setAttribute("nv", x);
        request.setAttribute("view", "/views/nhan_vien/edit.jsp");
        request.getRequestDispatcher("/views/trang_chu/layout.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String id = request.getParameter("id");
        nvRepo.delete(this.nvRepo.findById(UUID.fromString(id)));
        response.sendRedirect("/CURD_war_exploded/nhan_vien/index");
    }



    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        List<NhanVienEntity> nve = this.nvRepo.findAll();

        request.setAttribute("list", nve);
        request.setAttribute("view", "/views/nhan_vien/index.jsp");
        request.getRequestDispatcher("/views/trang_chu/layout.jsp")
                .forward(request, response);
    }

    protected void login(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("ma");
        String matKhau = request.getParameter("matKhau");
        NhanVienEntity nv = nvRepo.login(ma, matKhau);
        HttpSession session = request.getSession();

        if (nv == null) {
            session.setAttribute("errorMessage", "Sai tài khoản/mật khẩu");
            response.sendRedirect("/CURD_war_exploded/nhan_vien/login");
        } else {
            session.setAttribute("errorMessage", null);
            response.sendRedirect("/CURD_war_exploded/trang_chu/home");
            session.setAttribute("nv", nv);
        }

    }


}
