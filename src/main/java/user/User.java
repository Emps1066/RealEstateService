package user;

import java.util.List;

public abstract class User {
    private String name ;
    private String password;
    private String email;
    private String Id;


    public User(String Id, String name, String email, String password){
        this.Id = Id;
        this.name = name;
        this.email = email;
        this.password = password;
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
