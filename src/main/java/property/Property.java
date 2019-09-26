package property;
import user.Customer;
import user.Employee;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;
import java.util.*;

public abstract class Property
{
    private String ID;
    private String address;
    private String suburb;
    private int bedrooms;
    private int bathrooms;
    private int carSpaces;
    private String type;
    private String ownerCustomer;
    private String employee = null;

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

    public abstract String toCsvFormat();

    public abstract String toListFormat();
}