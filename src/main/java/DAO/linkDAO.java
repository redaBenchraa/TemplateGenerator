package DAO;

import models.Link;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by reda-benchraa on 21/06/17.
 */
public class linkDAO {
    public static Session session;
    public linkDAO(){
        session = Utiz.getSessionFactory().openSession();
    }
    public void addlink(Link link){
        session.beginTransaction();
        session.save(link);
        session.getTransaction().commit();
    }
    public List<Link> getLinks(){
        return (List<Link>) session.createCriteria(Link.class).list();
    }
    public Link getLink(int id){
        return session.get(Link.class, id);
    }
    public int deleteLink(int id){
        Link link = session.get(Link.class, id);
        if(link == null) return -1;
        session.beginTransaction();
        session.delete(link);
        session.getTransaction().commit();
        return 1;
    }
    public void updateLink(Link link){
        session.beginTransaction();
        session.update(link);
        session.getTransaction().commit();
    }
}
