package Domain.Partner;

import java.util.List;

import Domain.Customer.Customer;
import Domain.Delivery.Delivery;
import Domain.Product.Product;

public interface PartnerFactory {
	void createPartner(Partner partner);
	void registerPartner(String email, String username, String password);
	void addProducts(int partnerID, List<Product> products);
	Delivery acceptDelivery(Partner partner, Delivery delivery);
	void acceptOrder(List<Product> products, Customer customer);
	void provideDeliveryStatus(int deliveryID, int trackingNumber);
	void provideDeliveryStatus(int deliveryID, int trackingNumber, String deliveryMethod,String deliveryCarrier);
	void orderReturned(int orderID);
	Partner createNewPartner();
	void deleteProduct(int partner_id, int product_id);


}
