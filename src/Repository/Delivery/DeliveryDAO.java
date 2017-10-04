package Repository.Delivery;

import Domain.Delivery.Delivery;

public interface DeliveryDAO {

    Delivery getDelivery(int delivery_tracking_id);

    void createDelivery(Delivery delivery);

    void insertDeliveryStatusWithJustTrackingNo(Delivery delivery);


    void insertDeliveryStatus(Delivery delivery);

}
