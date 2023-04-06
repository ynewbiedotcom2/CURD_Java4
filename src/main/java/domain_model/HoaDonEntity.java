package domain_model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "HoaDon")
public class HoaDonEntity {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "Ma")
    private String ma;
    @Column(name = "NgayTao")
    private Date ngayTao;

    @Column(name = "NgayThanhToan")
    private Date ngayThanhToan;

    @Column(name = "NgayShip")
    private Date ngayShip;

    @Column(name = "NgayNhan")
    private Date ngayNhan;

    @Column(name = "TinhTrang")
    private Integer tinhTrang;

    @Column(name = "TenNguoiNhan")
    private String tenNguoiNhan;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "Sdt")
    private String sdt;

    @ManyToOne
    @JoinColumn(name = "IdKH", referencedColumnName = "id")
    private KhachHangEntity khachHangByIdKh;

    @ManyToOne
    @JoinColumn(name = "IdNV", referencedColumnName = "id")
    private NhanVienEntity nhanVienByIdNv;

    @OneToMany(mappedBy = "hoaDonByIdHoaDon")
    private List<HoaDonChiTietEntity> listDHCT;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public Date getNgayThanhToan() {
        return ngayThanhToan;
    }

    public void setNgayThanhToan(Date ngayThanhToan) {
        this.ngayThanhToan = ngayThanhToan;
    }

    public Date getNgayShip() {
        return ngayShip;
    }

    public void setNgayShip(Date ngayShip) {
        this.ngayShip = ngayShip;
    }

    public Date getNgayNhan() {
        return ngayNhan;
    }

    public void setNgayNhan(Date ngayNhan) {
        this.ngayNhan = ngayNhan;
    }

    public Integer getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(Integer tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

    public String getTenNguoiNhan() {
        return tenNguoiNhan;
    }

    public void setTenNguoiNhan(String tenNguoiNhan) {
        this.tenNguoiNhan = tenNguoiNhan;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public KhachHangEntity getKhachHangByIdKh() {
        return khachHangByIdKh;
    }

    public void setKhachHangByIdKh(KhachHangEntity khachHangByIdKh) {
        this.khachHangByIdKh = khachHangByIdKh;
    }

    public NhanVienEntity getNhanVienByIdNv() {
        return nhanVienByIdNv;
    }

    public void setNhanVienByIdNv(NhanVienEntity nhanVienByIdNv) {
        this.nhanVienByIdNv = nhanVienByIdNv;
    }

    public List<HoaDonChiTietEntity> getListDHCT() {
        return listDHCT;
    }

    public void setListDHCT(List<HoaDonChiTietEntity> listDHCT) {
        this.listDHCT = listDHCT;
    }

    public HoaDonEntity() {
    }

    public HoaDonEntity(UUID id, String ma, Date ngayTao, Date ngayThanhToan, Date ngayShip, Date ngayNhan, Integer tinhTrang, String tenNguoiNhan, String diaChi, String sdt, KhachHangEntity khachHangByIdKh, NhanVienEntity nhanVienByIdNv, List<HoaDonChiTietEntity> listDHCT) {
        this.id = id;
        this.ma = ma;
        this.ngayTao = ngayTao;
        this.ngayThanhToan = ngayThanhToan;
        this.ngayShip = ngayShip;
        this.ngayNhan = ngayNhan;
        this.tinhTrang = tinhTrang;
        this.tenNguoiNhan = tenNguoiNhan;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.khachHangByIdKh = khachHangByIdKh;
        this.nhanVienByIdNv = nhanVienByIdNv;
        this.listDHCT = listDHCT;
    }
}
