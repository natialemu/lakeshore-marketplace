package Repository.Delivery;

import Domain.Delivery.Delivery;
import Domain.Delivery.DeliveryStatus;

public class DeliveryDAOImpl implements DeliveryDAO {
    private DeliveryConfirmationDAO deliveryConfirmationDAO;
    private DeliveryStatusDAO deliveryStatusDAO;

    public DeliveryDAOImpl(){
        deliveryConfirmationDAO = new DeliveryConfirmationDAOImpl();
        deliveryStatusDAO = new DeliveryStatusDAOImpl();
    }
    @Override
    public Delivery getDelivery(int delivery_tracking_id) {
        return null;
    }

    @Override
    public void createDelivery(Delivery delivery) {

    }

    @Override
    public void insertDeliveryStatusWithJustTrackingNo(Delivery delivery) {

    }

    @Override
    public void insertDeliveryStatus(Delivery delivery) {

    }
}
