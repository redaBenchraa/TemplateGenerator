package Beans;

import org.primefaces.model.UploadedFile;

import javax.faces.bean.ManagedBean;

/**
 * Created by Rabab Chahboune on 6/26/2017.
 */
@ManagedBean
public class UpdateLinkBean {
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

    }
}
