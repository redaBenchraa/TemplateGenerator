package DAO;

import models.User;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by reda-benchraa on 21/06/17.
 */
public class userDAO {
    public static Session session;
    public userDAO(){
        session = Utiz.getSessionFactory().openSession();
    }
    public void adduser(User user){
        session.beginTransaction();
        session.save(user);
        session.getTransaction().commit();
    }
    public List<User> getUsers(){
        return (List<User>) session.createCriteria(User.class).list();
    }
    public User getUser(int id){
        return session.get(User.class, id);
    }
}
