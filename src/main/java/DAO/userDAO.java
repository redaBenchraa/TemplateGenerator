package DAO;

import models.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
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
    public int deleteUser(int id){
        User user = session.get(User.class, id);
        if(user == null) return -1;
        session.beginTransaction();
        session.delete(user);
        session.getTransaction().commit();
        return 1;
    }
    public void updateUser(User user){
        session.beginTransaction();
        session.update(user);
        session.getTransaction().commit();
    }
    public boolean checkUser(User user){
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("username", user.getUsername()));
        criteria.add(Restrictions.eq("password", user.getPassword()));
        if(criteria.list().size()>0) return true;
        return false;
    }
}
