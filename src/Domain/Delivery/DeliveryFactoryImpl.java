package Domain.Delivery;

import Domain.Order.Order;
import Domain.Partner.Partner;
import Repository.Delivery.DeliveryDAO;
import Repository.Delivery.DeliveryDAOImpl;

public class DeliveryFactoryImpl implements DeliveryFactory{
    private Delivery delivery;
    private Partner partner;
    private DeliveryDAO deliveryDAO;
    private DeliveryConfirmation deliveryConfirmation;

    public DeliveryFactoryImpl(Order order){
        delivery = new DeliveryImpl(order);
        deliveryDAO  =new DeliveryDAOImpl();
        deliveryDAO.createDelivery(delivery);
        deliveryConfirmation = new DeliveryConfirmationImpl();
        deliveryConfirmation.sendConfirmation(order.getOrderDetail().getCustomer());
    }

    public DeliveryFactoryImpl(){
        deliveryDAO = new DeliveryDAOImpl();
    }

    @Override
    public void sendDelivery() {
        partner.acceptDelivery(delivery);

    }

    @Override
    public void acceptDeliveryStatus(int trackingNumber) {
        delivery.setDeliveryStatus(trackingNumber);
        deliveryDAO.insertDeliveryStatusWithJustTrackingNo(delivery);

    }

    @Override
    public void acceptDeliveryStatus(int trackingNumber, String deliveryCarrier, String deliveryMethod) {

        delivery.setDeliveryStatus(trackingNumber,deliveryMethod,deliveryCarrier);
        deliveryDAO.insertDeliveryStatus(delivery);
    }

    public Delivery getDelivery(int deliveryID){
        return deliveryDAO.getDelivery(deliveryID);
    }


}
