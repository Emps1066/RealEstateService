package user;


public class Customer extends User {

    private String customerId;

    public Customer(String username, String password, String customerId){
        super(username,password);
        this.customerId = customerId;

    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }
}





