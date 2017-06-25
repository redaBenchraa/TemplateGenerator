package Beans;

import DAO.userDAO;
import DAO.websiteDAO;
import com.sun.faces.facelets.util.Path;
import models.User;
import models.Website;
import org.primefaces.model.UploadedFile;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Random;


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
            String userId = (String) servletContext.getAttribute("idUser");
            User user  = new userDAO().getUser(Integer.parseInt(userId));
            Website website = new Website();
            File uploads = new File(path);
            if(!uploads.exists()) {
                boolean successful = new File(path).mkdir();
            }
            if(background !=null && logo!=null){
                website.setName(getName());
                website.setWelcome(getWelcome());
                website.setAbout(getAbout());
                website.setBackground(uploadImage(getBackground()));
                website.setLogo(uploadImage(getLogo()));
                website.setUser(user);
                websiteDAO webDAO = new websiteDAO();
                webDAO.addwebsite(website);
            }
        }else{
            System.out.println("no user logged in");}
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
