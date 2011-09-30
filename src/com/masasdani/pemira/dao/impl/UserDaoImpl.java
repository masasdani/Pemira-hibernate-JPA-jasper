/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.masasdani.pemira.dao.impl;

import com.masasdani.pemira.dao.UserDao;
import com.masasdani.pemira.entity.User;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author badak
 */
public class UserDaoImpl implements UserDao{
    private SessionFactory factory;

    public UserDaoImpl(SessionFactory factory) {
        this.factory = factory;
    }
    
    @Override
    public void save(User u) {
        Session session=factory.openSession();
        try{
            session.beginTransaction();
            session.save(u);
            session.getTransaction().commit();
        }catch(HibernateException exception){
            session.getTransaction().rollback();
            throw exception;
        }finally{
            session.close();
        }
    }

    @Override
    public void update(User u) {
        Session session=factory.openSession();
        try{
            session.beginTransaction();
            session.update(u);
            session.getTransaction().commit();
        }catch(HibernateException exception){
            session.getTransaction().rollback();
            throw exception;
        }finally{
            session.close();
        }
    }

    @Override
    public boolean isValid(User u) {
        boolean b=false;
        Session session=factory.openSession();
        List<User> list=session.createQuery("from User u where u.username=:user and u.password=:pass")
                .setParameter("user", u.getUsername())
                .setParameter("pass", u.getPassword()).list();
        if(list.size()==1){
            b=true;
        }
        session.close();
        return b;
    }

    @Override
    public List<User> getAll() {
        Session session=factory.openSession();
        List<User> list = session.createQuery("from User").list();
        session.close();
        return list;
    }
    
}
