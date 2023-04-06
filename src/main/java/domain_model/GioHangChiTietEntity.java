package domain_model;

import jakarta.persistence.*;

@Entity
@Table(name = "GioHangChiTiet")
@IdClass(GioHangChiTietEntityPK.class)
public class GioHangChiTietEntity {
    @Id
    @JoinColumn(name = "idgiohang" , referencedColumnName = "id")
    @ManyToOne
    private GioHangEntity gioHangByIdGioHang;
    @Id
    @JoinColumn(name = "idchitietsp" , referencedColumnName = "id")
    @ManyToOne
    private ChiTietSpEntity chiTietSpByIdChiTietSp;

    @Column(name = "SoLuong")
    private Integer soLuong;

    @Column(name = "DonGia")
    private Integer donGia;

    @Column(name = "DonGiaKhiGiam")
    private Integer donGiaKhiGiam;

    public GioHangChiTietEntity(GioHangEntity gioHangByIdGioHang, ChiTietSpEntity chiTietSpByIdChiTietSp, Integer soLuong, Integer donGia, Integer donGiaKhiGiam) {
        this.gioHangByIdGioHang = gioHangByIdGioHang;
        this.chiTietSpByIdChiTietSp = chiTietSpByIdChiTietSp;
        this.soLuong = soLuong;
        this.donGia = donGia;
        this.donGiaKhiGiam = donGiaKhiGiam;
    }

    public GioHangChiTietEntity() {
    }

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

    public Integer getDonGiaKhiGiam() {
        return donGiaKhiGiam;
    }

    public void setDonGiaKhiGiam(Integer donGiaKhiGiam) {
        this.donGiaKhiGiam = donGiaKhiGiam;
    }
}
