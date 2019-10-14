package systemManagers;

import enums.PropertyListType;
import offerAndApplication.Offer;
import user.User;
import utilities.dateTime.DateTime;
import utilities.fileHandler.FileHandler;
import utilities.scanner.Scan;

import java.util.HashMap;
import java.util.Map;

public class OfferManager {
    private static final int DAYS_TO_ACCEPT_ACCEPTED_OFFER = 1;
    private static final int DAYS_TO_ACCEPT_PENDING_OFFER = 3;
    private Map<String, Offer> offers = new HashMap<>();

    private String pendingIdSerial = "PO";
    private String acceptedIdSerial = "AO";

    public OfferManager(Map<String, Offer> offers) {
        this.offers = offers;
    }

    // To Create And Send Application
    public void sendOffer(User user, PropertyManager propertyManager) {
        String propertyId = Scan.askForString("Enter The ID of the Property To Send Offer To:");
        if(propertyManager.propertyExistsAsListed(propertyId, PropertyListType.FOR_SALE))
        {
            Offer offer = askForOfferDetails(user.getId(),
                    propertyManager.getPropertyOwnerId(propertyId), propertyId);
            sendOffer(offer);
        }
        else {
            System.out.println("Sorry The Property Entered Could Not Be Found, please try again later");
        }
    }

    public Offer askForOfferDetails(String buyerCustomerId, String propertyOwnerId, String propertyId) {
        double offerAmount = Scan.askForDouble("Enter Offering Price:");
        Offer offer = new Offer(null, propertyOwnerId, buyerCustomerId, propertyId,
                offerAmount, null, null);

        return offer;
    }

    public void sendOffer(Offer offer) {
        DateTime currTime = new DateTime();
        String Id = IdManager.generateUniqueID(pendingIdSerial, "pendingOffer");
        offer.setOfferMade(currTime);
        offer.setOfferId(Id);
        offers.put(Id, offer);
        IdManager.updateUniqueIdValue("pendingOffer");
        System.out.println("\nOffer Sent\n");
    }

    public boolean acceptOffer(String offerId, String propertyOwnerId, PropertyManager propertyManager) {

        boolean accepted = false;
        Offer offer = offers.get(offerId);
        if(offer != null) {
            if(offer.getOfferId().startsWith(pendingIdSerial)) {
                if (!offerIsExpired(offer, DAYS_TO_ACCEPT_PENDING_OFFER) &&
                        offer.getOfferRecipient().equals(propertyOwnerId)) {

                    DateTime currTime = new DateTime();
                    String Id = IdManager.generateUniqueID(acceptedIdSerial, "acceptedOffer");
                    offer.setOfferAccepted(currTime);
                    offer.setOfferId(Id);
                    IdManager.updateUniqueIdValue("acceptedOffer");

                    propertyManager.unlistProperty(offer.getPropertyId());
                    System.out.println("\nOffer Has Been Accepted\n");
                    accepted = true;
                } else {
                    System.out.println("Offer Is Not Yours To Accept Or Expired");
                }
            } else {
                System.out.println("Offer Can Not Be Accepted");
            }
        } else {
            System.out.println("Offer does not exist or is expired");
        }
        return accepted;
    }

    // To Finalise Applications

    //Returns String to put underContract
    public boolean finaliseOffer(String offerId, String buyerCustomerId, InspectionManager inspectionManager, PropertyManager propertyManager) {

        boolean finalised = false;
        Offer offer = offers.get(offerId);
        if(offer != null) {
            if(offer.getOfferId().startsWith(acceptedIdSerial)) {
                if(!offerIsExpired(offer, DAYS_TO_ACCEPT_ACCEPTED_OFFER) &&
                        offer.getOfferSender().equals(buyerCustomerId)) {

                    propertyManager.setPropertyUnderContract(offer.getPropertyId(), buyerCustomerId, inspectionManager, propertyManager);

                    withdrawOffer(offerId, buyerCustomerId);
                    System.out.println("\nPayments Have Been Finalised The Property Is Yours\n");
                    finalised = true;
                } else {
                    System.out.println("Offer Is Not Yours To Finalise Or Is Expired");
                }
            } else {
                System.out.println("Offer Can Not Be Finalised");
            }
        } else {
            System.out.println("Offer Does Not Exist Or Is Expired");
        }
        return finalised;
    }

