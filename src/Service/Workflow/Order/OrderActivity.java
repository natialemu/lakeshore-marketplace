package Service.Workflow.Order;

import java.util.Set;

import Service.Representation.Order.Representation.OrderRepresentation;
import Service.Representation.Order.Representation.OrderStatusRepresentation;
import Service.Representation.Product.Request.ProductRequest;

public interface OrderActivity {
	

	void placeOrder(Set<ProductRequest> products, String username);

	void cancelOrder(int orderID);

	OrderRepresentation getOrder(int orderID);

	OrderStatusRepresentation getOrderStatus(int orderID);

	void notifyCancellation(int orderID);

}
