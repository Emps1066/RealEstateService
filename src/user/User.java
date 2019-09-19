package user;

import java.util.List;

public abstract class User {
    private String name ;
    private String password;
    private String email;
    private String Id = null;

    public User(String name, String email, String password){
        this.name = name;
        this.password = password;
        this.email = email;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public abstract String toCsvString();
}
