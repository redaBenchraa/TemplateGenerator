package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 * Created by reda-benchraa on 21/06/17.
 */
@Entity
public class Information {
    @Id
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
    @OneToOne(mappedBy="Information")
    private Website website;
}
