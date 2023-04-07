package controller.staff;

import Repositories.*;
import domain_model.ChiTietSpEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.UUID;

@WebServlet(name = "SanPhamChiTietServlet", value = {
        "/kho_hang/index",
        "/kho_hang/edit",
        "/kho_hang/create",
        "/kho_hang/delete",
        "/kho_hang/update",
        "/kho_hang/store",
})
public class SanPhamChiTietServlet extends HttpServlet {
    private ChiTietSanPhamRepo ctspRepo;
    private SanPhamRepo spRepo;
    private DongSpRepo dongSpRepo;
    private MauSacRepo msRepo;
    private NsxRepo nsxRepo;

    public SanPhamChiTietServlet() {
        ctspRepo = new ChiTietSanPhamRepo();
        dongSpRepo = new DongSpRepo();
        msRepo = new MauSacRepo();
        nsxRepo = new NsxRepo();
        spRepo = new SanPhamRepo();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        if (uri.contains("create")) {
            this.create(request, response);
        } else if (uri.contains("index")) {
            this.index(request, response);
        } else if (uri.contains("delete")) {
            this.delete(request, response);
        } else if (uri.contains("edit")) {
            this.edit(request, response);
        }
    }


    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        System.out.println(9099);
        String ma = request.getParameter("id");
        this.ctspRepo.delete(this.ctspRepo.findById(ma));
        response.sendRedirect("/CURD_war_exploded/kho_hang/index");



    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("listMs", this.msRepo.findAll());
        request.setAttribute("listNsx", this.nsxRepo.findAll());
        request.setAttribute("listDong", this.dongSpRepo.findAll());
        request.setAttribute("listSp", this.spRepo.findAll());
        request.setAttribute("view", "/views/kho_hang/create.jsp");
        request.getRequestDispatcher("/views/trang_chu/layout.jsp")
                .forward(request, response);
    }



    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        request.setAttribute("list", this.ctspRepo.findAll());
        request.setAttribute("view", "/views/kho_hang/index.jsp");
        request.getRequestDispatcher("/views/trang_chu/layout.jsp")
                .forward(request, response);

    }

    protected void edit(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        ChiTietSpEntity ctsp = this.ctspRepo.findById(request.getParameter("id"));
        request.setAttribute("listMs", this.msRepo.findAll());
        request.setAttribute("listNsx", this.nsxRepo.findAll());
        request.setAttribute("listDong", this.dongSpRepo.findAll());
        request.setAttribute("listSp", this.spRepo.findAll());
        request.setAttribute("ctsp",ctsp);
        request.setAttribute("view", "/views/kho_hang/edit.jsp");
        request.getRequestDispatcher("/views/trang_chu/layout.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
//        
        if (uri.contains("store")) {
            this.store(request, response);
        } else if (uri.contains("update")) {
            this.update(request, response);
        }
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {


        ChiTietSpEntity vm = new ChiTietSpEntity();
        try {
            BeanUtils.populate(vm, request.getParameterMap());
            vm.setDongSpByIdDongSp(this.dongSpRepo.findById(UUID.fromString(request.getParameter("idDongSp"))));
            vm.setMauSacByIdMauSac(this.msRepo.findById(UUID.fromString(request.getParameter("idMauSac"))));
            vm.setSanPhamByIdSp(this.spRepo.findById(UUID.fromString(request.getParameter("idSp"))));
            vm.setNsxByIdNsx(this.nsxRepo.findById(UUID.fromString(request.getParameter("idNsx"))));
            if (validateProduct(vm)){
                this.ctspRepo.insert(vm);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/CURD_war_exploded/kho_hang/index");
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        ChiTietSpEntity vm = new ChiTietSpEntity();
        try {
            BeanUtils.populate(vm, request.getParameterMap());
            vm.setId(UUID.fromString(request.getParameter("idx")));
            vm.setDongSpByIdDongSp(this.dongSpRepo.findById(UUID.fromString(request.getParameter("idDongSp"))));
            vm.setMauSacByIdMauSac(this.msRepo.findById(UUID.fromString(request.getParameter("idMauSac"))));
            vm.setSanPhamByIdSp(this.spRepo.findById(UUID.fromString(request.getParameter("idSp"))));
            vm.setNsxByIdNsx(this.nsxRepo.findById(UUID.fromString(request.getParameter("idNsx"))));
            if (validateProduct(vm)){
                this.ctspRepo.update(vm);
            }

        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/CURD_war_exploded/kho_hang/index");

    }
    public boolean validateProduct(ChiTietSpEntity ctsp) {
        int check = 0;
        if (ctsp.getNamBh() == null || ctsp.getNamBh() < 0) {
            System.out.println("Năm bảo hành không hợp lệ!");
            check--;
        }


        if (ctsp.getSoLuongTon() == null || ctsp.getSoLuongTon() < 0) {
            System.out.println("Số lượng tồn không hợp lệ!");
            check--;
        }

        if (ctsp.getGiaNhap() == null || ctsp.getGiaNhap() < 0) {
            System.out.println("Giá nhập không hợp lệ!");
            check--;
        }

        if (ctsp.getGiaBan() == null || ctsp.getGiaBan() < 0) {
            System.out.println("Giá bán không hợp lệ!");
            check--;
        }
        if(check<0){
           return false;
        }
        return true;
    }

}
