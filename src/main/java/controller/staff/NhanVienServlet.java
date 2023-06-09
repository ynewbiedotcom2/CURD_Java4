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
import java.sql.Date;
import java.util.ArrayList;
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
    private List<String> listError = new ArrayList<>();


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

    public boolean validateNhanVienEntity(NhanVienEntity nv) {
        int check = 0;
        if (nv.getMa() == null || nv.getMa().trim().isEmpty()) {
            System.out.println("Vui lòng nhập mã.");
            listError.add("Vui lòng nhập mã.");
            check--;
        }
        if (this.nvRepo.findByMa(nv.getMa()) != null ) {
            System.out.println("Vui lòng nhập mã Khác.");
            listError.add("Vui lòng nhập mã khac.");
            check--;
        }

        if (nv.getTen() == null || nv.getTen().trim().isEmpty()) {
            System.out.println("Vui lòng nhập tên.");
            listError.add("Vui lòng nhập ten.");
            check--;
        }

        if (nv.getHo() == null || nv.getHo().trim().isEmpty()) {
            System.out.println("Vui lòng nhập họ.");
            listError.add("Vui lòng nhập ho.");
            check--;
        }

        if (nv.getNgaySinh() == null) {
            System.out.println("Vui lòng nhập ngày sinh.");
            listError.add("Vui lòng nhập ngay sinh.");
            check--;
        }

        if (nv.getDiaChi() == null || nv.getDiaChi().trim().isEmpty()) {
            System.out.println("Vui lòng nhập địa chỉ.");
            listError.add("Vui lòng nhập dia chi.");
            check--;
        }

        if (nv.getSdt() == null || nv.getSdt().trim().isEmpty()) {
            System.out.println("Vui lòng nhập số điện thoại.");
            listError.add("Vui lòng nhập sdt.");
            check--;
        }

        if (nv.getMatKhau() == null || nv.getMatKhau().trim().isEmpty()) {
            System.out.println("Vui lòng nhập mật khẩu.");
            listError.add("Vui lòng nhập mat khau.");
            check--;
        }


        // Kiểm tra định dạng số điện thoại bằng regex
        String regex = "^(\\+84|0)\\d{9,10}$";


        if (nv.getSdt().matches(regex) == false) {
            System.out.println("Số điện thoại không hợp lệ!");
            listError.add("Vui lòng nhập sdt hop le.");
            check--;
        }


        if (check < 0) {
            return false;
        }return true;}
        public boolean validateNhanVienEntity2 (NhanVienEntity nv){
            int check = 0;
            if (nv.getMa() == null || nv.getMa().trim().isEmpty()) {
                System.out.println("Vui lòng nhập mã.");
                listError.add("Vui lòng nhập mã.");
                check--;
            }


            if (nv.getTen() == null || nv.getTen().trim().isEmpty()) {
                System.out.println("Vui lòng nhập tên.");
                listError.add("Vui lòng nhập ten.");
                check--;
            }

            if (nv.getHo() == null || nv.getHo().trim().isEmpty()) {
                System.out.println("Vui lòng nhập họ.");
                listError.add("Vui lòng nhập ho.");
                check--;
            }

            if (nv.getNgaySinh() == null) {
                System.out.println("Vui lòng nhập ngày sinh.");
                listError.add("Vui lòng nhập ngay sinh.");
                check--;
            }

            if (nv.getDiaChi() == null || nv.getDiaChi().trim().isEmpty()) {
                System.out.println("Vui lòng nhập địa chỉ.");
                listError.add("Vui lòng nhập dia chi.");
                check--;
            }

            if (nv.getSdt() == null || nv.getSdt().trim().isEmpty()) {
                System.out.println("Vui lòng nhập số điện thoại.");
                listError.add("Vui lòng nhập sdt.");
                check--;
            }

            if (nv.getMatKhau() == null || nv.getMatKhau().trim().isEmpty()) {
                System.out.println("Vui lòng nhập mật khẩu.");
                listError.add("Vui lòng nhập mat khau.");
                check--;
            }


            // Kiểm tra định dạng số điện thoại bằng regex
            String regex = "^(\\+84|0)\\d{9,10}$";


            if (nv.getSdt().matches(regex) == false) {
                System.out.println("Số điện thoại không hợp lệ!");
                listError.add("Vui lòng nhập sdt hop le.");
                check--;
            }


            if (check < 0) {
                return false;
            }
            return true;
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
        nv.setId(UUID.fromString(request.getParameter("id")));
        nv.setHo(request.getParameter("ho"));
        nv.setTenDem(request.getParameter("tenDem"));
        nv.setTen(request.getParameter("ten"));
        nv.setDiaChi(request.getParameter("diaChi"));
        nv.setGioiTinh(request.getParameter("gioiTinh"));
        nv.setMa(request.getParameter("ma"));
        nv.setMatKhau(request.getParameter("matKhau"));
        nv.setSdt(request.getParameter("sdt"));
        nv.setTrangThai(1);
        String date = request.getParameter("ngaySinh");

        nv.setNgaySinh(Date.valueOf(date));
        nv.setChucVuByIdCv(cvRepo.findById(UUID.fromString(request.getParameter("idCv"))));
        nv.setCuaHangByIdCh(chRepo.findById(UUID.fromString(request.getParameter("idCh"))));
        if (validateNhanVienEntity2(nv) == true) {
            this.nvRepo.update(nv);
        } else {
            System.out.println("lỗi: ");
            HttpSession session = request.getSession();
            session.setAttribute("listError",listError);  session.setAttribute("errorMessage", "loi o vi tri");
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
            if (validateNhanVienEntity(nv) == true) {
                this.nvRepo.insert(nv);
            } else {
                System.out.println("lỗi: ");
                HttpSession session = request.getSession();
                session.setAttribute("listError",listError);  session.setAttribute("errorMessage", "loi o vi tri");
            }
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
            HttpSession session = request.getSession();
        session.setAttribute("listError", null);
            session.setAttribute("curentPage", "Thêm Nhân Viên Mới");
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
            HttpSession session = request.getSession();
        session.setAttribute("listError", null);
            session.setAttribute("curentPage", "Sửa Thông Tin Nhân Viên");
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
            HttpSession session = request.getSession();
            session.setAttribute("curentPage", "Danh Sách Nhân Viên");
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
            response.sendRedirect("/CURD_war_exploded/nhan_vien/form");
        } else {
            session.setAttribute("errorMessage", null);
            response.sendRedirect("/CURD_war_exploded/trang_chu/home");
            session.setAttribute("nv", nv);
        }

    }


}
