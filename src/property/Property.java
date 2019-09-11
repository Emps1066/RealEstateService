package property;

import user.Customer;
import user.Employee;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

public abstract class Property {
    private boolean listed = false;
    private String address;
    private int bedrooms;
    private int bathrooms;
    private Map<String, Customer> ownerCustomers = new HashMap<>();
    private Map<String, Employee> employees = new HashMap<>();

    public Property(String address, int bedrooms, int bathrooms) {
        this.address = address;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
    }

    public boolean isListed() {
        return listed;
    }

    public void list() {
        this.listed = true;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBedrooms() {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms) {
        this.bedrooms = bedrooms;
    }

    public int getBathrooms() {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms) {
        this.bathrooms = bathrooms;
    }

    public boolean addEmployee(Employee employee) {
        boolean added;
        if(employees.containsKey(employee.getEmployeeId()))
        {
            employees.put(employee.getEmployeeId(), employee);
            added = true;
        }
        else
        {
            added = false;
        }
        return added;

    }

    public boolean addOwner(Customer owner) {
        boolean added;

        if(ownerCustomers.containsKey(owner.getCustomerId())) {

            ownerCustomers.put(owner.getCustomerId(), owner);
            added = true;
        } else {

            added = false;
        }

        return added;
    }

    public Collection<Employee> getEmployees() {
        return Collections.unmodifiableCollection(employees.values());
    }
    public Collection<Customer> getOwners() {
        return Collections.unmodifiableCollection(ownerCustomers.values());
    }

}
