package DAO;

import models.Project;
import org.hibernate.Session;

import java.util.List;

/**
 * Created by reda-benchraa on 21/06/17.
 */
public class projectDAO {
    public static Session session;
    public projectDAO(){
        session = Utiz.getSessionFactory().openSession();
    }
    public void addproject(Project project){
        session.beginTransaction();
        session.save(project);
        session.getTransaction().commit();
    }
    public List<Project> getProjects(){
        return (List<Project>) session.createCriteria(Project.class).list();
    }
    public Project getProject(int id){
        return session.get(Project.class, id);
    }
    public int deleteProject(int id){
        Project project = session.get(Project.class, id);
        if(project == null) return -1;
        session.beginTransaction();
        session.delete(project);
        session.getTransaction().commit();
        return 1;
    }
    public void updateProject(Project project){
        session.beginTransaction();
        session.update(project);
        session.getTransaction().commit();
    }
}
