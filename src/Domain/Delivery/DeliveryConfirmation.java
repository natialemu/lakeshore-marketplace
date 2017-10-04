package Domain.Delivery;

import Domain.Customer.Customer;

public interface DeliveryConfirmation {


    void sendConfirmation(Customer customer);

}
