package Beans;

import DAO.userDAO;
import DAO.websiteDAO;
import models.Website;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
/*
 * Created by reda-benchraa on 25/06/17.
 */

@ManagedBean
public class AddWebsiteBean {
    private String name;
    private String welcome;
    private String about;
    private String background;
    private String logo;

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getWelcome() {
        return welcome;
    }

    public void setWelcome(String welcome) {
        this.welcome = welcome;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void save(){
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        servletContext.getAttribute("idUser");
        new websiteDAO().addwebsite(
                new Website(name,about,welcome,background,logo,
                        new userDAO().getUser(
                                Integer.parseInt(
                                        String.valueOf(
                                                servletContext.getAttribute("idUser")
                                        )
                                )
                        )
                )
        );
    }
}
