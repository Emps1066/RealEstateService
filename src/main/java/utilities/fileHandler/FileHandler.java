package utilities.fileHandler;

import engine.SystemEngine;
import enums.PropertyListType;
import offerAndApplication.Application;
import offerAndApplication.Offer;
import property.ForSaleProperty;
import property.Property;
import property.RentalProperty;
import systemManagers.PropertyManager;
import user.Customer;
import user.Employee;
import user.User;
import utilities.dateTime.DateTime;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class FileHandler {
    private static final int DAYS_TO_ACCEPT_ACCEPTED_APPLICATION = 1;
    private static final int DAYS_TO_ACCEPT_PENDING_APPLICATION = 3;
    private static final int DAYS_TO_ACCEPT_ACCEPTED_OFFER = 1;
    private static final int DAYS_TO_ACCEPT_PENDING_OFFER = 3;

    public static String get(String uniqueString, int uniqueIndex, String file) {
        String rowToGet = null;
        boolean found = false;
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            String row;
            while((row = fileReader.readLine()) != null && !found) {
                String rowArray[] = row.split(",");
                if(rowArray[uniqueIndex].equals(uniqueString)) {
                    rowToGet = row;
                    found = true;
                }
            }
            fileReader.close();
        } catch(IOException e) {
            System.err.printf("Error reading from %s\n", file);
        }
        return rowToGet;
    }

    public static void delete(String Id, String file) {
        String newFileText = "";
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            String row;
            while((row = fileReader.readLine()) != null) {
                if(!row.startsWith(Id)) {
                    newFileText += row;
                    newFileText += "\n";
                }
            }
            fileReader.close();
        } catch(IOException e) {
            System.err.printf("Error reading from %s\n", file);
        }

        writeToFile(newFileText, file, false);
    }

    public Map<String, Property> readPropertyManagerComponents(String fileName) {
        Map<String, Property> properties = new HashMap<>();
        String file = "src\\main\\java\\csv\\properties\\" + fileName + "ForSaleProperties.csv";

        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            String row;
            while((row = fileReader.readLine()) != null) {
                String rowArray[] = row.split(",");

                ForSaleProperty property = new ForSaleProperty(rowArray[1], rowArray[2],
                        rowArray[3], Integer.parseInt(rowArray[4]),
                        Integer.parseInt(rowArray[5]), Integer.parseInt(rowArray[6]),
                        rowArray[7], rowArray[8].equals("null") ? null : rowArray[8],
                        Double.parseDouble(rowArray[11]));
                property.setBuyerId(rowArray[12].equals("null") ? null : rowArray[12]);

                if(rowArray[0].equals("true")) {
                    property.setListed(true);
                } else {
                    property.setListed(false);
                }
                property.setPropertyBalance(Double.parseDouble(rowArray[10]));
                property.setEmployee(rowArray[9].equals("null") ? null : rowArray[9]);
                properties.put(property.getID(), property);
            }
            fileReader.close();
        } catch(IOException e) {
            System.err.printf("Error reading from %s\n", file);
        }

        file = "src\\main\\java\\csv\\properties\\" + fileName + "RentalProperties.csv";

        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            String row;
            while((row = fileReader.readLine()) != null) {
                String rowArray[] = row.split(",");

                RentalProperty property = new RentalProperty(rowArray[1], rowArray[2],
                        rowArray[3], Integer.parseInt(rowArray[4]),
                        Integer.parseInt(rowArray[5]), Integer.parseInt(rowArray[6]),
                        rowArray[7], rowArray[8].equals("null") ? null : rowArray[8] ,
                        Double.parseDouble(rowArray[11]), Double.parseDouble(rowArray[12]),
                        Double.parseDouble(rowArray[13]), Double.parseDouble(rowArray[14]));
                property.setRenterId(rowArray[15].equals("null") ? null : rowArray[15]);

                if(rowArray[0].equals("true")) {
                    property.setListed(true);
                } else {
                    property.setListed(false);
                }
                property.setEmployee(rowArray[9].equals("null") ? null : rowArray[9]);
                property.setPropertyBalance(Double.parseDouble(rowArray[10]));
                properties.put(property.getID(), property);
            }
            fileReader.close();
        } catch(IOException e) {
            System.err.printf("Error reading from %s\n", file);
        }
        return properties;
    }

    public Map<String, Offer> readOfferManager(PropertyManager propertyManager) {
        Map<String, Offer> offers = new HashMap<>();

        String file = "src\\main\\java\\csv\\offer\\offer.csv";
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            String row;
            while((row = fileReader.readLine()) != null) {
                String rowArray[] = row.split(",");

                DateTime offerMadeTime = new DateTime(Long.parseLong(rowArray[5]));
                DateTime offerAcceptedTime;
                int daysTillExpiration;
                DateTime timerStartDate;
                if(Long.parseLong(rowArray[6]) == 0) {
                    offerAcceptedTime = null;
                    daysTillExpiration = DAYS_TO_ACCEPT_PENDING_OFFER;
                    timerStartDate = offerMadeTime;
                } else {
                    offerAcceptedTime = new DateTime(Long.parseLong(rowArray[6]));
                    daysTillExpiration = DAYS_TO_ACCEPT_ACCEPTED_OFFER;
                    timerStartDate = offerAcceptedTime;
                }
                Offer offer = new Offer(rowArray[0], rowArray[1],
                        rowArray[2], rowArray[3], Double.parseDouble(rowArray[4]),
                        offerMadeTime, offerAcceptedTime);


                if(DateTime.diffDays(new DateTime(), timerStartDate) < daysTillExpiration) {
                    offers.put(offer.getOfferId(), offer);
                } else {
                    propertyManager.listProperty(offer.getPropertyId());
                }
            }
            fileReader.close();
        } catch(IOException e) {
            System.err.printf("Error reading from %s\n", file);
        }

        return offers;
    }

    public Map<String, Application> readApplicationManager(PropertyManager propertyManager) {
        Map<String, Application> applications = new HashMap<>();

        String file = "src\\main\\java\\csv\\application\\application.csv";
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            String row;
            while((row = fileReader.readLine()) != null) {
                String rowArray[] = row.split(",");

                DateTime appMadeTime = new DateTime(Long.parseLong(rowArray[11]));
                DateTime appAcceptedTime;
                int daysTillExpiration;
                DateTime timerStartDate;
                if(Long.parseLong(rowArray[12]) == 0) {
                    appAcceptedTime = null;
                    daysTillExpiration = DAYS_TO_ACCEPT_PENDING_APPLICATION;
                    timerStartDate = appMadeTime;
                } else {
                    appAcceptedTime = new DateTime(Long.parseLong(rowArray[12]));
                    daysTillExpiration = DAYS_TO_ACCEPT_ACCEPTED_APPLICATION;
                    timerStartDate = appAcceptedTime;
                }
                Application application = new Application(rowArray[0], rowArray[1],
                        rowArray[2], rowArray[3], Double.parseDouble(rowArray[4]),
                        Double.parseDouble(rowArray[5]), Double.parseDouble(rowArray[6]), rowArray[7], rowArray[8],
                        rowArray[9], rowArray[10], appMadeTime, appAcceptedTime);


                if(DateTime.diffDays(new DateTime(), timerStartDate) < daysTillExpiration) {
                    applications.put(application.getAppId(), application);
                } else {
                    propertyManager.listProperty(application.getPropertyId());
                }
            }
            fileReader.close();
        } catch(IOException e) {
            System.err.printf("Error reading from %s\n", file);
        }

        return applications;
    }

    public Map<String, User> readUsersFile() {
        Map<String, User> users = new HashMap<>();

        String file = "src\\main\\java\\csv\\users\\customer.csv";
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            String row;
            while((row = fileReader.readLine()) != null) {
                String rowArray[] = row.split(",");

                Customer customer = new Customer(rowArray[0], rowArray[1], rowArray[2], rowArray[3]);
                users.put(rowArray[0], customer);
            }
            fileReader.close();
        } catch(IOException e) {
            System.err.printf("Error reading from %s\n", file);
        }

        file = "src\\main\\java\\csv\\users\\employee.csv";
        try {
            BufferedReader fileReader = new BufferedReader(new FileReader(file));
            String row;
            while((row = fileReader.readLine()) != null) {
                String rowArray[] = row.split(",");

                Employee employee = new Employee(rowArray[0], rowArray[1], rowArray[2], rowArray[3]);
                employee.setCommission(Double.parseDouble(rowArray[4]));
                employee.setHoursWorked(Double.parseDouble(rowArray[5]));
                employee.setPaidSalary(Double.parseDouble(rowArray[6]));
                employee.setPaid(rowArray[7].equals("true") ? true : false);

                users.put(rowArray[0], employee);
            }
            fileReader.close();
        } catch(IOException e) {
            System.err.printf("Error reading from %s\n", file);
        }

        return users;
    }

    public static void writeToFile(String data, String file, boolean append) {
        try {
            FileWriter newPendingPropertyFile = new FileWriter(file, append);
            newPendingPropertyFile.append(data);
            newPendingPropertyFile.close();
        } catch(IOException e) {
            System.err.printf("Error writing to %s\n", file);
        }
    }
}
