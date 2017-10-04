package Domain.Delivery;

import Domain.Order.Order;

public interface DeliveryFactory {
    void sendDelivery();

    void acceptDeliveryStatus(int trackingNumber);
    void acceptDeliveryStatus(int trackingNumber, String deliveryCarrier, String deliveryMethod);

}
