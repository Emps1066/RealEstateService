package user;


public class Customer extends User {

    private String customerId;
    private String email;
    private String address;

    public Customer(String username, String password, String customerId, String email, String address){
        super(username,password);
        this.customerId = customerId;
        this.email = email;
        this.address = address;

    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}





