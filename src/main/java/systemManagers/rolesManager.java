package systemManagers;

import com.opencsv.CSVReader;
import user.Customer;

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.nio.charset.StandardCharsets;

public class rolesManager {

    public List<List<String>> initRolesFromCSV(String roleToCheck) {
        String path = "csv/roles/" + roleToCheck + ".csv";
        List<List<String>> rolesList = new ArrayList<>();

        try (CSVReader csvReader = new CSVReader(new FileReader(path))) {
            String[] values = null;
            while ((values = csvReader.readNext()) != null) {
                rolesList.add(Arrays.asList(values));
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();


        }
        return rolesList;
    }


        public boolean verifyRoleExistence(Customer customer, String roleToCheck)
        {
            boolean userLegitimate = false;
            String customerID = customer.getId();
            List<List<String>> buyerIDs = initRolesFromCSV(roleToCheck);
            if (buyerIDs.contains(customerID)) {
                userLegitimate = true;
            }
            return userLegitimate;
        }


    }

