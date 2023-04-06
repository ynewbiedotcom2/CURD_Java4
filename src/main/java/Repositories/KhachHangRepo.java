package Repositories;

import domain_model.KhachHangEntity;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import untils.hibernateUtils;

import java.util.List;
import java.util.UUID;

public class KhachHangRepo {
    private Session hSession;

    public KhachHangRepo() {
        this.hSession = new hibernateUtils().getFACTORY().openSession();
    }

    public void insert(KhachHangEntity nv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(nv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();

        }
    }
    public void update(KhachHangEntity nv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.merge(nv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();

        }
    }
    public void delete(KhachHangEntity nv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(nv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();

        }
    }
    public KhachHangEntity login(String ma, String matKhau) {
        String hql = "SELECT nv FROM KhachHangEntity nv Where nv.ma = ?1 and nv.matKhau= ?2 ";
        TypedQuery<KhachHangEntity> query =  this.hSession.createQuery(hql);
        query.setParameter(1,ma);
        query.setParameter(2,matKhau);
        try {
            KhachHangEntity nv = query.getSingleResult();
            System.out.println(nv.getMa());
            return nv;
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }

    }
    public List<KhachHangEntity> findAll(){
        String hql = "SELECT nv FROM KhachHangEntity nv";
        TypedQuery<KhachHangEntity> query =  this.hSession.createQuery(hql);

        try {
            List<KhachHangEntity> nv = query.getResultList();
            System.out.println(nv.size());
            return nv;
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }public KhachHangEntity findByMa(String ma){
        String hql = "SELECT nv FROM KhachHangEntity nv where nv.ma = ?1";
        TypedQuery<KhachHangEntity> query =  this.hSession.createQuery(hql);
        query.setParameter(1,ma);
        try {
            KhachHangEntity nv = query.getSingleResult();
            System.out.println(nv.getTen());
            return nv;
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }
}
