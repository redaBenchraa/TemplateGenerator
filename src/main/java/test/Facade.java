package test;

import models.User;
import models.Website;
import org.hibernate.Session;

import java.util.Collection;
import java.util.List;

/**
 * Created by reda-benchraa on 21/06/17.
 */
public class Facade {
    public static Session session;

    public Facade() {
        session = Utiz.getSessionFactory().openSession();
    }

    public void addUser(User user) {
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }

    public void addWebsite(Website website) {
        session.beginTransaction();
        session.save(website);
        session.getTransaction().commit();
    }

    public Collection<Website> getWebsites() {
        return (List<Website>) session.createCriteria(Website.class).list();
    }
}
