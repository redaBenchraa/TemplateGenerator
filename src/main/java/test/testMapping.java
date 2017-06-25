package test;

import DAO.Utiz;
import DAO.userDAO;
import models.User;

/**
 * Created by reda-benchraa on 21/06/17.
 */
public class testMapping {
    public static void main(String[]args){
        try {
            System.out.println(new userDAO().checkUser(new User("reda","ben")));
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            Utiz.shutdown();
        }
    }
}
