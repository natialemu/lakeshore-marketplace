package Service.Workflow.Order;

import java.util.Set;

import Service.Representation.Account.Representation.AccountValidationRepresentation;
import Service.Representation.Order.Representation.OrderRepresentation;
import Service.Representation.Order.Representation.OrderStatusRepresentation;
import Service.Representation.Product.Request.ProductRequest;

public interface OrderActivity {
	

	AccountValidationRepresentation placeOrder(Set<ProductRequest> products, String username);

	AccountValidationRepresentation cancelOrder(int orderID);

	OrderRepresentation getOrder(int orderID);

	OrderStatusRepresentation getOrderStatus(int orderID);

	void notifyCancellation(int orderID);

	Set<OrderRepresentation> getMostRecentOrders(int numOrders);

	Set<OrderRepresentation> getOrdersOfPartner(String partner_username);

}
