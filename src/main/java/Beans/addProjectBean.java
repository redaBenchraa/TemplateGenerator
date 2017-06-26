package Beans;

/**
 * Created by Rabab Chahboune on 6/25/2017.
 */

import DAO.Utiz;
import DAO.projectDAO;
import DAO.websiteDAO;
import models.Project;
import org.primefaces.model.UploadedFile;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

@ManagedBean
@ViewScoped
public class addProjectBean {
    String value ;
    @PostConstruct
    void init(){
        value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
    }
    private String name;
    private String about;
    private UploadedFile image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String project) {
        this.about = project;
    }

    public UploadedFile getImage() {
        return image;
    }

    public void setImage(UploadedFile image) {
        this.image = image;
    }

    public void saveData(){
        Project l = new Project();
        l.setWebsite(new websiteDAO().getWebsite(Integer.parseInt(value)));
        l.setName(getName());
        l.setAbout(getAbout());
        Utiz.checkUploadFolder();
        if(image.getSize()!=0){
            l.setImage(Utiz.uploadImage(image));
            projectDAO lDAO = new projectDAO();
            lDAO.addproject(l);
            String url = "website.xhtml?id="+value ;
            FacesContext fc = FacesContext.getCurrentInstance();
            ExternalContext ec = fc.getExternalContext();
            try {
                ec.redirect(url);
            } catch (IOException ex) {
                Logger.getLogger(WebsitesBean.class.getName()).log(Level.SEVERE, null, ex);
            }

        }else {
            FacesContext context = FacesContext.getCurrentInstance();
            context.addMessage(null, new FacesMessage("Missing data",  "You must add image") );
        }

    }
}
