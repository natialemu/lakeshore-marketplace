package Domain.Delivery;

import Domain.Tools.IDGenerator;

public class DeliveryConfirmationImpl implements DeliveryConfirmation {
     private int deliveryID;

     public DeliveryConfirmationImpl(){
         deliveryID = IDGenerator.getId();
     }
    public int getDeliveryID() {
        return deliveryID;
    }

    public void setDeliveryID(int deliveryID) {
        this.deliveryID = deliveryID;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    private String header;
     private String body;

}
