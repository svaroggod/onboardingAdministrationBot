package Hibernate;

import entity.*;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


import java.util.ArrayList;
import java.util.List;

public class HibGetCurrent {


    SessionFactory sessionFactory= new HibernateConnect().getFactory();



    public HRs getCurrentHR(String tgUsername) {


        Session session = null;

        List<HRs> hr = new ArrayList<>();

        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            hr= session.createQuery("from HRs where tg_username = :paramName")
                    .setParameter("paramName", tgUsername)
                    .getResultList();

            session.getTransaction().commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();

        }

        return hr.get(0);

    }

    public Recruiters getCurrentRec(String tgUsername) {




        Session session = null;


        List<Recruiters>  recruiters= new ArrayList<>();

        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            recruiters = session.createQuery("from Recruiters where  tg_username = :paramName")
                    .setParameter("paramName", tgUsername)
                    .getResultList();

            session.getTransaction().commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();

        }

        return (recruiters.get(0));
    }



    public Leads getCurrentLead(String tgUsername) {


        Session session = null;

        List<Leads>  leads= new ArrayList<>();

        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            leads = session.createQuery("from Leads where  tg_username = :paramName")
                    .setParameter("paramName", tgUsername)
                    .getResultList();

            session.getTransaction().commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();

        }

        return (leads.get(0));
    }


    public Candidates getCurrentCanndidat(String tgID) {


        Session session = null;

        List<Candidates>  candidates= new ArrayList<>();

        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            candidates = session.createQuery("from Candidates where tg_username = :paramName")
                    .setParameter("paramName", tgID)
                    .getResultList();

            session.getTransaction().commit();

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();

        }

        return (candidates.get(0));
    }

    public Form getCurrentForm(String tgId) {
        Session session = null;
        Candidates candidate;
        List<Form> forms = null;
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            candidate = (Candidates) session.createQuery("from Candidates c where c.tg_username = :catId")
                    .setParameter("catId", tgId)
                    .getSingleResult();
            forms = (List<Form>) session.createQuery("from Form where candidate_id = :paramName")
                    .setParameter("paramName", candidate.getId())
                    .getResultList();
            session.getTransaction().commit();
        }catch (HibernateException e){
        } finally {
            session.close();
        }
        return forms.get(0);
    }
}
