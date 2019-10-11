package offerAndApplication;


import utilities.dateTime.DateTime;

import java.util.Objects;

public class Offer {
    private String offerId;
    private String offerRecipient;
    private String offerSender;
    private String propertyId;
    private double offerAmount;
    private DateTime offerMade;
    private DateTime offerAccepted;


    public Offer(String offerId, String offerRecipient, String offerSender, String propertyId, double offerAmount, DateTime offerMade, DateTime offerAccepted) {
        this.offerId = offerId;
        this.offerRecipient = offerRecipient;
        this.offerSender = offerSender;
        this.propertyId = propertyId;
        this.offerAmount = offerAmount;
        this.offerMade = offerMade;
        this.offerAccepted = offerAccepted;
    }

    public String getOfferId() {
        return offerId;
    }

    public void setOfferId(String offerId) {
        this.offerId = offerId;
    }

    public String getOfferRecipient() {
        return offerRecipient;
    }

    public String getOfferSender() {
        return offerSender;
    }

    public String getPropertyId() {
        return propertyId;
    }

    public double getOfferAmount() {
        return offerAmount;
    }

    public DateTime getOfferMade() {
        return offerMade;
    }

    public void setOfferMade(DateTime offerMade) {
        this.offerMade = offerMade;
    }

    public DateTime getOfferAccepted() {
        return offerAccepted;
    }

    public void setOfferAccepted(DateTime offerAccepted) {
        this.offerAccepted = offerAccepted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Offer offer = (Offer) o;
        return Double.compare(offer.offerAmount, offerAmount) == 0 &&
                offerId.equals(offer.offerId) &&
                offerRecipient.equals(offer.offerRecipient) &&
                offerSender.equals(offer.offerSender) &&
                propertyId.equals(offer.propertyId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(offerId, offerRecipient, offerSender, propertyId, offerAmount);
    }

    public String toCsvFormat() {
        return String.format("%s,%s,%s,%s,%f,%d,%d"
                , offerId
                , offerRecipient
                , offerSender
                , propertyId
                , offerAmount
                , offerMade == null ? 0 : offerMade.getTime()
                , offerAccepted == null ? 0 : offerAccepted.getTime());
    }

    public String toListFormat() {
        return String.format("--------------------------------\n" +
                        "Offer ID: %s\n" + "Offer Sender ID: %s\n" +
                        "Offered Property ID: %s\n" +
                        "Offer Amount: %.2f $\n" + "Offer Made on: %s\n" +
                        "Offer Accepted on: %s\n" +
                        "--------------------------------",
                offerId, offerSender, propertyId, offerAmount, offerMade.toString(),
                offerAccepted == null ? "N/A" : offerAccepted.toString());
    }

}
