package Service.Resource.Order;

import java.util.Set;

import javax.jws.WebService;

import Service.Representation.Account.BasicAccountRequest;
import Service.Representation.Order.OrderRepresentation;
import Service.Representation.Order.OrderStatusRepresentation;
import Service.Representation.Product.ProductRequest;

@WebService
public interface OrderService {

	void placeOrder(Set<ProductRequest> products,BasicAccountRequest basicAccountRequest);
	void cancelOrder(int orderID);
	OrderRepresentation getOrder(int orderID);
	OrderStatusRepresentation getOrderStatus(int orderID);
	
	void notifyCancellation(int orderID);
	
	
	
}
