package Repositories;

import domain_model.SanPhamEntity;
import domain_model.SanPhamEntity;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import untils.hibernateUtils;

import java.util.List;
import java.util.UUID;

public class SanPhamRepo {
    private Session hSession;

    public SanPhamRepo() {
        this.hSession = new hibernateUtils().getFACTORY().openSession();
    }

    public void insert(SanPhamEntity cv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();

        }
    }
    public void update(SanPhamEntity cv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.merge(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();

        }
    }
    public SanPhamEntity findByMa(String id) {
        String hql = "SELECT nv FROM SanPhamEntity nv where nv.ma = ?1";
        TypedQuery<SanPhamEntity> query = this.hSession.createQuery(hql);
        query.setParameter(1, id);
        try {
            SanPhamEntity nv = query.getSingleResult();
            System.out.println(nv.getTen());
            return nv;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;

        }
    }
    public void delete(SanPhamEntity cv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();

        }
    }

    public List<SanPhamEntity> findAll(){
        String hql = "SELECT cv FROM SanPhamEntity cv";
        TypedQuery<SanPhamEntity> query =  this.hSession.createQuery(hql);

        try {
            List<SanPhamEntity> cv = query.getResultList();
            System.out.println(cv.size());
            return cv;
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }
    public SanPhamEntity findById(UUID id) {
        String hql = "SELECT nv FROM SanPhamEntity nv where id = ?1";
        TypedQuery<SanPhamEntity> query = this.hSession.createQuery(hql);
        query.setParameter(1, id);
        try {
            SanPhamEntity nv = query.getSingleResult();
            System.out.println(nv.getTen());
            return nv;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;

        }
    }
}
