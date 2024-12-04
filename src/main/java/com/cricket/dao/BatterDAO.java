package com.cricket.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.cricket.Entity.Batter;
import com.cricket.utils.HibernateUtils;

import java.util.List;

public class BatterDAO {
    public void save(Batter batter) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(batter);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<Batter> findAll(Class<Batter> class1) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("from Batter", Batter.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Batter findById(Class<Batter> class1, int id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.get(Batter.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(Batter batter) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(batter);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            
            Batter batter = session.get(Batter.class, id);  
            if (batter != null) {
                session.delete(batter);  
                transaction.commit();    
            } else {
                System.out.println("Batter with ID " + id + " not found.");
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

	
}
