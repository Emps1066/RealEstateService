package offer;

public class Offer {
    String offerId;
    String offerRecipient;
    String offerSender;
    double offerAmount;

    public Offer(String offerId, String offerRecipient, String offerSender, double offerAmount) {
        this.offerId = offerId;
        this.offerRecipient = offerRecipient;
        this.offerSender = offerSender;
        this.offerAmount = offerAmount;
    }
}
