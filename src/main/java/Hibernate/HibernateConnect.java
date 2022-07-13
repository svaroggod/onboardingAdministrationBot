package Hibernate;

import entity.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.SessionFactory;
import service.Config;

public class HibernateConnect implements Config {


    public SessionFactory getFactory() {

        return new Configuration()
                .setProperty("hibernate.connection.url", Config.JDBC_URL)
                .setProperty("hibernate.connection.username", Config.JDBC_USERNAME)
                .setProperty("hibernate.connection.password", Config.JDBC_PASSWORD)
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Candidates.class)
                .addAnnotatedClass(HRs.class)
                .addAnnotatedClass(Leads.class)
                .addAnnotatedClass(Recruiters.class)
                .addAnnotatedClass(Form.class)
                .addAnnotatedClass(Documents.class)
                .buildSessionFactory();

    }


}