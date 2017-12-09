package Service.Workflow.Order;

import java.util.Set;

import Service.Representation.Account.Representation.AccountValidationRepresentation;
import Service.Representation.Order.Representation.OrderRepresentation;
import Service.Representation.Order.Representation.OrderRepresentationImpl;
import Service.Representation.Order.Representation.OrderStatusRepresentation;
import Service.Representation.Order.Representation.OrderStatusRepresentationImpl;
import Service.Representation.Product.Request.*;

public interface OrderActivity {
	

	AccountValidationRepresentation placeOrder(Set<ProductRequestImpl> products, String username);

	AccountValidationRepresentation cancelOrder(int orderID);

	OrderRepresentationImpl getOrder(int orderID);

	OrderStatusRepresentationImpl getOrderStatus(int orderID);

	void notifyCancellation(int orderID);

	Set<OrderRepresentationImpl> getMostRecentOrders(int numOrders);

	Set<OrderRepresentationImpl> getOrdersOfPartner(String partner_username);

}
