package domain_model;

import jakarta.persistence.*;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "DongSP", schema = "dbo", catalog = "FINALASS_FPOLYSHOP_FA22_SOF205__SOF2041")
public class DongSpEntity {
    @Id
    @Column(name = "Id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @OneToMany(
            mappedBy = "dongSpByIdDongSp"

    )
    private List<ChiTietSpEntity> listCTSP;

    public DongSpEntity() {
    }

    public DongSpEntity(UUID id, String ma, String ten, List<ChiTietSpEntity> listCTSP) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.listCTSP = listCTSP;
    }

    @Override
    public String toString() {
        return "DongSpEntity{" +
                "id=" + id +
                ", ma='" + ma + '\'' +
                ", ten='" + ten + '\'' +
                '}';
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

    public List<ChiTietSpEntity> getListCTSP() {
        return listCTSP;
    }

    public void setListCTSP(List<ChiTietSpEntity> listCTSP) {
        this.listCTSP = listCTSP;
    }
}
