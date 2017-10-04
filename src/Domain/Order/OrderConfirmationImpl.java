package Domain.Order;

import Domain.Customer.Customer;

public class OrderConfirmationImpl implements OrderConfirmation{
    private Customer customer;
    private long confirmationID;
    private String messageHeader;
    private String messageBody;

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public long getConfirmationID() {
        return confirmationID;
    }

    public void setConfirmationID(long confirmationID) {
        this.confirmationID = confirmationID;
    }

    public String getMessageHeader() {
        return messageHeader;
    }

    public void setMessageHeader(String messageHeader) {
        this.messageHeader = messageHeader;
    }

    public String getMessageBody() {
        return messageBody;
    }

    @Override
    public void confirmOrder(Order order) {
        //TODO
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    @Override
    public String toString() {
        return "OrderConfirmationImpl{" +
                "customer=" + customer +
                ", confirmationID=" + confirmationID +
                ", messageHeader='" + messageHeader + '\'' +
                ", messageBody='" + messageBody + '\'' +
                '}';
    }
}
