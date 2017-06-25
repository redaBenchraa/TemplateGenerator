package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by reda-benchraa on 21/06/17.
 */
@Entity
public class Website {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    int id;
    @Column
    String name;
    @Column
    String about;
    @Column
    String welcome;
    @Column
    String background;
    @Column
    String logo;

    public Website(String name, String about, String welcome, String background, String logo, User user) {
        this.name = name;
        this.about = about;
        this.welcome = welcome;
        this.background = background;
        this.logo = logo;
        this.user = user;
    }
    public Website(){

    }

    @OneToMany(cascade= CascadeType.ALL, mappedBy="website")
    private Collection<Project> projects= new ArrayList<Project>();
    @OneToMany(cascade= CascadeType.ALL, mappedBy="website")
    private Collection<Service> services= new ArrayList<Service>();
    @OneToMany(cascade= CascadeType.ALL, mappedBy="website")
    private Collection<Link> links= new ArrayList<Link>();

    @ManyToOne(optional = false)
    @JoinColumn(name = "USER_ID")
    private User user;



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

    public Collection<Project> getProjects() {
        return projects;
    }

    public void setProjects(Collection<Project> projects) {
        this.projects = projects;
    }

    public Collection<Service> getServices() {
        return services;
    }

    public void setServices(Collection<Service> services) {
        this.services = services;
    }

    public Collection<Link> getLinks() {
        return links;
    }

    public void setLinks(Collection<Link> links) {
        this.links = links;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}
