package user;

import java.util.List;

public class User {
    private String username ;
    private String password;


    public User(String username, String password){
        this.username = username;
        this.password = password ;
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

}
