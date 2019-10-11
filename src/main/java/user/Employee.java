package user;

import enums.UserType;

public class Employee extends User {
    private double commission = 0.0;
    private double paidSalary = 0.0;
    private double hoursWorked = 0.0;
    private boolean paid = false;

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

    public boolean isPaid() {
        return paid;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public UserType userType() {
        return UserType.EMPLOYEE;
    }

    public String toCsvFormat() {
        return String.format("%s,%s,%s,%s,%f,%f,%f,%s", getId(), getName(), getEmail(), getPassword(),
                commission, hoursWorked, paidSalary, paid ? "true" : "false");
    }

}
