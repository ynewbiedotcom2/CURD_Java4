package Repositories;

import domain_model.NhanVienEntity;
import jakarta.persistence.NoResultException;
import jakarta.persistence.TypedQuery;
import org.hibernate.Session;
import untils.hibernateUtils;

import java.util.List;
import java.util.UUID;

public class NhanVienRepo {
    private Session hSession;

    public NhanVienRepo() {
        this.hSession = new hibernateUtils().getFACTORY().openSession();
    }

    public void insert(NhanVienEntity nv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.persist(nv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();

        }
    }
    public void update(NhanVienEntity nv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.merge(nv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();

        }
    }
    public void delete(NhanVienEntity nv) {
        try {
            this.hSession.getTransaction().begin();
            this.hSession.delete(nv);
            this.hSession.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            this.hSession.getTransaction().rollback();

        }
    }
    public NhanVienEntity login(String ma, String matKhau) {
        String hql = "SELECT nv FROM NhanVienEntity nv Where nv.ma = ?1 and nv.matKhau= ?2 ";
        TypedQuery<NhanVienEntity> query =  this.hSession.createQuery(hql);
        query.setParameter(1,ma);
        query.setParameter(2,matKhau);
        try {
           NhanVienEntity nv = query.getSingleResult();
            System.out.println(nv.getMa());
           return nv;
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }

    }
    public List<NhanVienEntity> findAll(){
        String hql = "SELECT nv FROM NhanVienEntity nv";
        TypedQuery<NhanVienEntity> query =  this.hSession.createQuery(hql);

        try {
            List<NhanVienEntity> nv = query.getResultList();
            System.out.println(nv.size());
            return nv;
        }catch (NoResultException e){
            e.printStackTrace();
            return null;
        }
    }public NhanVienEntity findById(UUID id){
        String hql = "SELECT nv FROM NhanVienEntity nv where id = ?1";
        TypedQuery<NhanVienEntity> query = this.hSession.createQuery(hql);
        query.setParameter(1, id);
        try {
            NhanVienEntity nv = query.getSingleResult();
            System.out.println(nv.getTen());
            return nv;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }

    public NhanVienEntity findByMa(String ma) {
        String hql = "SELECT nv FROM NhanVienEntity nv where nv.ma = ?1";
        TypedQuery<NhanVienEntity> query = this.hSession.createQuery(hql);
        query.setParameter(1, ma);
        try {
            NhanVienEntity nv = query.getSingleResult();
            System.out.println(nv.getTen());
            return nv;
        } catch (NoResultException e) {
            e.printStackTrace();
            return null;
        }
    }
}
