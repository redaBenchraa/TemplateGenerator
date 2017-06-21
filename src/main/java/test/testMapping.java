package test;

import models.User;

/**
 * Created by reda-benchraa on 21/06/17.
 */
public class testMapping {
    public static void main(String[]args){
        Facade facade = new Facade();
        try {
            facade.addUser(new User("reda","ben",null));
        }catch (Exception e){

        }finally {
            Utiz.shutdown();
        }
    }
}
