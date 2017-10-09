package Domain.Delivery;

import Domain.Customer.Customer;

public interface DeliveryConfirmation {


    void setDeliveryID(int deliveryID);
    void setHeader(String header);
    void setBody(String body);

    int getDeliveryID();
    String getHeader();
    String getBody();



}
