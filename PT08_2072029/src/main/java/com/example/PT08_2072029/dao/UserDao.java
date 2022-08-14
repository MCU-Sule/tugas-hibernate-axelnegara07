package com.example.PT08_2072029.dao;

import com.example.PT08_2072029.model.User;
import com.example.PT08_2072029.util.HiberUtility;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class UserDao implements DaoInterface<User>{

    @Override
    public List<User> getData() {
        List<User> ulist;

        SessionFactory sessionFactory = HiberUtility.getSessionFactory();
        Session session = sessionFactory.openSession();

        CriteriaBuilder bob = session.getCriteriaBuilder();
        CriteriaQuery query = bob.createQuery(User.class);
        query.from(User.class);

        ulist = session.createQuery(query).getResultList();

        session.close();
        return ulist;
    }

    @Override
    public void addData(User data) {
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
    public void deleteData(User data) {
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
    public void updateData(User data) {
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
}
