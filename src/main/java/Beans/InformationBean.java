package Beans;

import com.sun.faces.facelets.util.Path;
import models.Information;
import org.primefaces.model.UploadedFile;

import javax.faces.bean.ManagedBean;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

/**
 * Created by Rabab Chahboune on 6/24/2017.
 */
@ManagedBean
public class InformationBean {
    private String name;
    private String welcome;
    private String about;
    private UploadedFile background;
    private UploadedFile  logo;

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
        Information info = new Information();
        File uploads = new File("uploads");
        if(!uploads.exists()) {
            boolean successful = new File("uploads").mkdir();
        }
        if(background !=null && logo!=null){
            try{
                InputStream bgInput = background.getInputstream();
                Files.copy(bgInput, Paths.get("uploads",background.getFileName()), StandardCopyOption.REPLACE_EXISTING);
                InputStream logoInput = logo.getInputstream();
                Files.copy(logoInput, Paths.get("uploads",logo.getFileName()), StandardCopyOption.REPLACE_EXISTING);
                info.setName(getName());
                info.setWelcome(getWelcome());
                info.setAbout(getAbout());
                info.setBackground();
            }catch (IOException e){
                System.out.println(e);
            }
        }
    }

    private String uploadImage(UploadedFile file){

        
    }

}
