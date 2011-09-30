/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masasdani.pemira.dao.impl;

import com.masasdani.pemira.dao.MahasiswaDao;
import com.masasdani.pemira.entity.Mahasiswa;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author badak
 */
public class MahasiswadaoImpl implements MahasiswaDao {

    SessionFactory factory;
    public MahasiswadaoImpl(SessionFactory factory) {
        this.factory=factory;
    }

    
    @Override
    public void save(Mahasiswa m) {
        Session session=factory.openSession();
        try{
            session.beginTransaction();
            session.save(m);
            session.getTransaction().commit();
        }catch(HibernateException exception){
            session.getTransaction().rollback();
            throw exception;
        }finally{
            session.close();
        }
    }

    @Override
    public List<Mahasiswa> getAll() {
        Session session=factory.openSession();
        List<Mahasiswa> list = session.createQuery("from Mahasiswa").list();
        session.close();
        return list;
    }

    @Override
    public List<Mahasiswa> getByJurusan(String j) {
        Session session=factory.openSession();
        List<Mahasiswa> list=session.createQuery("from Mahasiswa m where m.jurusan=:j").setParameter("j", j).list();
        session.close();
        return list;
    }

    @Override
    public List<Mahasiswa> getbyAngkatan(int a) {
        Session session=factory.openSession();
        List<Mahasiswa> list=session.createQuery("from Mahasiswa m where m.angkatan=:a").setParameter("a", a).list();
        session.close();
        return list;
    }

    @Override
    public Mahasiswa getMahasiswa(String nim) {
        Mahasiswa m=new Mahasiswa();
        Session session=factory.openSession();
        List<Mahasiswa> list=session.createQuery("from Mahasiswa m where m.nim=:nim").setParameter("nim", nim).list();
        if(list.size()==1){
            m=list.get(0);
        }else{
            m=null;
        }
        session.close();
        return m;
    }

    @Override
    public List<Mahasiswa> getByNim(String nim) {
        Session session=factory.openSession();
        List<Mahasiswa> list=session.createQuery("from Mahasiswa m where m.nim=:nim").setParameter("nim", nim).list();
        session.close();
        return list;
    }

    @Override
    public void delete(Mahasiswa m) {
        Session session=factory.openSession();
        try{
            session.beginTransaction();
            session.delete(m);
            session.getTransaction().commit();
        }catch(HibernateException exception){
            session.getTransaction().rollback();
            throw exception;
        }finally{
            session.close();
        }
    }
    
}
