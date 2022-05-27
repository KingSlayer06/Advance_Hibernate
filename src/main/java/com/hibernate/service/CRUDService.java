package com.hibernate.service;

import com.hibernate.model.Student;
import com.hibernate.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.io.Serializable;

public class CRUDService {
    private final SessionFactory sessionFactory;
    private static Session session;
    private static Transaction transaction;
    private static Object result;

    public CRUDService() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    public Student insertStudentRecord(Student student) {
        try {
            // save the student instance to database
            session = this.sessionFactory.getCurrentSession();

            // begin the transaction
            transaction = session.beginTransaction();

            // save the student instance to the database
            result = session.save(student);

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Error: Unable to Insert Data " + e.getMessage());
        } finally {
            // close session
            session.close();
            this.sessionFactory.close();
        }
        return student;
    }
}
