package DAO;

import models.Information;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by reda-benchraa on 21/06/17.
 */
public class InformationDAO {
    public static Session session;
    public InformationDAO(){
        session = Utiz.getSessionFactory().openSession();
    }
    public void addinformation(Information information){
        session.beginTransaction();
        session.save(information);
        session.getTransaction().commit();
    }
    public List<Information> getInformations(){
        return (List<Information>) session.createCriteria(Information.class).list();
    }
    public Information getInformation(int id){
        return session.get(Information.class, id);
    }
    public int deleteInformation(int id){
        Information information = session.get(Information.class, id);
        if(information == null) return -1;
        session.beginTransaction();
        session.delete(information);
        session.getTransaction().commit();
        return 1;
    }
    public void updateInformation(Information information){
        session.beginTransaction();
        session.update(information);
        session.getTransaction().commit();
    }
}
