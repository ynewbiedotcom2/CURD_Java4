package domain_model;

import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "ChucVu", schema = "dbo", catalog = "FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041")
public class ChucVuEntity {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Override
    public String toString() {
        return "ChucVuEntity{" +
                "id=" + id +
                ", ma='" + ma + '\'' +
                ", ten='" + ten + '\'' +
                '}';
    }

    @OneToMany(
            mappedBy = "chucVuByIdCv"

    )

    private List<NhanVienEntity> listNV;

    public ChucVuEntity(UUID id, String ma, String ten, List<NhanVienEntity> listNV) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.listNV = listNV;
    }

    public ChucVuEntity() {
    }

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

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public List<NhanVienEntity> getListNV() {
        return listNV;
    }

    public void setListNV(List<NhanVienEntity> listNV) {
        this.listNV = listNV;
    }
}
