package Hibernate;

import entity.HRs;
import entity.Leads;
import entity.Recruiters;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class HibWrite {

    SessionFactory sessionFactory = new HibernateConnect().getFactory();

    public void addHRs(HRs hr) {

        Session session = null;

        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.save(hr);
            session.getTransaction().commit();

        } finally {
            session.close();
        }
    }


    public void addRec(Recruiters rec) {

        Session session = null;

        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.save(rec);
            session.getTransaction().commit();

        } finally {
            session.close();
        }
    }


    public void addLead(Leads lead) {

        Session session = null;

        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.save(lead);
            session.getTransaction().commit();

        } finally {
            session.close();

        }
    }
}
