package DAO;

import models.Website;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by reda-benchraa on 21/06/17.
 */
public class websiteDAO {
    public static Session session;
    public websiteDAO(){
        session = Utiz.getSessionFactory().openSession();
    }
    public void addwebsite(Website website){
        session.beginTransaction();
        session.save(website);
        session.getTransaction().commit();
    }
    public List<Website> getWebsites(){
        return (List<Website>) session.createCriteria(Website.class).list();
    }
    public Website getWebsite(int id){
        return (Website) session.get(Website.class, id);
    }
    public int deleteWebsite(int id){
        Website website = (Website) session.get(Website.class, id);
        if(website == null) return -1;
        session.beginTransaction();
        session.delete(website);
        session.getTransaction().commit();
        return 1;
    }
    public void updateWebsite(Website website){
        session.beginTransaction();
        session.update(website);
        session.getTransaction().commit();
    }
}
