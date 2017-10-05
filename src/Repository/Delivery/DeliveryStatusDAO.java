package Repository.Delivery;

import Domain.Delivery.DeliveryStatus;

public interface DeliveryStatusDAO {
    void insertDeliveryStatusWithJustTrackingNo(int deliveryID, int trackingnumber);


    void insertDeliveryStatus(int deliveryId, int trackingNumber, String deliveryMethod, String deliveryCarrier);

    DeliveryStatus getDeliveryStatus(int tracking_number);

}
