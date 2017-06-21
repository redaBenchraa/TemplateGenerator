package models;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * Created by reda-benchraa on 21/06/17.
 */
public class Service {
    @Id
    @Column
    int id;
    @Column
    String name;
    @Column
    String image;
    @Column
    String about;
}
