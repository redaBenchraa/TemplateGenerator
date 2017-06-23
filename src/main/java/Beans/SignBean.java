package Beans;

import DAO.userDAO;
import models.User;
import org.primefaces.context.RequestContext;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import java.io.Serializable;

/**
 * Created by Rabab Chahboune on 6/22/2017.
 */
@ManagedBean
public class SignBean implements Serializable {
    private String username;
    private String password;
    private String repassword;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public void login(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;

        User user = new User(username,password);
        System.out.println(username + " " + password);
        userDAO userDA= new userDAO();

        if(userDA.checkUser(user)) {
            System.out.println("zzz");

            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
        } else {
            System.out.println("cc");
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");

        }

        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
    }
    public void signup(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();



    }
}
