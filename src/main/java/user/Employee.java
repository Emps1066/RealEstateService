package user;

import java.util.List;

public class Employee extends User {
    private double commission = 0.0;
    private double paidSalary = 0.0;
    private double hoursWorked = 0.0;
    private boolean payed = false;
    private String employeeID = null;



    public Employee(String username, String name, String password, String email){
    super(name, email, password, username);
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

    public String toCsvString() {
        return String.format("%s, %s, %s, %s, %s, %f, %f, %f, %s", getId(), getName(), getEmail(), getUsername(), getPassword(),
                commission, hoursWorked, paidSalary, payed ? "True" : "False");
    }

}
