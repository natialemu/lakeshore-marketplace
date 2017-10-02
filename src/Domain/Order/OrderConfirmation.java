package Domain.Order;

import Domain.Customer.Customer;

public interface OrderConfirmation {
    void setCustomer(Customer customer);
    void setConfirmationID(long confirmationID);
    void setMessageHeader(String messageHeader);
    void setMessageBody(String messageBody);

    Customer getCustomer();
    long getConfirmationID();
    String getMessageHeader();
    String getMessageBody();

}
