package Domain.Order;

import Domain.Customer.Customer;

public interface OrderConfirmation {

    void setConfirmationID(int confirmationID);

    void setMessageHeader(String messageHeader);

    void setMessageBody(String messageBody);

    int getConfirmationID();

    String getMessageHeader();

    String getMessageBody();

}
