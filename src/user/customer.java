package user;

import java.util.List;

public class customer extends user {

    private String customerId;

    public customer(String usename, String password, List<String> roles, String customerId){
        super(usename,password,roles);
        this.customerId = customerId;

    }
}





