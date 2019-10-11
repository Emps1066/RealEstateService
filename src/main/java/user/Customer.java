package user;


import enums.UserType;

public class Customer extends User {
    public Customer(String Id, String name, String email, String password) {
        super(Id, name, email, password);
    }

    public UserType userType() {
        return UserType.CUSTOMER;
    }

    public String toCsvFormat() {
        return String.format("%s,%s,%s,%s", getId(), getName(), getEmail(), getPassword());
    }
}


