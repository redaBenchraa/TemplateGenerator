package models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by reda-benchraa on 21/06/17.
 */
@Entity
public class User {
    @Id
    @Column
    int id;
    @Column
    String username;
    @Column
    String password;
    @OneToMany(cascade= CascadeType.ALL, mappedBy="website")
    private Collection<Website> websites= new ArrayList<Website>();
}
