package Repositories;

import domain_model.ChiTietSpEntity;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import untils.hibernateUtils;

import java.util.List;
import java.util.UUID;

public class ChiTietSanPhamRepo {
    private Session hSession;

    public ChiTietSanPhamRepo() {
        this.hSession = new hibernateUtils().getFACTORY().openSession();
    }

    public void insert(ChiTietSpEntity ctsp) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(ctsp);
            this.hSession.getTransaction().commit();


        } catch (
                Exception e
        ) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public void update(ChiTietSpEntity ctsp) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.merge(ctsp);
            this.hSession.getTransaction().commit();


        } catch (
                Exception e
        ) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public void delete(ChiTietSpEntity ctsp) {
        System.out.println(ctsp.getId());
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(ctsp);
            this.hSession.getTransaction().commit();


        } catch (
                Exception e
        ) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();
        }
    }

    public List<ChiTietSpEntity> findAll() {
        String hql = "SELECT ctsp FROM ChiTietSpEntity ctsp";
        TypedQuery<ChiTietSpEntity> query =
                this.hSession.createQuery(hql, ChiTietSpEntity.class);
        return query.getResultList();


    }

    public ChiTietSpEntity findById(String id) {
        String hql = "SELECT ctsp FROM ChiTietSpEntity ctsp where ctsp.id = ?1";
        TypedQuery<ChiTietSpEntity> query =
                this.hSession.createQuery(hql, ChiTietSpEntity.class);
        query.setParameter(1, UUID.fromString(id));
        try {
            return query.getSingleResult();

        } catch (Exception e) {
            return null;
        }


    }
}
