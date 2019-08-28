package user;

import java.util.List;

public class TechAdmin extends employee {

    public TechAdmin(String usename, String password, List<String> roles, String employeeId){
        super(usename,password,roles,employeeId);
    }

}
