package property;

import enums.PropertyListType;

public class RentalProperty extends Property {
    private String renterId = null;

    public RentalProperty(String ID, String address, String suburb, int bedrooms, int bathrooms, int carSpaces, String type, String customer) {
        super(ID, address, suburb, bedrooms, bathrooms, carSpaces, type, customer);
    }

    public String getRenterId() {
        return renterId;
    }

    public void setRenterId(String renterId) {
        this.renterId = renterId;
    }

    public PropertyListType listType() {
        return PropertyListType.RENTAL;
    }

    public String toCsvFormat() {
        return String.format("%s,%s,%s,%d,%d,%d,%s,%s,%s,%s", getID(), getAddress(), getSuburb(), getBedrooms(),
                getBathrooms(), getCarSpaces(), getType(), renterId, getOwnerCustomer(), getEmployee());
    }

    public String toListFormat() {
        return "";
    }
}
