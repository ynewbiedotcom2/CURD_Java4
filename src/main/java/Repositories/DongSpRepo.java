package Repositories;

import domain_model.DongSpEntity;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import untils.hibernateUtils;

import java.util.List;
import java.util.UUID;

public class DongSpRepo {
    private Session hSession;

    public DongSpRepo() {
        this.hSession = new hibernateUtils().getFACTORY().openSession();
    }

    public void insert(DongSpEntity cv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();

        }
    }
    public void update(DongSpEntity cv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.merge(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();

        }
    }
    public void delete(DongSpEntity cv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();

        }
    }

    public List<DongSpEntity> findAll(){
        String hql = "SELECT cv FROM DongSpEntity cv";
        TypedQuery<DongSpEntity> query =  this.hSession.createQuery(hql);

        try {
            List<DongSpEntity> cv = query.getResultList();
            System.out.println(cv.size());
            return cv;
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }
    public DongSpEntity findById(UUID id) {
        String hql = "SELECT nv FROM DongSpEntity nv where id = ?1";
        TypedQuery<DongSpEntity> query = this.hSession.createQuery(hql);
        query.setParameter(1, id);
        try {
            DongSpEntity nv = query.getSingleResult();
            System.out.println(nv.getTen());
            return nv;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;

        }
    }
}
