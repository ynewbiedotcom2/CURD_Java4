package domain_model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

import java.io.Serializable;

public class GioHangChiTietEntityPK implements Serializable {
    private GioHangEntity gioHangByIdGioHang;
    private ChiTietSpEntity chiTietSpByIdChiTietSp;

    public GioHangEntity getGioHangByIdGioHang() {
        return gioHangByIdGioHang;
    }

    public void setGioHangByIdGioHang(GioHangEntity gioHangByIdGioHang) {
        this.gioHangByIdGioHang = gioHangByIdGioHang;
    }

    public ChiTietSpEntity getChiTietSpByIdChiTietSp() {
        return chiTietSpByIdChiTietSp;
    }

    public void setChiTietSpByIdChiTietSp(ChiTietSpEntity chiTietSpByIdChiTietSp) {
        this.chiTietSpByIdChiTietSp = chiTietSpByIdChiTietSp;
    }
}
