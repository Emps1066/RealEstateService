package user;

import java.util.List;

public class employee extends user {

    private String employeeId;


    public employee(String usename,String password, List<String> roles,String employeeId){
    super(usename,password,roles);
    this.employeeId = employeeId;

}
}
