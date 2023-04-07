package controller.staff;

import Repositories.MauSacRepo;
import domain_model.MauSacEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "MauSacServlet", value = {"/mau_sac/index",
        "/mau_sac/create",
        "/mau_sac/edit",
        "/mau_sac/delete",
        "/mau_sac/store",
        "/mau_sac/update"})
public class MauSacServlet extends HttpServlet {
    private MauSacRepo chRepo;

    public MauSacServlet() {
        this.chRepo = new MauSacRepo();
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
    ) throws ServletException, IOException {
        String ma = request.getParameter("id");
        MauSacEntity domainModelKH = this.chRepo.findById(UUID.fromString(ma));
        request.setAttribute("nv", domainModelKH);
        request.setAttribute("view", "/views/mau_sac/edit.jsp");
        request.getRequestDispatcher("/views/trang_chu/layout.jsp")
                .forward(request, response);
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("list", this.chRepo.findAll());
        request.setAttribute("view", "/views/mau_sac/index.jsp");
        request.getRequestDispatcher("/views/trang_chu/layout.jsp")
                .forward(request, response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("view", "/views/mau_sac/create.jsp");
        request.getRequestDispatcher("/views/trang_chu/layout.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("id");
        MauSacEntity domainModelKH = this.chRepo.findById(UUID.fromString(ma));
        domainModelKH.setTen(null);

        this.chRepo.update(domainModelKH);

        response.sendRedirect("/CURD_war_exploded/mau_sac/index");

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
            response.sendRedirect("/CURD_war_exploded/mau_sac/index");
        }
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("idx");
        MauSacEntity domainModelKH = new MauSacEntity();
        try {
            BeanUtils.populate(domainModelKH, request.getParameterMap());
            domainModelKH.setId(UUID.fromString(ma));

            if (validateMauSacEntity2(domainModelKH)) {
                this.chRepo.update(domainModelKH);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        response.sendRedirect("/CURD_war_exploded/mau_sac/index");
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        MauSacEntity domainModelKH = new MauSacEntity();
        try {
            BeanUtils.populate(domainModelKH, request.getParameterMap());
            if (validateMauSacEntity(domainModelKH)) {
                this.chRepo.insert(domainModelKH);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Thêm thành công");
        response.sendRedirect("/CURD_war_exploded/mau_sac/index");
    }

    public boolean validateMauSacEntity(MauSacEntity kh) {
        int check = 0;
        if (kh.getMa() == null || kh.getMa().trim().isEmpty()) {
            System.out.println("Mã không được để trống!");
            check--;
        }
        if (this.chRepo.findByMa(kh.getMa()) != null) {
            System.out.println("Mã Đã tồn tại!");
            check--;
        }

        if (kh.getTen() == null || kh.getTen().trim().isEmpty()) {
            System.out.println("Tên không được để trống!");
            check--;
        }

        if (check < 0) {
            return false;
        }
        return true;


    } public boolean validateMauSacEntity2(MauSacEntity kh) {
        int check = 0;
        if (kh.getMa() == null || kh.getMa().trim().isEmpty()) {
            System.out.println("Mã không được để trống!");
            check--;
        }


        if (kh.getTen() == null || kh.getTen().trim().isEmpty()) {
            System.out.println("Tên không được để trống!");
            check--;
        }

        if (check < 0) {
            return false;
        }
        return true;


    }
}
