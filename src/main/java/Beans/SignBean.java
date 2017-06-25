package Beans;

import DAO.userDAO;
import models.User;
import org.primefaces.context.RequestContext;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletContext;
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
        System.out.println(userDA.checkUser(user));
        int userId = userDA.checkUser(user);
        if(userId != -1) {
            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            servletContext.setAttribute("idUser",userId);
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", username);
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
    }
    public void signup(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        if(!password.equals(repassword)){
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Password unmachted", "");
        }else{
            User user = new User(username,password);
            userDAO userDA= new userDAO();
            int userId=userDA.findUser(user);
            if(userId != -1) {
                message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Sign up Error", "User exists");
            } else {
                userDA.adduser(user);
                message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome new user", username);
                ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
                servletContext.setAttribute("idUser",userDA.findUser(user));

            }
        }

        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", true);
    }
}
