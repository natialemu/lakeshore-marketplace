package Domain.Delivery;

import Domain.Order.Order;

public interface Delivery {
    void sendDelivery(Order order);
}
