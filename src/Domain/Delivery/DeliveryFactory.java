package Domain.Delivery;

import Domain.Order.Order;

public interface DeliveryFactory {
    void sendDelivery(Order order);
}
