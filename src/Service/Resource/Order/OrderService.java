package Service.Resource.Order;

import java.util.Set;

import javax.jws.WebService;

import Service.Representation.Account.Request.BasicAccountRequest;
import Service.Representation.Order.Representation.OrderRepresentation;
import Service.Representation.Order.Representation.OrderStatusRepresentation;
import Service.Representation.Order.Request.OrderRequest;
import Service.Representation.Product.Request.ProductRequest;

@WebService
public interface OrderService {

	void placeOrder(OrderRequest orderRequest);
	void cancelOrder(int orderID);
	OrderRepresentation getOrder(int orderID);
	OrderStatusRepresentation getOrderStatus(int orderID);
	Set<OrderRepresentation> getMostRecentOrders(int numOrders);
	
	
	
	
}
