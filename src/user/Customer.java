package user;


public class Customer extends User {

    public Customer(String name, String password, String email){
        super(name, email, password);

    }

    public String toCsvString() {
        return String.format("%s, %s, %s, %s", getId(), getName(), getEmail(), getPassword());
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}





