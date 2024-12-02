package com.cricket.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import com.cricket.Entity.Player;
import com.cricket.utils.HibernateUtils;

import java.util.List;

public class PlayerDAO {
    public void save(Player player) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(player);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        }
    }

    public List<Player> findAll(Class<Player> class1) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.createQuery("from Player", Player.class).list();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Player findById(Class<Player> class1, int id) {
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            return session.get(Player.class, id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void update(Player player) {
        Transaction transaction = null;
        try (Session session = HibernateUtils.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.update(player);
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
            
            // Fetch the Player entity using the ID
            Player player = session.get(Player.class, id);
            if (player != null) {
                session.delete(player); // Delete the Player entity
                transaction.commit();   // Commit the transaction
                System.out.println("Player with ID " + id + " deleted successfully.");
            } else {
                System.out.println("Player with ID " + id + " not found.");
            }
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();  // Rollback in case of an exception
            }
            e.printStackTrace();
        }
    }
}
