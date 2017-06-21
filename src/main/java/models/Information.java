package models;

import javax.persistence.*;

/**
 * Created by reda-benchraa on 21/06/17.
 */
@Entity
public class Information {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    int id;
    @Column
    String about;
    @Column
    String welcome;
    @Column
    String background;
    @Column
    String logo;
    @Column
    String name;

    @OneToOne(mappedBy="information")
    private Website website;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getBackground() {
        return background;
    }

    public void setBackground(String background) {
        this.background = background;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Website getWebsite() {
        return website;
    }

    public void setWebsite(Website website) {
        this.website = website;
    }

    public Information(int id, String about, String welcome, String background, String logo, String name, Website website) {
        this.id = id;
        this.about = about;
        this.welcome = welcome;
        this.background = background;
        this.logo = logo;
        this.name = name;
        this.website = website;
    }

    public Information(int id, String about, String welcome, String background, String logo, String name) {
        this.id = id;
        this.about = about;
        this.welcome = welcome;
        this.background = background;
        this.logo = logo;
        this.name = name;
    }

    public Information(String about, String welcome, String background, String logo, String name, Website website) {
        this.about = about;
        this.welcome = welcome;
        this.background = background;
        this.logo = logo;
        this.name = name;
        this.website = website;
    }
    public Information(){

    }
}
