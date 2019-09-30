package offerAndApplication;


import utilities.dateTime.DateTime;

public class Offer {
    private String offerId;
    private String offerRecipient;
    private String offerSender;
    private String offerProperty;
    private double offerAmount;
    private DateTime offerMade;
    private DateTime offerAccepted = null;
    private DateTime offerSetInStone = null;


    public Offer(String offerId, String offerRecipient, String offerSender, String offerPropery, double offerAmount, DateTime offerMade, DateTime offerAccepted, DateTime offerSetInStone) {
        this.offerId = offerId;
        this.offerRecipient = offerRecipient;
        this.offerSender = offerSender;
        this.offerProperty = offerPropery;
        this.offerAmount = offerAmount;
        this.offerMade = offerMade;
        this.offerAccepted = offerAccepted;
        this.offerSetInStone = offerSetInStone;
    }

    public String getOfferId() {
        return offerId;
    }

    public String getOfferRecipient() {
        return offerRecipient;
    }

    public String getOfferSender() {
        return offerSender;
    }

    public String getOfferProperty() {
        return offerProperty;
    }

    public double getOfferAmount() {
        return offerAmount;
    }

    public DateTime getOfferMade() {
        return offerMade;
    }

    public DateTime getOfferAccepted() {
        return offerAccepted;
    }

    public void setOfferAccepted(DateTime offerAccepted) {
        this.offerAccepted = offerAccepted;
    }

    public DateTime getOfferSetInStone() {
        return offerSetInStone;
    }

    public void setOfferSetInStone(DateTime offerSetInStone) {
        this.offerSetInStone = offerSetInStone;
    }

    public String toCsvFormat() {
        return String.format("%s,%s,%s,%s,%f,%d,%d,%d"
                ,offerId
                ,offerRecipient
                ,offerSender
                ,offerProperty
                ,offerAmount
                ,offerMade.getTime()
                ,offerAccepted == null ? 0 : offerAccepted.getTime()
                ,offerSetInStone == null ? 0 : offerSetInStone.getTime());
    }

    public String toListFormat() {
        return String.format("--------------------------------\n" +
                        "Offer ID: %s\n" + "Offer Sender ID: %s\n" +
                        "Offered Property ID: %s\n" +
                        "Offer Amount: %.2f\n" + "Offer Made on: %s\n" +
                        "Offer Accepted on: %s\n" +
                        "--------------------------------",
                offerId, offerSender, offerProperty, offerAmount, offerMade.toString(), offerAccepted.toString()
                );
    }

}
