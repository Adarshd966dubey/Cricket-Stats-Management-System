package com.cricket.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.cricket.Entity.Bowler;
import com.cricket.utils.HibernateUtils;

import java.util.List;


public class BowlerDAO {
    public void save(Bowler bowler) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(bowler);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<Bowler> findAll(Class<Bowler> class1) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("from Bowler", Bowler.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Bowler findById(Class<Bowler> class1, int id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.get(Bowler.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(Bowler bowler) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(bowler);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void delete(Class<Bowler> class1, int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Bowler bowler = session.get(Bowler.class, id);
            if (bowler != null) {
                session.delete(bowler);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}


