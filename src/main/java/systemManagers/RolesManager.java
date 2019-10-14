package systemManagers;

import enums.Roles;
import java.util.Arrays;
import java.util.List;

public class RolesManager {
    List<String> branchAdmins;
    List<String> propertyManagers;
    List<String> salesAssociates;

    public void addId(String id, Roles role) {
        if(role == Roles.BRANCH_ADMIN) {
            branchAdmins.add(id);
        } else if(role == Roles.PROPERTY_MANAGER) {
            propertyManagers.add(id);
        } else if(role == Roles.SALES_ASSOCIATE) {
            salesAssociates.add(id);
        }
    }

    public Roles getRole(String id) {
        Roles role = null;
        for(String userId : branchAdmins) {
            if(userId.equals(id)) {
                role = Roles.BRANCH_ADMIN;
            }
        }
        for(String userId : propertyManagers) {
            if(userId.equals(id)) {
                role = Roles.PROPERTY_MANAGER;
            }
        }
        for(String userId : salesAssociates) {
            if(userId.equals(id)) {
                role = Roles.SALES_ASSOCIATE;
            }
        }

        return role;
    }
}

