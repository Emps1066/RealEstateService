package user;


public class Customer extends User {

    public Customer(String Id, String name, String email, String password) {
        super(Id, name, email, password);
    }

    public String toCsvString() {
        return String.format("%s,%s,%s,%s", getId(), getName(), getEmail(), getPassword());
    }


}


