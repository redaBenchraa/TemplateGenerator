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
    @OneToMany(cascade= CascadeType.ALL, mappedBy="user")
    private Collection<Website> websites= new ArrayList<Website>();

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
    public User(){

    }
}
