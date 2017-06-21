package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by reda-benchraa on 21/06/17.
 */
public class Website {
    @Id
    @Column
    int id;
    @Column
    String name;
    @ManyToOne(optional = false)
    @JoinColumn(name = "TEMPLATE_ID")
    private Template template;
    @OneToOne(mappedBy="information")
    private Information information;

    @OneToMany(cascade= CascadeType.ALL, mappedBy="project")
    private Collection<Project> projects= new ArrayList<Project>();
    @OneToMany(cascade= CascadeType.ALL, mappedBy="service")
    private Collection<Service> services= new ArrayList<Service>();
    @OneToMany(cascade= CascadeType.ALL, mappedBy="link")
    private Collection<Link> links= new ArrayList<Link>();
}
