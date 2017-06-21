package DAO;

import models.Template;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by reda-benchraa on 21/06/17.
 */
public class templateDAO {
    public static Session session;
    public templateDAO(){
        session = Utiz.getSessionFactory().openSession();
    }
    public void addtemplate(Template template){
        session.beginTransaction();
        session.save(template);
        session.getTransaction().commit();
    }
    public List<Template> getTemplates(){
        return (List<Template>) session.createCriteria(Template.class).list();
    }
    public Template getTemplate(int id){
        return session.get(Template.class, id);
    }
    public int deleteTemplate(int id){
        Template template = session.get(Template.class, id);
        if(template == null) return -1;
        session.beginTransaction();
        session.delete(template);
        session.getTransaction().commit();
        return 1;
    }
    public void updateTemplate(Template template){
        session.beginTransaction();
        session.update(template);
        session.getTransaction().commit();
    }
}
