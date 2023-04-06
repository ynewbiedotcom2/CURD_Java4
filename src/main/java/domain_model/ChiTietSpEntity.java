package domain_model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ChiTietSP")
public class ChiTietSpEntity {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "NamBH")
    private Integer namBh;
    @Column(name = "MoTa")
    private String moTa;
    @Column(name = "SoLuongTon")
    private Integer soLuongTon;
    @Column(name = "GiaNhap")
    private Integer giaNhap;
    @Column(name = "GiaBan")
    private Integer giaBan;

    @ManyToOne()
    @JoinColumn(
            name = "IdSP",
            referencedColumnName = "Id",
            nullable = true
    )
    private SanPhamEntity sanPhamByIdSp;

    @ManyToOne()
    @JoinColumn(
            name = "IdNsx",
            referencedColumnName = "Id",
            nullable = true
    )
    private NsxEntity nsxByIdNsx;

    @ManyToOne()
    @JoinColumn(
            name = "IdMauSac",
            referencedColumnName = "Id",
            nullable = true
    )
    private MauSacEntity mauSacByIdMauSac;

    @ManyToOne()
    @JoinColumn(
            name = "IdDongSP",
            referencedColumnName = "Id",
            nullable = true
    )
    private DongSpEntity dongSpByIdDongSp;
    @OneToMany(mappedBy = "chiTietSpByIdChiTietSp")
    private List<HoaDonChiTietEntity> listDHCT;
    @OneToMany(mappedBy = "chiTietSpByIdChiTietSp")
    private List<GioHangChiTietEntity> listGHCT;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getNamBh() {
        return namBh;
    }

    public void setNamBh(Integer namBh) {
        this.namBh = namBh;
    }

    public String getMoTa() {
        return moTa;
    }

    public void setMoTa(String moTa) {
        this.moTa = moTa;
    }

    public Integer getSoLuongTon() {
        return soLuongTon;
    }

    public void setSoLuongTon(Integer soLuongTon) {
        this.soLuongTon = soLuongTon;
    }

    public Integer getGiaNhap() {
        return giaNhap;
    }

    public void setGiaNhap(Integer giaNhap) {
        this.giaNhap = giaNhap;
    }

    public Integer getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(Integer giaBan) {
        this.giaBan = giaBan;
    }

    public SanPhamEntity getSanPhamByIdSp() {
        return sanPhamByIdSp;
    }

    public void setSanPhamByIdSp(SanPhamEntity sanPhamByIdSp) {
        this.sanPhamByIdSp = sanPhamByIdSp;
    }

    public NsxEntity getNsxByIdNsx() {
        return nsxByIdNsx;
    }

    public void setNsxByIdNsx(NsxEntity nsxByIdNsx) {
        this.nsxByIdNsx = nsxByIdNsx;
    }

    public MauSacEntity getMauSacByIdMauSac() {
        return mauSacByIdMauSac;
    }

    public void setMauSacByIdMauSac(MauSacEntity mauSacByIdMauSac) {
        this.mauSacByIdMauSac = mauSacByIdMauSac;
    }

    public DongSpEntity getDongSpByIdDongSp() {
        return dongSpByIdDongSp;
    }

    public void setDongSpByIdDongSp(DongSpEntity dongSpByIdDongSp) {
        this.dongSpByIdDongSp = dongSpByIdDongSp;
    }

    public List<HoaDonChiTietEntity> getListDHCT() {
        return listDHCT;
    }

    public void setListDHCT(List<HoaDonChiTietEntity> listDHCT) {
        this.listDHCT = listDHCT;
    }

    public List<GioHangChiTietEntity> getListGHCT() {
        return listGHCT;
    }

    public void setListGHCT(List<GioHangChiTietEntity> listGHCT) {
        this.listGHCT = listGHCT;
    }

    public ChiTietSpEntity() {
    }

    public ChiTietSpEntity(UUID id, Integer namBh, String moTa, Integer soLuongTon, Integer giaNhap, Integer giaBan, SanPhamEntity sanPhamByIdSp, NsxEntity nsxByIdNsx, MauSacEntity mauSacByIdMauSac, DongSpEntity dongSpByIdDongSp, List<HoaDonChiTietEntity> listDHCT, List<GioHangChiTietEntity> listGHCT) {
        this.id = id;
        this.namBh = namBh;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
        this.sanPhamByIdSp = sanPhamByIdSp;
        this.nsxByIdNsx = nsxByIdNsx;
        this.mauSacByIdMauSac = mauSacByIdMauSac;
        this.dongSpByIdDongSp = dongSpByIdDongSp;
        this.listDHCT = listDHCT;
        this.listGHCT = listGHCT;
    }
}
