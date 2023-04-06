package view_model;

import java.util.UUID;

public class spctIndex {
    private String id;
    private String mauSac;
    private String dongSp;
    private String nsx;
    private String sp;
    private Integer namBh;
    private String moTa;
    private Integer soLuongTon;

    private Integer giaNhap;

    private Integer giaBan;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMauSac() {
        return mauSac;
    }

    public void setMauSac(String mauSac) {
        this.mauSac = mauSac;
    }

    public String getDongSp() {
        return dongSp;
    }

    public void setDongSp(String dongSp) {
        this.dongSp = dongSp;
    }

    public String getNsx() {
        return nsx;
    }

    public void setNsx(String nsx) {
        this.nsx = nsx;
    }

    public String getSp() {
        return sp;
    }

    public void setSp(String sp) {
        this.sp = sp;
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

    public spctIndex() {
    }

    public spctIndex(String id, String mauSac, String dongSp, String nsx, String sp, Integer namBh, String moTa, Integer soLuongTon, Integer giaNhap, Integer giaBan) {
        this.id = id;
        this.mauSac = mauSac;
        this.dongSp = dongSp;
        this.nsx = nsx;
        this.sp = sp;
        this.namBh = namBh;
        this.moTa = moTa;
        this.soLuongTon = soLuongTon;
        this.giaNhap = giaNhap;
        this.giaBan = giaBan;
    }
}
