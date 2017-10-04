package Domain.Order;

import Domain.Customer.Customer;

public class OrderConfirmationImpl implements OrderConfirmation{
    private int confirmationID;
    private String messageHeader;
    private String messageBody;
    //TODO: get the confirmation through the ID


    public int getConfirmationID() {
        return confirmationID;
    }

    public void setConfirmationID(int confirmationID) {
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


    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }

    @Override
    public String toString() {
        return "OrderConfirmationImpl{" +
                ", confirmationID=" + confirmationID +
                ", messageHeader='" + messageHeader + '\'' +
                ", messageBody='" + messageBody + '\'' +
                '}';
    }
}
