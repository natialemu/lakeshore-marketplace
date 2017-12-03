package Domain.Delivery;

import Domain.Order.Order;

public interface DeliveryFactory {

    void acceptDeliveryStatus(int deliveryID, int trackingNumber);
    void acceptDeliveryStatus(int deliveryId, int trackingNumber, String deliveryCarrier, String deliveryMethod);
    void sendConfirmation();
    void notifyPartnersOfDelivery(Order order);
	DeliveryStatus getDeliveryStatus(int orderID);

}
