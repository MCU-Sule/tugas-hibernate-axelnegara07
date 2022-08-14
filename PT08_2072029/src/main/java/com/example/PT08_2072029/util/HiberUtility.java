package com.example.PT08_2072029.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HiberUtility {

    public static SessionFactory getSessionFactory() {
        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory;
    }
}