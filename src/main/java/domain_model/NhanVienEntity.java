package domain_model;

import jakarta.persistence.*;

import java.sql.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "NhanVien")
public class NhanVienEntity {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "Ma")
    private String ma;
    @Column(name = "Ten")
    private String ten;
    @Column(name = "TenDem")
    private String tenDem;
    @Column(name = "Ho")
    private String ho;
    @Column(name = "GioiTinh")
    private String gioiTinh;
    @Column(name = "NgaySinh")
    private Date ngaySinh;
    @Column(name = "DiaChi")
    private String diaChi;
    @Column(name = "Sdt")
    private String sdt;
    @Column(name = "MatKhau")
    private String matKhau;
    @Column(name = "IdGuiBC", nullable = true)
    private String idGuiBc;
    @Column(name = "TrangThai")
    private Integer trangThai;
    @ManyToOne
    @JoinColumn(name = "idcv", referencedColumnName = "id")
    private ChucVuEntity chucVuByIdCv;
    @ManyToOne
    @JoinColumn(name = "idch", referencedColumnName = "id")
    private CuaHangEntity cuaHangByIdCh;
    @OneToMany(mappedBy = "nhanVienByIdNv")
    private List<HoaDonEntity> listHoaDon;
    @OneToMany(mappedBy = "nhanVienByIdNv")
    private List<GioHangEntity> listGioHang;

    public UUID getId() {
        return id;
    }
    public NhanVienEntity() {
    }

    public NhanVienEntity(UUID id, String ma, String ten, String tenDem, String ho, String gioiTinh, Date ngaySinh, String diaChi, String sdt, String matKhau, String idGuiBc, Integer trangThai, ChucVuEntity chucVuByIdCv, CuaHangEntity cuaHangByIdCh, List<HoaDonEntity> listHoaDon, List<GioHangEntity> listGioHang) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.tenDem = tenDem;
        this.ho = ho;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.sdt = sdt;
        this.matKhau = matKhau;
        this.idGuiBc = idGuiBc;
        this.trangThai = trangThai;
        this.chucVuByIdCv = chucVuByIdCv;
        this.cuaHangByIdCh = cuaHangByIdCh;
        this.listHoaDon = listHoaDon;
        this.listGioHang = listGioHang;
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

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getTenDem() {
        return tenDem;
    }

    public void setTenDem(String tenDem) {
        this.tenDem = tenDem;
    }

    public String getHo() {
        return ho;
    }

    public void setHo(String ho) {
        this.ho = ho;
    }

    public String getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(String gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
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

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getIdGuiBc() {
        return idGuiBc;
    }

    public void setIdGuiBc(String idGuiBc) {
        this.idGuiBc = idGuiBc;
    }

    public Integer getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(Integer trangThai) {
        this.trangThai = trangThai;
    }

    public ChucVuEntity getChucVuByIdCv() {
        return chucVuByIdCv;
    }

    public void setChucVuByIdCv(ChucVuEntity chucVuByIdCv) {
        this.chucVuByIdCv = chucVuByIdCv;
    }

    public CuaHangEntity getCuaHangByIdCh() {
        return cuaHangByIdCh;
    }

    public void setCuaHangByIdCh(CuaHangEntity cuaHangByIdCh) {
        this.cuaHangByIdCh = cuaHangByIdCh;
    }

    public List<HoaDonEntity> getListHoaDon() {
        return listHoaDon;
    }

    public void setListHoaDon(List<HoaDonEntity> listHoaDon) {
        this.listHoaDon = listHoaDon;
    }

    public List<GioHangEntity> getListGioHang() {
        return listGioHang;
    }

    public void setListGioHang(List<GioHangEntity> listGioHang) {
        this.listGioHang = listGioHang;
    }


}
