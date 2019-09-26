package property;

public class ForSaleProperty extends Property {
    private String buyerId = null;

    public ForSaleProperty(String ID, String address, String suburb, int bedrooms, int bathrooms, int carSpaces, String type, String customer) {
        super(ID, address, suburb, bedrooms, bathrooms, carSpaces, type, customer);
    }

    public String getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(String buyerId) {
        this.buyerId = buyerId;
    }

    public String toCsvFormat() {
        return String.format("%s,%s,%s,%d,%d,%d,%s,%s,%s%s", getID(), getAddress(), getSuburb(), getBedrooms(),
                getBathrooms(), getCarSpaces(), getType(), buyerId, getOwnerCustomer(), getEmployee());
    }

    public String toListFormat() {
        return "";
    }
}