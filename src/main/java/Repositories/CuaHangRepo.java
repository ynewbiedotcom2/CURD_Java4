package Repositories;

import domain_model.CuaHangEntity;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import untils.hibernateUtils;

import java.util.List;
import java.util.UUID;

public class CuaHangRepo {


    private Session hSession;

    public CuaHangRepo() {
        this.hSession = new hibernateUtils().getFACTORY().openSession();
    }

    public void insert(CuaHangEntity nv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(nv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();

        }
    }

    public void update(CuaHangEntity nv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.merge(nv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();

        }
    }

    public void delete(CuaHangEntity nv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(nv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();

        }
    }



    public List<CuaHangEntity> findAll() {
        String hql = "SELECT nv FROM CuaHangEntity nv";
        TypedQuery<CuaHangEntity> query = this.hSession.createQuery(hql);

        try {
            List<CuaHangEntity> nv = query.getResultList();
            System.out.println(nv.size());
            return nv;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }

    public CuaHangEntity findById(UUID id) {
        String hql = "SELECT nv FROM CuaHangEntity nv where id = ?1";
        TypedQuery<CuaHangEntity> query = this.hSession.createQuery(hql);
        query.setParameter(1, id);
        try {
            CuaHangEntity nv = query.getSingleResult();
            System.out.println(nv.getTen());
            return nv;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;

        }
    }

}
