package Beans;

import DAO.Utiz;
import DAO.userDAO;
import DAO.websiteDAO;
import com.sun.faces.facelets.util.Path;
import models.User;
import models.Website;
import org.primefaces.model.UploadedFile;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * Created by Rabab Chahboune on 6/24/2017.
 */
@ManagedBean
public class AddWebsiteBean {
    private String name;
    private String welcome;
    private String about;
    private UploadedFile background;
    private UploadedFile  logo;
    private static String path = "uploads";

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

    public UploadedFile  getBackground() {
        return background;
    }

    public void setBackground(UploadedFile  background) {
        this.background = background;
    }

    public UploadedFile  getLogo() {
        return logo;
    }

    public void setLogo(UploadedFile  logo) {
        this.logo = logo;
    }

    public void saveData(){
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        if(servletContext.getAttribute("idUser")!=null){
            String userId = servletContext.getAttribute("idUser").toString();
            User user  = new userDAO().getUser(Integer.parseInt(userId));
            Website website = new Website();
            Utiz.checkUploadFolder();
            if(background !=null && logo!=null){
                website.setName(getName());
                website.setWelcome(getWelcome());
                website.setAbout(getAbout());
                website.setBackground(Utiz.uploadImage(getBackground()));
                website.setLogo(Utiz.uploadImage(getLogo()));
                website.setUser(user);
                websiteDAO webDAO = new websiteDAO();
                webDAO.addwebsite(website);
                String url = "websites.xhtml" ;
                FacesContext fc = FacesContext.getCurrentInstance();
                ExternalContext ec = fc.getExternalContext();
                try {
                    ec.redirect(url);
                } catch (IOException ex) {
                    Logger.getLogger(WebsitesBean.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }else{
            System.out.println("no user logged in");}
        }
}
