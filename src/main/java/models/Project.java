package models;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by reda-benchraa on 21/06/17.
 */
@Entity
public class Project  implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    @Expose int id;
    @Column
    @Expose String name;
    @Column
    @Expose String image;
    @Column
    @Expose String about;
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

    public Project(int id, String name, String image, String about, Website website) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.about = about;
        this.website = website;
    }

    public Project(int id, String name, String image, String about) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.about = about;
    }

    public Project(String name, String image, String about, Website website) {
        this.name = name;
        this.image = image;
        this.about = about;
        this.website = website;
    }
    public Project(){

    }
}
