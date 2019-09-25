package user;


import java.util.List;

public class Customer extends User {
    List<String> suburbs;
    public Customer(String Id, String name, String email, String password) {
        super(Id, name, email, password);
    }

    public String toCsvString() {
        return String.format("%s,%s,%s,%s", getId(), getName(), getEmail(), getPassword());
    }


}


