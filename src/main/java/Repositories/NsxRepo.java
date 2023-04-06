package Repositories;

import domain_model.NsxEntity;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import untils.hibernateUtils;

import java.util.List;
import java.util.UUID;

public class NsxRepo {
    private Session hSession;

    public NsxRepo() {
        this.hSession = new hibernateUtils().getFACTORY().openSession();
    }

    public void insert(NsxEntity cv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();

        }
    }
    public void update(NsxEntity cv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.merge(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();

        }
    }
    public void delete(NsxEntity cv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();

        }
    }

    public List<NsxEntity> findAll(){
        String hql = "SELECT cv FROM NsxEntity cv";
        TypedQuery<NsxEntity> query =  this.hSession.createQuery(hql);

        try {
            List<NsxEntity> cv = query.getResultList();
            System.out.println(cv.size());
            return cv;
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }
    public NsxEntity findById(UUID id) {
        String hql = "SELECT nv FROM NsxEntity nv where id = ?1";
        TypedQuery<NsxEntity> query = this.hSession.createQuery(hql);
        query.setParameter(1, id);
        try {
            NsxEntity nv = query.getSingleResult();
            System.out.println(nv.getTen());
            return nv;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;

        }
    }
}
