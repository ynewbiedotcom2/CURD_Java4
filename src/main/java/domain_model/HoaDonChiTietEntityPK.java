package domain_model;

import java.io.Serializable;

public class HoaDonChiTietEntityPK implements Serializable {
    private HoaDonEntity hoaDonByIdHoaDon;
    private ChiTietSpEntity chiTietSpByIdChiTietSp;

    public HoaDonEntity getHoaDonByIdHoaDon() {
        return hoaDonByIdHoaDon;
    }

    public void setHoaDonByIdHoaDon(HoaDonEntity hoaDonByIdHoaDon) {
        this.hoaDonByIdHoaDon = hoaDonByIdHoaDon;
    }

    public ChiTietSpEntity getChiTietSpByIdChiTietSp() {
        return chiTietSpByIdChiTietSp;
    }

    public void setChiTietSpByIdChiTietSp(ChiTietSpEntity chiTietSpByIdChiTietSp) {
        this.chiTietSpByIdChiTietSp = chiTietSpByIdChiTietSp;
    }
}
