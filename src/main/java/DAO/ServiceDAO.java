package DAO;

import models.Service;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by reda-benchraa on 21/06/17.
 */
public class ServiceDAO {
    public static Session session;
    public ServiceDAO(){
        session = Utiz.getSessionFactory().openSession();
    }
    public void addService(Service Service){
        session.beginTransaction();
        session.save(Service);
        session.getTransaction().commit();
    }
    public List<Service> getServices(){
        return (List<Service>) session.createCriteria(Service.class).list();
    }
    public Service getService(int id){
        return (Service) session.get(Service.class, id);
    }
    public int deleteService(int id){
        Service Service = (models.Service) session.get(Service.class, id);
        if(Service == null) return -1;
        session.beginTransaction();
        session.delete(Service);
        session.getTransaction().commit();
        return 1;
    }
    public void updateService(Service Service){
        session.beginTransaction();
        session.update(Service);
        session.getTransaction().commit();
    }
}
