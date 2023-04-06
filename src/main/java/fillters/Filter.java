package fillters;

import domain_model.NhanVienEntity;
import jakarta.servlet.*;
import jakarta.servlet.annotation.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(filterName = "FilterAuthencation",value = {
        "/trang_chu/*",

})
public class Filter implements jakarta.servlet.Filter {


    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain
    ) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse res = (HttpServletResponse) servletResponse;
        HttpSession session = req.getSession();
        NhanVienEntity nv = (NhanVienEntity) session.getAttribute("nv");

        if (nv == null) {
            session.setAttribute("errorMessage", "Vui lòng đăng nhập");
            res.sendRedirect("/CURD_war_exploded/nhan_vien/form");
        } else {
            filterChain.doFilter(req, res);
        }
    }
}
