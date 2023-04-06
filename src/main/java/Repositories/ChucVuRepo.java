package Repositories;

import domain_model.ChucVuEntity;
import domain_model.ChucVuEntity;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import untils.hibernateUtils;

import java.util.List;
import java.util.UUID;

public class ChucVuRepo {
    private Session hSession;

    public ChucVuRepo() {
        this.hSession = new hibernateUtils().getFACTORY().openSession();
    }

    public void insert(ChucVuEntity cv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();

        }
    }
    public void update(ChucVuEntity cv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.merge(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();

        }
    }
    public void delete(ChucVuEntity cv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();

        }
    }

    public List<ChucVuEntity> findAll(){
        String hql = "SELECT cv FROM ChucVuEntity cv";
        TypedQuery<ChucVuEntity> query =  this.hSession.createQuery(hql);

        try {
            List<ChucVuEntity> cv = query.getResultList();
            System.out.println(cv.size());
            return cv;
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }
    public ChucVuEntity findById(UUID id) {
        String hql = "SELECT nv FROM ChucVuEntity nv where id = ?1";
        TypedQuery<ChucVuEntity> query = this.hSession.createQuery(hql);
        query.setParameter(1, id);
        try {
            ChucVuEntity nv = query.getSingleResult();
            System.out.println(nv.getTen());
            return nv;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;

        }
    }
}
