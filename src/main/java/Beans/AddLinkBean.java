package Beans;

/**
 * Created by Rabab Chahboune on 6/25/2017.
 */

import DAO.Utiz;
import DAO.linkDAO;
import DAO.websiteDAO;
import models.Link;
import org.primefaces.model.UploadedFile;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

@ManagedBean
@ViewScoped
public class AddLinkBean {
    String value ;
    @PostConstruct
    void init(){
        value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
    }
    private String name;
    private String link;
    private UploadedFile image;




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public UploadedFile getImage() {
        return image;
    }

    public void setImage(UploadedFile image) {
        this.image = image;
    }

    public void saveData(){
        Link l = new Link();
        l.setWebsite(new websiteDAO().getWebsite(Integer.parseInt(value)));
        l.setName(getName());
        l.setLink(getLink());
        Utiz.checkUploadFolder();
        if(image.getSize()!=0){
            l.setImage(Utiz.uploadImage(image));
            linkDAO lDAO = new linkDAO();
            lDAO.addlink(l);
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
