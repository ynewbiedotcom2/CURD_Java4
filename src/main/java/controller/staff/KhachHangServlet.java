package controller.staff;

import Repositories.KhachHangRepo;
import domain_model.KhachHangEntity;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@WebServlet({
        "/khach_hang/index",    // GET
        "/khach_hang/create",   // GET
        "/khach_hang/store",    // POST
        "/khach_hang/edit",     // GET
        "/khach_hang/update",   // POST
        "/khach_hang/delete",   // GET
})
public class KhachHangServlet extends HttpServlet {
    private KhachHangRepo khRepo;
    private List<String> listError = new ArrayList<>();
    public KhachHangServlet() {
        this.khRepo = new KhachHangRepo();
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
        HttpSession session = request.getSession();
        session.setAttribute("curentPage", "Sửa Thông Tin Khách Hàng");
        String ma = request.getParameter("id");
        KhachHangEntity domainModelKH = this.khRepo.findById(ma);
        request.setAttribute("kh", domainModelKH);
        request.setAttribute("view", "/views/khach_hang/edit.jsp");
        request.getRequestDispatcher("/views/trang_chu/layout.jsp")
                .forward(request, response);
    }

    protected void index(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("curentPage", "Danh Sách Khách Hàng");
        request.setAttribute("list", this.khRepo.findAll());
        request.setAttribute("view", "/views/khach_hang/index.jsp");
        request.getRequestDispatcher("/views/trang_chu/layout.jsp")
                .forward(request, response);
    }

    protected void create(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.setAttribute("curentPage", "Thêm Khách Hàng");
        request.setAttribute("view", "/views/khach_hang/create.jsp");
        request.getRequestDispatcher("/views/trang_chu/layout.jsp")
                .forward(request, response);
    }

    protected void delete(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("id");
        KhachHangEntity domainModelKH = this.khRepo.findById(ma);
        if (domainModelKH == null) {
            System.out.println("Không tìm thấy");
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        } else {
            this.khRepo.delete(domainModelKH);
            response.sendRedirect("/CURD_war_exploded/khach_hang/index");
        }
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
            response.sendRedirect("/CURD_war_exploded/khach_hang/index");
        }
    }

    protected void update(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        String ma = request.getParameter("idx");
        KhachHangEntity domainModelKH = new KhachHangEntity();
        try {
            BeanUtils.populate(domainModelKH, request.getParameterMap());
            domainModelKH.setId(UUID.fromString(ma));

            if (validateKhachHangEntity2(domainModelKH)) {
                this.khRepo.update(domainModelKH);
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("listError", listError);
                session.setAttribute("errorMessage", "loi o vi tri");
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

        response.sendRedirect("/CURD_war_exploded/khach_hang/index");
    }

    protected void store(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws ServletException, IOException {
        KhachHangEntity domainModelKH = new KhachHangEntity();
        try {
            BeanUtils.populate(domainModelKH, request.getParameterMap());
            if (validateKhachHangEntity(domainModelKH)) {
                this.khRepo.insert(domainModelKH);
                System.out.println("Thêm thành công");
            } else {
                HttpSession session = request.getSession();
                session.setAttribute("listError", listError);  session.setAttribute("errorMessage", "loi o vi tri");
            }
        } catch (Exception e) {
            e.printStackTrace();

        }


        response.sendRedirect("/CURD_war_exploded/khach_hang/index");
    }

    public boolean validateKhachHangEntity(KhachHangEntity kh) {
        int check = 0;

        if (this.khRepo.findByMa(kh.getMa()) != null) {
            System.out.println("Mã đã tồn tại!");
            listError.add("Ma da ton tai");
            check--;
        }

        if (kh.getMa() == null || kh.getMa().trim().isEmpty()) {
            System.out.println("Mã không được để trống!");
            listError.add("Mã không được để trống!");
            check--;
        }

        if (kh.getTen() == null || kh.getTen().trim().isEmpty()) {
            System.out.println("Tên không được để trống!");
            listError.add("Ten không được để trống!");
            check--;
        }

        if (kh.getHo() == null || kh.getHo().trim().isEmpty()) {
            System.out.println("Họ không được để trống!");
            listError.add("Ho không được để trống!");
            check--;
        }


        if (kh.getNgaySinh() == null) {
            System.out.println("Ngày sinh không được để trống!");
            listError.add("Ngay sinh không được để trống!");
            check--;
        }

        if (kh.getDiaChi() == null || kh.getDiaChi().trim().isEmpty()) {
            System.out.println("Địa chỉ không được để trống!");
            listError.add("dia chi không được để trống!");
            check--;
        }

        String regex = "^(\\+84|0)\\d{9,10}$";
        if (kh.getSdt().matches(regex) == false) {
            System.out.println("Số điện thoại không hợp lệ!");
            listError.add("Số điện thoại không hợp lệ!");
            check--;
        }

        if (kh.getSdt() == null || kh.getSdt().trim().isEmpty()) {
            System.out.println("Số điện thoại không được để trống!");
            listError.add("Số điện thoại không được để trống!");
            check--;
        }

        if (kh.getMatKhau() == null || kh.getMatKhau().isEmpty()) {
            System.out.println("Mật khẩu không được để trống!");
            listError.add("Mật khẩu không được để trống!");
            check--;
        }
        if (check < 0) {
            return false;
        }
        return true;


    }

    public boolean validateKhachHangEntity2(KhachHangEntity kh) {
        int check = 0;
        if (kh.getMa() == null || kh.getMa().trim().isEmpty()) {
            System.out.println("Mã không được để trống!");
            listError.add("Mã không được để trống!");
            check--;
        }

        if (kh.getTen() == null || kh.getTen().trim().isEmpty()) {
            System.out.println("Tên không được để trống!");
            listError.add("Ten không được để trống!");
            check--;
        }

        if (kh.getHo() == null || kh.getHo().trim().isEmpty()) {
            System.out.println("Họ không được để trống!");
            listError.add("Ho không được để trống!");
            check--;
        }


        if (kh.getNgaySinh() == null) {
            System.out.println("Ngày sinh không được để trống!");
            listError.add("Ngay sinh không được để trống!");
            check--;
        }

        if (kh.getDiaChi() == null || kh.getDiaChi().trim().isEmpty()) {
            System.out.println("Địa chỉ không được để trống!");
            listError.add("dia chi không được để trống!");
            check--;
        }

        String regex = "^(\\+84|0)\\d{9,10}$";
        if (kh.getSdt().matches(regex) == false) {
            System.out.println("Số điện thoại không hợp lệ!");
            listError.add("Số điện thoại không hợp lệ!");
            check--;
        }

        if (kh.getSdt() == null || kh.getSdt().trim().isEmpty()) {
            System.out.println("Số điện thoại không được để trống!");
            listError.add("Số điện thoại không được để trống!");
            check--;
        }

        if (kh.getMatKhau() == null || kh.getMatKhau().isEmpty()) {
            System.out.println("Mật khẩu không được để trống!");
            listError.add("Mật khẩu không được để trống!");
            check--;
        }
        if (check < 0) {
            return false;
        }
        return true;


    }
}
