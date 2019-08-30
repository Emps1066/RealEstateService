package user;

import java.util.List;

public class user {
    private String usename ;
    private String password;
    private List<String> roles;


    public user(String usename, String password, List<String>roles){
        this.usename = usename;
        this.password = password ;
        this.roles =roles ;

    }

    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String>getRoles() {
        return roles;
    }

    public void setRoles( List<String>roles ) {
        this.roles = roles;

    }

}
