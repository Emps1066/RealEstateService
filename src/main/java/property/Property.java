package property;
import enums.PropertyListType;
import user.Customer;
import user.Employee;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.*;

public abstract class Property
{
    private boolean listed = false;
    private String ID;
    private String address;
    private String suburb;
    private int bedrooms;
    private int bathrooms;
    private int carSpaces;
    private String type;
    private String ownerCustomer;
    private String employee = null;
    private double propertyBalance = 0;

    public Property(String ID, String address, String suburb, int bedrooms, int bathrooms, int carSpaces, String type, String ownerCustomer)
    {
        this.ID = ID;
        this.address = address;
        this.suburb = suburb;
        this.bedrooms = bedrooms;
        this.bathrooms = bathrooms;
        this.carSpaces = carSpaces;
        this.type = type;
        this.ownerCustomer = ownerCustomer;
    }

    public String getID()
    {
        return ID;
    }

    public void setID(String ID)
    {
        this.ID = ID;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    public String getSuburb()
    {
        return suburb;
    }

    public void setSuburb(String suburb)
    {
        this.suburb = suburb;
    }

    public int getBedrooms()
    {
        return bedrooms;
    }

    public void setBedrooms(int bedrooms)
    {
        this.bedrooms = bedrooms;
    }

    public int getBathrooms()
    {
        return bathrooms;
    }

    public void setBathrooms(int bathrooms)
    {
        this.bathrooms = bathrooms;
    }

    public int getCarSpaces()
    {
        return carSpaces;
    }

    public void setCarSpaces(int carSpaces)
    {
        this.carSpaces = carSpaces;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }

    public String getOwnerCustomer()
    {
        return ownerCustomer;
    }

    public void setOwnerCustomer(String ownerCustomer)
    {
        this.ownerCustomer = ownerCustomer;
    }

    public String getEmployee()
    {
        return employee;
    }

    public void setEmployee(String employee)
    {
        this.employee = employee;
    }

    public boolean isListed() {
        return listed;
    }

    public void setListed(boolean listed) {
        this.listed = listed;
    }

    public double getPropertyBalance() {
        return propertyBalance;
    }

    public void setPropertyBalance(double propertyBalance) {
        this.propertyBalance = propertyBalance;
    }

    public abstract PropertyListType listType();

    public String toCsvFormat() {
        return String.format("%s,%s,%s,%s,%d,%d,%d,%s,%s,%s,%f",
                listed == true ? "true" : "false", ID, address, suburb, bedrooms, bathrooms, carSpaces,
                type, ownerCustomer, employee, propertyBalance);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Property property = (Property) o;
        return bedrooms == property.bedrooms &&
                bathrooms == property.bathrooms &&
                carSpaces == property.carSpaces &&
                Double.compare(property.propertyBalance, propertyBalance) == 0 &&
                ID.equals(property.ID) &&
                address.equals(property.address) &&
                suburb.equals(property.suburb) &&
                type.equals(property.type) &&
                ownerCustomer.equals(property.ownerCustomer) &&
                Objects.equals(employee, property.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, address, suburb, bedrooms, bathrooms, carSpaces, type, ownerCustomer, employee, propertyBalance);
    }

    public String toListFormat() {
        return String.format("-----------------------------------------------------------------\n" +
                             "ID: %s\n" +
                             "Address: %s\n" +
                             "Suburb: %s\n" +
                             "Bedrooms: %d\n" +
                             "Bathrooms: %d\n" +
                             "Car Spaces: %d\n" +
                             "Property type: %s\n",
                             ID, address, suburb, bedrooms, bathrooms, carSpaces, type);
    }
}