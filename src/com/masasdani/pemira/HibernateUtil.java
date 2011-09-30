package com.masasdani.pemira;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.masasdani.pemira.dao.MahasiswaDao;
import com.masasdani.pemira.dao.UserDao;
import com.masasdani.pemira.dao.impl.MahasiswadaoImpl;
import com.masasdani.pemira.dao.impl.UserDaoImpl;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;

/**
 * Hibernate Utility class with a convenient method to get Session Factory object.
 *
 * @author badak
 */
public class HibernateUtil {

    private static final SessionFactory sessionFactory;
    private static final MahasiswaDao mahasiswaDao;
    private static final UserDao userDao;
    
    static {
        try {
            // Create the SessionFactory from standard (hibernate.cfg.xml) 
            // config file.
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
            mahasiswaDao = new MahasiswadaoImpl(sessionFactory);
            userDao = new UserDaoImpl(sessionFactory);
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
    
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
    
    public static MahasiswaDao getMahasiswaDao(){
        return mahasiswaDao;
    }
    
    public static UserDao getUserDao(){
        return userDao;
    }
}
