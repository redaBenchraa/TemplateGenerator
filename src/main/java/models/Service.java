package models;

import javax.persistence.*;

/**
 * Created by reda-benchraa on 21/06/17.
 */
@Entity
public class Service {
    @Id
    @Column
    int id;
    @Column
    String name;
    @Column
    String image;
    @Column
    String about;
    @ManyToOne(optional = false)
    @JoinColumn(name = "WEBSITE_ID")
    private Website website;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public Website getWebsite() {
        return website;
    }

    public void setWebsite(Website website) {
        this.website = website;
    }

    public Service(int id, String name, String image, String about, Website website) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.about = about;
        this.website = website;
    }

    public Service(int id, String name, String image, String about) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.about = about;
    }

    public Service(String name, String image, String about, Website website) {
        this.name = name;
        this.image = image;
        this.about = about;
        this.website = website;
    }
    public Service(){

    }
}
