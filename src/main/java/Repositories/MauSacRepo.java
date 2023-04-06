package Repositories;

import domain_model.MauSacEntity;
import domain_model.MauSacEntity;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import untils.hibernateUtils;

import java.util.List;
import java.util.UUID;

public class MauSacRepo {
    private Session hSession;

    public MauSacRepo() {
        this.hSession = new hibernateUtils().getFACTORY().openSession();
    }

    public void insert(MauSacEntity cv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();

        }
    }
    public void update(MauSacEntity cv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.merge(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();

        }
    }
    public void delete(MauSacEntity cv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();

        }
    }

    public List<MauSacEntity> findAll(){
        String hql = "SELECT cv FROM MauSacEntity cv";
        TypedQuery<MauSacEntity> query =  this.hSession.createQuery(hql);

        try {
            List<MauSacEntity> cv = query.getResultList();
            System.out.println(cv.size());
            return cv;
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }
    public MauSacEntity findById(UUID id) {
        String hql = "SELECT nv FROM MauSacEntity nv where id = ?1";
        TypedQuery<MauSacEntity> query = this.hSession.createQuery(hql);
        query.setParameter(1, id);
        try {
            MauSacEntity nv = query.getSingleResult();
            System.out.println(nv.getTen());
            return nv;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;

        }
    }
    public MauSacEntity findByMa(String id) {
        String hql = "SELECT nv FROM MauSacEntity nv where nv.ma = ?1";
        TypedQuery<MauSacEntity> query = this.hSession.createQuery(hql);
        query.setParameter(1, id);
        try {
            MauSacEntity nv = query.getSingleResult();
            System.out.println(nv.getTen());
            return nv;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;

        }
    }
}
