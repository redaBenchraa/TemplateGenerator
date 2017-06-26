package Beans;

import DAO.userDAO;
import DAO.websiteDAO;
import models.User;
import models.Website;
import org.primefaces.model.UploadedFile;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Rabab Chahboune on 6/25/2017.
 */
@ManagedBean
public class UpdateWebsiteBean {
    private String name;
    private String welcome;
    private String about;
    private UploadedFile background;
    private UploadedFile  logo;
    private static String path = "uploads";
    websiteDAO webDAO;
    private Website website;
    @PostConstruct
    public void initIt() throws Exception {
        String value = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
        webDAO = new websiteDAO();
        website = webDAO.getWebsite(Integer.parseInt("2"));
        //System.out.println(website);
        setName(website.getName());
        setWelcome(website.getWelcome());
        setAbout(website.getAbout());
    }

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
        website.setName(getName());
        website.setAbout(getAbout());
        website.setName(getName());
        if(background.getSize() != 0 ){
            File bg = new File(website.getBackground());
            if(bg.delete()){
                website.setBackground(uploadImage(getBackground()));
            }
        }
        if(logo.getSize() != 0){
            File lg = new File(website.getLogo());
            if(lg.delete()){
                website.setLogo(uploadImage(getLogo()));
            }
        }
        webDAO.updateWebsite(website);
        String url = "website.xhtml?id="+website.getId() ;
        FacesContext fc = FacesContext.getCurrentInstance();
        ExternalContext ec = fc.getExternalContext();
        try {
            ec.redirect(url);
        } catch (IOException ex) {
            Logger.getLogger(WebsitesBean.class.getName()).log(Level.SEVERE, null, ex);
        }

    }


    private String uploadImage(UploadedFile file){
        Random rand = new Random();
        String fileName = String.valueOf(rand.nextInt(10000))+file.getFileName();
        try{
            InputStream Input = file.getInputstream();
            Files.copy(Input, Paths.get(path,fileName), StandardCopyOption.REPLACE_EXISTING);
        }catch (IOException e){
            System.out.println(e);
        }
        return path+"/"+fileName;
    }
}
