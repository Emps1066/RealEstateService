package property;
import user.Customer;
import user.Employee;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.*;

public abstract class Property {
    private boolean listed = false;
    private String ID;
    private String address;
    private String suburb;
    private int bedrooms;
    private int bathrooms;
    private int carSpaces;
    private String type;
    private Map<String, Customer> ownerCustomers = new HashMap<>();
    private Map<String, Employee> employees = new HashMap<>();

    public Property(String ID, String address, String suburb, int bedrooms, int bathrooms, int carSpaces, String type) {
            this.ID = ID;
            this.address = address;
            this.suburb = suburb;
            this.bedrooms = bedrooms;
            this.bathrooms = bathrooms;
            this.carSpaces = carSpaces;
            this.type = type;
        }

        public boolean isListed() {
            return listed;
        }

        public String getID() {
            return ID;
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

        public String getSuburb() {
            return suburb;
        }

        public void setSuburb(String suburb) {
            this.suburb = suburb;
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

        public int getCarSpaces() {
            return carSpaces;
        }

        public void setCarSpaces(int carSpaces) {
            this.carSpaces = carSpaces;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public boolean addEmployee(Employee employee) {
            boolean added;


            if(employees.containsKey(employee.getId())) {
                employees.put(employee.getId(), employee);
                added = true;
            } else {
                added = false;
            }
            return added;
        }
        public boolean addOwner(Customer owner) {
            boolean added;
          

            if(ownerCustomers.containsKey(owner.getId())) {
                ownerCustomers.put(owner.getId(), owner);
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Property property = (Property) o;
            return listed == property.listed &&
                    bedrooms == property.bedrooms &&
                    bathrooms == property.bathrooms &&
                    address.equals(property.address) &&
                    Objects.equals(ownerCustomers, property.ownerCustomers) &&
                    Objects.equals(employees, property.employees);
        }

        @Override
        public int hashCode() {
            return Objects.hash(listed, address, bedrooms, bathrooms, ownerCustomers, employees);
        }

        public String toCsvFormat() {
            return String.format("%s, %s, %s, %d, %d, %d, %s", ID, address, suburb, bedrooms, bathrooms, carSpaces, type);
        }


    public void setListed(boolean listed) {
        this.listed = listed;
    }
}