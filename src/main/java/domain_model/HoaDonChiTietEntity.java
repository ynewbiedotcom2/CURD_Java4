package domain_model;

import jakarta.persistence.*;

@Entity
@Table(name = "HoaDonChiTiet")
@IdClass(HoaDonChiTietEntityPK.class)
public class HoaDonChiTietEntity {
    @Id
    @JoinColumn(name = "idHoaDon" , referencedColumnName = "id")
    @ManyToOne
    private HoaDonEntity hoaDonByIdHoaDon;
    @Id
    @JoinColumn(name = "idChiTietSp" , referencedColumnName = "id")
    @ManyToOne
    private ChiTietSpEntity chiTietSpByIdChiTietSp;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "dongia")
    private Integer donGia;

    public HoaDonChiTietEntity(HoaDonEntity hoaDonByIdHoaDon, ChiTietSpEntity chiTietSpByIdChiTietSp, Integer soLuong, Integer donGia) {
        this.hoaDonByIdHoaDon = hoaDonByIdHoaDon;
        this.chiTietSpByIdChiTietSp = chiTietSpByIdChiTietSp;
        this.soLuong = soLuong;
        this.donGia = donGia;
    }

    public HoaDonChiTietEntity() {
    }

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

    public Integer getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(Integer soLuong) {
        this.soLuong = soLuong;
    }

    public Integer getDonGia() {
        return donGia;
    }

    public void setDonGia(Integer donGia) {
        this.donGia = donGia;
    }
}
