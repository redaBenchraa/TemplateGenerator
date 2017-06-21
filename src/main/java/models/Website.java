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
    @Column
    int id;
    @Column
    String name;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="INFORMATION_ID")
    private Information information;

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

    public Information getInformation() {
        return information;
    }

    public void setInformation(Information information) {
        this.information = information;
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

    public Website(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Website(int id, String name, User user) {
        this.id = id;
        this.name = name;
        this.user = user;
    }

    public Website(int id, String name, Information information, Collection<Project> projects, Collection<Service> services, Collection<Link> links, User user) {
        this.id = id;
        this.name = name;
        this.information = information;
        this.projects = projects;
        this.services = services;
        this.links = links;
        this.user = user;
    }

    public Website(String name, Information information, Collection<Project> projects, Collection<Service> services, Collection<Link> links, User user) {
        this.name = name;
        this.information = information;
        this.projects = projects;
        this.services = services;
        this.links = links;
        this.user = user;
    }
    public Website(){

    }
}
