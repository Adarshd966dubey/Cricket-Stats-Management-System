package com.cricket.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.cricket.utils.HibernateUtils;

import java.util.List;

public class GenericDAO<T> {

    public void save(T entity) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(entity);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void update(T entity) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(entity);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    public void delete(T entity) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(entity);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @SuppressWarnings("unchecked")
    public List<T> findAll(Class<T> clazz) {
        Session session = HibernateUtils.getSessionFactory().openSession();
        List<T> entities = null;
        try {
            entities = session.createQuery("from " + clazz.getName()).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return entities;
    }
}
