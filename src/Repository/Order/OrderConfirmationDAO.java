package Repository.Order;

import Domain.Order.OrderConfirmation;

public interface OrderConfirmationDAO {
    OrderConfirmation getOrderConfirmation(int confirmationID);

    boolean createOrderConfirmation(OrderConfirmation orderConfirmation);
}
