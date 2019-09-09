package user;

import java.util.List;

public class seller extends customer {

    public seller(String usename, String password, List<String> roles, String customerId){
        super(usename,password,roles,customerId);

    }
}
