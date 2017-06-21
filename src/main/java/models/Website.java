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

    @OneToOne(mappedBy="website")
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
}
