package user;

import roles.Roles;
import java.util.Collection;
import java.util.ArrayList;

public abstract class User {
    private String userName;
    private String password;
    private String name;
    private String Id;
    private Collection<Roles> roles = new ArrayList<>();

    public User(String userName, String password, String name, String Id) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.Id = Id;
    }

    public String getId() {
        return Id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Collection<Roles> getRoles() {
        return roles;
    }
}
