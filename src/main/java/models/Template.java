package models;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by reda-benchraa on 21/06/17.
 */
@Entity
public class Template implements Serializable {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    @Expose int id;
    @Column
    @Expose String name;
    @Column
    @Expose String link;

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
    // Helpers ------------------------------------------------------------------------------------

    // This must return true for another Foo object with same key/id.
    public boolean equals(Object other) {
        return other instanceof Template && (name != null) ? name.equals(((Template) other).name) : (other == this);
    }

    // This must return the same hashcode for every Foo object with the same key.
    public int hashCode() {
        return name != null ? this.getClass().hashCode() + name.hashCode() : super.hashCode();
    }

    // Override Object#toString() so that it returns a human readable String representation.
    // It is not required by the Converter or so, it just pleases the reading in the logs.
    public String toString() {
        return "Foo[" + name + "," + link + "]";
    }
}
