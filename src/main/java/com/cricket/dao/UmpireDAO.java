package com.cricket.dao;



import org.hibernate.Session;
import org.hibernate.Transaction;
import com.cricket.Entity.Umpire;
import com.cricket.utils.HibernateUtils;

import java.util.List;

public class UmpireDAO {
    public void save(Umpire umpire) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(umpire);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<Umpire> findAll(Class<Umpire> class1) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("from Umpire", Umpire.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Umpire findById(Class<Umpire> class1, int id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.get(Umpire.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(Umpire umpire) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(umpire);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public void delete(Class<Umpire> class1, int id) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            Umpire umpire = session.get(Umpire.class, id);
            if (umpire != null) {
                session.delete(umpire);
                transaction.commit();
            }
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }
}
