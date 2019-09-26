package user;


import java.util.ArrayList;
import java.util.List;

public class Customer extends User {
    List<String> suburbs = new ArrayList<>();
    public Customer(String Id, String name, String email, String password) {
        super(Id, name, email, password);
    }

    public boolean addSuburbPreference(String suburb) {
        boolean added = false;
        if(suburb != null && suburb.length() != 0) {
            suburb = suburb.substring(0, 1).toUpperCase() + suburb.substring(1);
            suburbs.add(suburb);
            added = true;
        }
        return added;
    }

    public String toCsvString() {
        return String.format("%s,%s,%s,%s", getId(), getName(), getEmail(), getPassword());
    }
}


