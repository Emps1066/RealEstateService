package user;

import enums.UserType;

import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return name.equals(user.name) &&
                password.equals(user.password) &&
                email.equals(user.email) &&
                Id.equals(user.Id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, password, email, Id);
    }

    public abstract UserType userType();

    public abstract String toCsvString();
}
