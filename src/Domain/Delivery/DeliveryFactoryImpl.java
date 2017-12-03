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
    private DeliveryDAO deliveryDAO;
    private PartnerFactory partnerFactory;

   
    public DeliveryFactoryImpl(){
        deliveryDAO = new DeliveryDAOImpl();
    	partnerFactory = new PartnerFactoryImpl();
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

    public void notifyPartnersOfDelivery(Order order) {
    	List<Partner> partners = order.getOrderDetail().getAllPartners();

        for(Partner p: partners){
            List<Product> products = order.getOrderDetail().getProductByPartner(p);
            //partnerFactory.acceptOrder(products, order.getOrderDetail().getCustomer());
            System.out.println("Email notification for delivery has been sent to partner: "+ p.getAccount().getAccountProfile().getContactInfo().getFullName());
            System.out.println("The seller will deliver " + products.size() + " products to "+order.getOrderDetail().getCustomer().getAccount().getAccountProfile().getContactInfo().getFullName());
        }
        Delivery delivery = new DeliveryImpl(order);
        deliveryDAO.createDelivery(delivery);
        DeliveryConfirmation deliveryConfirmation = new DeliveryConfirmationImpl();


    	
    }


	@Override
	public DeliveryStatus getDeliveryStatus(int tracking_number) {
		return deliveryDAO.getDeliveryStatus(tracking_number);
	}

}
