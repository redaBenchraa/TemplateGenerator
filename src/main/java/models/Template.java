package models;

import javax.persistence.*;

/**
 * Created by reda-benchraa on 21/06/17.
 */
@Entity
public class Template {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    int id;
    @Column
    String name;
    @Column
    String link;

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public Template(int id, String name, String link) {
        this.id = id;
        this.name = name;
        this.link = link;
    }

    public Template(String name, String link) {
        this.name = name;
        this.link = link;
    }
    public Template(){

    }
}
