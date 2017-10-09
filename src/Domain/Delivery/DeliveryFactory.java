package Domain.Delivery;

import Domain.Order.Order;

public interface DeliveryFactory {
    Delivery sendDelivery();

    void acceptDeliveryStatus(int deliveryID, int trackingNumber);
    void acceptDeliveryStatus(int deliveryId, int trackingNumber, String deliveryCarrier, String deliveryMethod);
    void sendConfirmation();

}
