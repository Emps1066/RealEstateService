package systemManagers;

import enums.PropertyListType;
import org.junit.jupiter.api.Test;
import property.ForSaleProperty;

import java.util.HashMap;

class PropertyManagerTest {

    @Test
    void addProperty() {
        PropertyManager propertyManager = new PropertyManager(new HashMap<>(), new HashMap<>(), new HashMap<>());
        ForSaleProperty property = new ForSaleProperty(null, "23 Swann Street", "Kyneton", 3,
                3, 3, "Sale", "billy", 3000000, 10000000);

        property.setListed(true);
        propertyManager.addProperty(property);

        System.out.println("before approving");
        System.out.println(propertyManager.listedPropertiesToString(PropertyListType.FOR_SALE));
        int countTotal = IdManager.getIdCount("pendingForSale") - 1;
        String expectedPropertyId = "PS" + countTotal;
        propertyManager.approveProperty(expectedPropertyId, "E5");
        System.out.println("after approving");
        System.out.println(propertyManager.listedPropertiesToString(PropertyListType.FOR_SALE));
    }
}