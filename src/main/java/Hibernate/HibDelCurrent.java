package Hibernate;


import entity.HRs;
import entity.Leads;
import entity.Recruiters;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;




public class HibDelCurrent {

    SessionFactory sessionFactory= new HibernateConnect().getFactory();

    HibGetCurrent hgc = new HibGetCurrent();

    public void  delHR (String tgUsername) {

        HRs hR = hgc.getCurrentHR(tgUsername);
        Session session = null;
        hR.setStatus(10);

        try {

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.update(hR);
            session.getTransaction().commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {

            session.close();
        }

    }



    public void  delRec (String tgUsername) {

        Recruiters rec = hgc.getCurrentRec(tgUsername);
        Session session = null;
        rec.setStatus(10);

        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.update(rec);
            session.getTransaction().commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

    }



    public void  delLead (String tgUsername) {

        Leads lead = hgc.getCurrentLead(tgUsername);
        Session session = null;
         lead.setStatus(10);

        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.update(lead);
            session.getTransaction().commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

}