package user;


public class Customer extends User {

    private String customerId;
    private String address;

    public Customer(String username, String password, String email, String customerId, String address){
        super(username, password, email);
        this.customerId = customerId;
        this.address = address;

    }

    public String getCustomerId() {
        return customerId;
      
    public Customer(String name, String password, String email){
        super(name, email, password);

    }

    public String toCsvString() {
        return String.format("%s, %s, %s, %s", getId(), getName(), getEmail(), getPassword());
    }
}





