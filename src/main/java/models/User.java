package models;

import com.google.gson.annotations.Expose;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by reda-benchraa on 21/06/17.
 */
@Entity
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column
    @Expose int id;
    @Column
    @Expose String username;
    @Column
    @Expose String password;
    @OneToMany(cascade= CascadeType.ALL, mappedBy="user")
    @Expose private Collection<Website> websites= new ArrayList<Website>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Collection<Website> getWebsites() {
        return websites;
    }

    public void setWebsites(Collection<Website> websites) {
        this.websites = websites;
    }

    public User(int id, String username, String password, Collection<Website> websites) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.websites = websites;
    }

    public User(String username, String password, Collection<Website> websites) {
        this.username = username;
        this.password = password;
        this.websites = websites;
    }

    public User(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    public User(){

    }
}
