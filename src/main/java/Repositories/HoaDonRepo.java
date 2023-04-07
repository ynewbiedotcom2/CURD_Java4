package Repositories;

import domain_model.HoaDonEntity;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import untils.hibernateUtils;

import java.util.List;
import java.util.UUID;

public class HoaDonRepo {
    private Session hSession;

    public HoaDonRepo() {
        this.hSession = new hibernateUtils().getFACTORY().openSession();
    }

    public void insert(HoaDonEntity cv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();

        }
    }
    public void update(HoaDonEntity cv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.merge(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();

        }
    }
    public void delete(HoaDonEntity cv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(cv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();

        }
    }

    public List<HoaDonEntity> findAll(){
        String hql = "SELECT cv FROM HoaDonEntity cv";
        TypedQuery<HoaDonEntity> query =  this.hSession.createQuery(hql);

        try {
            List<HoaDonEntity> cv = query.getResultList();
            System.out.println(cv.size());
            return cv;
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }
    public HoaDonEntity findById(UUID id) {
        String hql = "SELECT nv FROM HoaDonEntity nv where id = ?1";
        TypedQuery<HoaDonEntity> query = this.hSession.createQuery(hql);
        query.setParameter(1, id);
        try {
            HoaDonEntity nv = query.getSingleResult();

            return nv;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;

        }
    }
    public HoaDonEntity findByMa(String id) {
        String hql = "SELECT nv FROM HoaDonEntity nv where nv.ma = ?1";
        TypedQuery<HoaDonEntity> query = this.hSession.createQuery(hql);
        query.setParameter(1, id);
        try {
            HoaDonEntity nv = query.getSingleResult();

            return nv;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;

        }
    }
}
