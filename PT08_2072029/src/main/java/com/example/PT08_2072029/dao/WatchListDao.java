package com.example.PT08_2072029.dao;

import com.example.PT08_2072029.model.User;
import com.example.PT08_2072029.model.Watchlist;
import com.example.PT08_2072029.util.HiberUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class WatchListDao implements DaoInterface<Watchlist>{
    @Override
    public List<Watchlist> getData() {
        List<Watchlist> wlist;

        SessionFactory sessionFactory = HiberUtility.getSessionFactory();
        Session session = sessionFactory.openSession();

        CriteriaBuilder bob = session.getCriteriaBuilder();
        CriteriaQuery query = bob.createQuery(Watchlist.class);
        query.from(Watchlist.class);

        wlist = session.createQuery(query).getResultList();

        session.close();
        return wlist;
    }

    @Override
    public void addData(Watchlist data) {
        SessionFactory sessionFactory = HiberUtility.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(data);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        session.close();
    }

    @Override
    public void deleteData(Watchlist data) {
        SessionFactory sessionFactory = HiberUtility.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.delete(data);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        session.close();
    }

    @Override
    public void updateData(Watchlist data) {
        SessionFactory sessionFactory = HiberUtility.getSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.update(data);
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
        }
        session.close();
    }


    public List<Watchlist> getDataUser(User data) {
        List<Watchlist> wlist;

        SessionFactory sessionFactory = HiberUtility.getSessionFactory();
        Session session = sessionFactory.openSession();

        CriteriaBuilder bob = session.getCriteriaBuilder();
        CriteriaQuery query = bob.createQuery(Watchlist.class);
        Root<Watchlist> root = query.from(Watchlist.class);
        Predicate predicate = bob.equal(root.get("userByUserIdUser"), data);
        query.where(predicate);

        wlist = session.createQuery(query).getResultList();

        session.close();
        return wlist;
    }
}
