package Domain.Delivery;

import Domain.Order.Order;
import Domain.Partner.Partner;
import Domain.Partner.PartnerFactory;
import Domain.Partner.PartnerFactoryImpl;
import Domain.Partner.PartnerImpl;
import Domain.Product.Product;
import Repository.Delivery.DeliveryDAO;
import Repository.Delivery.DeliveryDAOImpl;

import java.util.List;

public class DeliveryFactoryImpl implements DeliveryFactory{
    private Delivery delivery;
    private List<Partner> partners;
    private DeliveryDAO deliveryDAO;
    private DeliveryConfirmation deliveryConfirmation;
    private PartnerFactory partnerFactory;

    public DeliveryFactoryImpl(Order order){
    	partnerFactory = new PartnerFactoryImpl();
        delivery = new DeliveryImpl(order);
        deliveryDAO  =new DeliveryDAOImpl();
        partners = order.getOrderDetail().getAllPartners();

        for(Partner p: partners){
            List<Product> products = order.getOrderDetail().getProductByPartner(p);
            partnerFactory.acceptOrder(products, order.getOrderDetail().getCustomer());
        }
        deliveryDAO.createDelivery(delivery);
        deliveryConfirmation = new DeliveryConfirmationImpl();
        sendConfirmation();
        //send it to the partner
        //partner.acceptDelivery(delivery);
    }

    public DeliveryFactoryImpl(){
        deliveryDAO = new DeliveryDAOImpl();
    }

    @Override
    public Delivery sendDelivery() {
        return delivery;
    }

    @Override
    public void acceptDeliveryStatus(int deliveryId, int trackingNumber) {

        deliveryDAO.insertDeliveryStatusWithJustTrackingNo(deliveryId,trackingNumber);

    }

    @Override
    public void acceptDeliveryStatus(int deliveryID, int trackingNumber, String deliveryMethod, String deliveryCarrier) {

        //delivery.setDeliveryStatus(trackingNumber,deliveryMethod,deliveryCarrier);
        deliveryDAO.insertDeliveryStatus(deliveryID,trackingNumber,deliveryMethod,deliveryCarrier);
    }

    @Override
    public void sendConfirmation() {
        System.out.println("Delivery has been sent to partner!");
    }

    public Delivery getDelivery(int deliveryID){
        return deliveryDAO.getDelivery(deliveryID);
    }


}
