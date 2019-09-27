package user;

import enums.UserType;

import java.util.List;

public class Employee extends User {
    private double commission = 0.0;
    private double paidSalary = 0.0;
    private double hoursWorked = 0.0;
    private boolean payed = false;

    public Employee(String Id, String name, String email, String password){
    super(Id, name, email, password);
}

    public double getCommission() {
        return commission;
    }

    public void setCommission(double commission) {
        this.commission = commission;
    }

    public double getPaidSalary() {
        return paidSalary;
    }

    public void setPaidSalary(double paidSalary) {
        this.paidSalary = paidSalary;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public boolean isPayed() {
        return payed;
    }

    public void setPayed(boolean payed) {
        this.payed = payed;
    }

    public UserType userType() {
        return UserType.EMPLOYEE;
    }

    public String toCsvString() {
        return String.format("%s,%s,%s,%s,%f,%f,%f,%s", getId(), getName(), getEmail(), getPassword(),
                commission, hoursWorked, paidSalary, payed ? "True" : "False");
    }

}
