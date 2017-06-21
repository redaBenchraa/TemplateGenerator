package models;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Created by reda-benchraa on 21/06/17.
 */
public class Project {
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
}
