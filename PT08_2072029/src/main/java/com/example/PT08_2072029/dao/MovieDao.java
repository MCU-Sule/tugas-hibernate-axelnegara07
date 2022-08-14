package com.example.PT08_2072029.dao;

import com.example.PT08_2072029.model.Movie;
import com.example.PT08_2072029.util.HiberUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

public class MovieDao implements DaoInterface<Movie>{
    @Override
    public List<Movie> getData() {
        List<Movie> mlist;

        SessionFactory sessionFactory = HiberUtility.getSessionFactory();
        Session session = sessionFactory.openSession();

        CriteriaBuilder bob = session.getCriteriaBuilder();
        CriteriaQuery query = bob.createQuery(Movie.class);
        query.from(Movie.class);

        mlist = session.createQuery(query).getResultList();

        session.close();
        return mlist;
    }

    @Override
    public void addData(Movie data) {
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
    public void deleteData(Movie data) {
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
    public void updateData(Movie data) {
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


    public List<Movie> filterData(String data) {
        List<Movie> mlist;

        SessionFactory sessionFactory = HiberUtility.getSessionFactory();
        Session session = sessionFactory.openSession();

        CriteriaBuilder bob = session.getCriteriaBuilder();
        CriteriaQuery query = bob.createQuery(Movie.class);
        Root<Movie> root = query.from(Movie.class);
        Predicate predicate = bob.like(root.get("genre"), "%" + data + "%");
        query.where(predicate);

        mlist = session.createQuery(query).getResultList();

        session.close();
        return mlist;
    }
}
