package user;

import java.util.List;

public class User {
    private String username ;
    private String password;
    private String email;


    public User(String username, String password, String email){
        this.username = username;
        this.password = password ;
        this.email = email;
    }

    // Test 3
    public String getUsername() {
        return username;
    }

    public void setUsername(String usename) {
        this.username = usename;
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
}