    // WithDraw/Reject Offers

    public void withdrawOffer(String offerId, String buyerCustomerId) {
        Offer offer = offers.get(offerId);
        if(offer != null) {
            if(offer.getOfferSender().equals(buyerCustomerId)) {
                offers.remove(offerId);
                System.out.println("\nOffer Has Been Withdrawn\n");
            } else {
                System.out.println("Offer Is Not Yours To Withdraw");
            }
        } else {
            System.out.println("Offer Does Not Exist Or Is Expired");
        }
    }

    public void rejectOffer(String offerId, String offerReceiverId) {
        Offer offer = offers.get(offerId);
        if(offer != null) {
            if(offer.getOfferRecipient().equals(offerReceiverId)) {
                offers.remove(offerId);
                System.out.println("\nOffer Has Been rejected\n");
            } else {
                System.out.println("Offer Is Not Yours To Reject");
            }
        } else {
            System.out.println("Offer Does Not Exist Or Is Expired");
        }
    }

    // To Display Offers

    private String propertySeekerOffersToListFormat(String seekerId, int daysTillExpiration, String offerIdSerial) {

        StringBuilder list = new StringBuilder();
        for(Offer offer : offers.values()) {
            if(offer.getOfferId().startsWith(offerIdSerial)) {

                if(offer.getOfferSender().equals(seekerId) &&
                        !offerIsExpired(offer, daysTillExpiration)) {
                    list.append(offer.toListFormat());
                    list.append("\n");
                }
            }
        }
        return list.toString();
    }

    public String propertySeekerAcceptedOffersToListFormat(String seekerId) {
        return propertySeekerOffersToListFormat(seekerId, DAYS_TO_ACCEPT_ACCEPTED_OFFER, acceptedIdSerial);
    }

    public String propertySeekerPendingOffersToListFormat(String seekerId) {
        return propertySeekerOffersToListFormat(seekerId, DAYS_TO_ACCEPT_PENDING_OFFER, pendingIdSerial);
    }

    public String propertySeekerAllOffersToListFormat(String seekerId) {
        StringBuilder list = new StringBuilder();
        list.append(propertySeekerAcceptedOffersToListFormat(seekerId));
        list.append(propertySeekerPendingOffersToListFormat(seekerId));
        return list.toString();
    }

    public String propertyOwnerOffersToListFormat(String ownerId, String propertyId) {
        StringBuilder list = new StringBuilder();
        int daysTillExpiration;
        for(Offer offer : offers.values()) {
            if(offer.getOfferId().startsWith(pendingIdSerial)) {
                daysTillExpiration = DAYS_TO_ACCEPT_PENDING_OFFER;
            } else {
                daysTillExpiration = DAYS_TO_ACCEPT_ACCEPTED_OFFER;
            }
            if(propertyId == null) {
                if (offer.getOfferRecipient().equals(ownerId) &&
                        !offerIsExpired(offer, daysTillExpiration)) {
                    list.append(offer.toListFormat());
                    list.append("\n");
                }
            } else {
                if (offer.getPropertyId().equals(propertyId) &&
                        !offerIsExpired(offer, daysTillExpiration)) {
                    list.append(offer.toListFormat());
                    list.append("\n");
                }
            }
        }
        return list.toString();
    }

    // Boolean Methods

    private boolean offerIsExpired(Offer offer, int daysTillExpiration) {
        boolean expired = false;
        DateTime dateStarted;
        if(offer.getOfferAccepted() != null) {
            dateStarted = offer.getOfferAccepted();
        } else {
            dateStarted = offer.getOfferMade();
        }
        DateTime currentDate = new DateTime();
        int daysPassed = DateTime.diffDays(currentDate, dateStarted);
        if (daysPassed >= daysTillExpiration) {
            expired = true;
        }

        return expired;
    }

    private void saveOfferToFile(Offer offer) {
        FileHandler.writeToFile(offer.toCsvFormat(), "src\\main\\java\\csv\\offer\\offer.csv", true);
        FileHandler.writeToFile("\n", "src\\main\\java\\csv\\offer\\offer.csv", true);
    }

    public void saveToSystem() {
        FileHandler.writeToFile("", "src\\main\\java\\csv\\offer\\offer.csv", false);
        for(Offer offer : offers.values()) {
            saveOfferToFile(offer);
        }
    }
}
