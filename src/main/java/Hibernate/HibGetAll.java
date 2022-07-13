package Hibernate;

import entity.Candidates;
import entity.HRs;
import entity.Leads;
import entity.Recruiters;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HibGetAll {

    SessionFactory sessionFactory= new HibernateConnect().getFactory();


    public Map <String,String> getCandidates() {

        Session session = null;

        Map<String,String> candidates=new HashMap<>();

        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            List<Candidates> candidates2= session.createQuery("from Candidates").getResultList();

            for ( Candidates candidates1: candidates2) {
                if(candidates1.getStatus()!=10) {
                    candidates.put(candidates1.getFirstname()+" "+candidates1.getSurname(),candidates1.getTg_username());
                }
            }

            session.getTransaction().commit();

        } finally {
            session.close();

        }
        return candidates;
    }


    public Map <String,String> getHRs() {


        Session session = null;

        Map <String,String>hrs=new HashMap<>();

        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            List<HRs> hrS= session.createQuery("from HRs").getResultList();

            for (  HRs hr1: hrS) {
                if (hr1.getStatus()!=10)  {
                    hrs.put(hr1.getFirstname()+" "+hr1.getSurname(),hr1.getTg_username());
                }
            }
            session.getTransaction().commit();

        } finally {
            session.close();

        }
        return hrs;
    }



    public Map <String,String> getRecruiters() {


        Session session = null;
        Map <String,String> recruiters=new HashMap<>();

        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            List<Recruiters> recs= session.createQuery("from Recruiters").getResultList();

            for ( Recruiters recruiters1: recs) {
                if(recruiters1.getStatus()!=10) {
                    recruiters.put(recruiters1.getFirstname()+" "+recruiters1.getSurname(),recruiters1.getTg_username());
                }
            }

            session.getTransaction().commit();

        } finally {
            session.close();

        }
        return recruiters;
    }


    public Map <String,String> getLeads() {


        Session session = null;
        Map <String,String> leads=new HashMap<>();

        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            List<Leads> recs= session.createQuery("from Leads").getResultList();

            for ( Leads leads1: recs) {
                if(leads1.getStatus()!=10) {
                    leads.put(leads1.getFirstname()+" "+leads1.getSurname(),leads1.getTg_username());
                }
            }

            session.getTransaction().commit();

        } finally {
            session.close();

        }
        return leads;
    }

}
