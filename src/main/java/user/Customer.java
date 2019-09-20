package user;


public class Customer extends User {

    private String customerId;
    private String address;

    public Customer(String username, String name, String password, String email, String address) {
        super(username, password, email, name);
        this.address = address;

    }

    public String getCustomerId() {
        return customerId;
    }

    public String toCsvString() {
        return String.format("%s, %s, %s, %s, %s", getId(), getName(), getEmail(), getUsername(), getPassword());
    }


}


