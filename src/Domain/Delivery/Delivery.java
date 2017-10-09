package Domain.Delivery;

import Domain.Order.Order;

import java.util.Date;

public interface Delivery {
    Order getOrder();
    void setOrder(Order order);
    void setDeliveryStatus(int trackingNumber);
    void setDeliveryStatus(int trackingNumber, String deliveryMethod, String deliveryCarrier);

    Date getDeliveryCreationDate();
    void setDeliveryCreationDate(Date deliveryCreationDate);
    DeliveryStatus getDeliveryStatus();
    void setDeliveryStatus(DeliveryStatus deliveryStatus);
    int getDeliveryID();
    void setDeliveryID(int deliveryID);
    void setDeliveryConfirmation(DeliveryConfirmation confirmation);
    DeliveryConfirmation getDeliveryConfirmation();
}
