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
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}





