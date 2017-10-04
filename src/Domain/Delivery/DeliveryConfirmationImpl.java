package Domain.Delivery;

import Domain.Customer.Customer;

public class DeliveryConfirmationImpl implements DeliveryConfirmation {
     private int deliveryConfirmation_id;
     private String header;
     private String body;

    @Override
    public void sendConfirmation(Customer customer) {
        System.out.println("Confirmation sent to " +customer.getAccount().getAccountProfile().getContactInfo().getEmail());
    }
}
