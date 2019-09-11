package user;

import java.util.List;

public class User {
    private String username ;
    private String password;


    public User(String usename, String password){
        this.username = usename;
        this.password = password ;

    }

    // Test 3
    public String getUsename() {
        return username;
    }

    public void setUsename(String usename) {
        this.username = usename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
