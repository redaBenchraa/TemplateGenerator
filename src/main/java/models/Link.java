package models;

import javax.persistence.*;

/**
 * Created by reda-benchraa on 21/06/17.
 */
@Entity
public class Link {
    @Id
    @Column
    int id;
    @Column
    String name;
    @Column
    String image;
    @Column
    String link;
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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Website getWebsite() {
        return website;
    }

    public void setWebsite(Website website) {
        this.website = website;
    }

    public Link(int id, String name, String image, String link, Website website) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.link = link;
        this.website = website;
    }

    public Link(int id, String name, String image, String link) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.link = link;
    }

    public Link(String name, String image, String link, Website website) {
        this.name = name;
        this.image = image;
        this.link = link;
        this.website = website;
    }
}
