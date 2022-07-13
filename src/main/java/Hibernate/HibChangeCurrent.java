package Hibernate;

import Parser.Parser;
import entity.HRs;
import entity.Leads;
import entity.Recruiters;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import service.Literals;

public class HibChangeCurrent implements Literals {

    HibGetCurrent hgc = new HibGetCurrent();
    Parser parser = new Parser();
    SessionFactory sessionFactory = new HibernateConnect().getFactory();

    public boolean caseChangeHR(String iD, String field, String newField) {

        HRs hR = hgc.getCurrentHR(iD);

        boolean checkAdd = false;
        Session session = null;
        switch (field) {
            case NAME_ENG -> hR.setFirstname(newField);
            case TG_USER_ENG -> hR.setTg_username( parser.tgUsernameRemove( newField));
            case SURENAME_ENG -> hR.setSurname(newField);
            case FATHERNAME_ENG -> hR.setFathername(newField);
        }
        try {
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.update(hR);
            session.getTransaction().commit();
            checkAdd = true;

        } finally {
            session.close();
        }
        return checkAdd;


    }


    public boolean caseChangeRec(String iD, String field, String newField) {

        Recruiters rec = hgc.getCurrentRec(iD);

        boolean checkAdd = false;
        Session session = null;
        switch (field) {
            case NAME_ENG -> rec.setFirstname(newField);
            case TG_USER_ENG -> rec.setTg_username( parser.tgUsernameRemove( newField));
            case SURENAME_ENG -> rec.setSurname(newField);
            case FATHERNAME_ENG -> rec.setFathername(newField);
        }
        try {

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.update(rec);
            session.getTransaction().commit();
            checkAdd = true;

        } finally {
            session.close();
        }
        return checkAdd;
    }


    public boolean caseChangeLead(String iD, String field, String newField) {

        Leads lead = hgc.getCurrentLead(iD);


        boolean checkAdd = false;
        Session session = null;
        switch (field) {
            case NAME_ENG -> lead.setFirstname(newField);
            case TG_USER_ENG -> lead.setTg_username( parser.tgUsernameRemove( newField));
            case SURENAME_ENG -> lead.setSurname(newField);
            case FATHERNAME_ENG -> lead.setFathername(newField);

        }
        try {

            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.update(lead);
            session.getTransaction().commit();
            checkAdd = true;

        } finally {
            session.close();
        }
        return checkAdd;

    }

}
