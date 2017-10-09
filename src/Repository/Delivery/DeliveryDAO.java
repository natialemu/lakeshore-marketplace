package Repository.Delivery;

import Domain.Delivery.Delivery;

public interface DeliveryDAO {

    Delivery getDelivery(int delivery_tracking_id);

    void createDelivery(Delivery delivery);

    void insertDeliveryStatusWithJustTrackingNo(int deliveryID, int trackingnumber);


    void insertDeliveryStatus(int deliveryId,int trackingNumber, String deliveryMethod, String deliveryCarrier);

}
