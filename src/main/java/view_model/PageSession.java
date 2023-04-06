package view_model;

import domain_model.NhanVienEntity;

import java.util.List;

public class PageSession {
    private String currentPage;
    private List<String> errorMesage;
    private Object data;
    private NhanVienEntity nv;

    public String getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(String currentPage) {
        this.currentPage = currentPage;
    }

    public List<String> getErrorMesage() {
        return errorMesage;
    }

    public void setErrorMesage(List<String> errorMesage) {
        this.errorMesage = errorMesage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public NhanVienEntity getNv() {
        return nv;
    }

    public void setNv(NhanVienEntity nv) {
        this.nv = nv;
    }

    public PageSession() {
    }

    public PageSession(String currentPage, List<String> errorMesage, Object data, NhanVienEntity nv) {
        this.currentPage = currentPage;
        this.errorMesage = errorMesage;
        this.data = data;
        this.nv = nv;
    }
}
