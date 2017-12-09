package Service.Resource.Order;

import java.util.Set;

import javax.jws.WebService;

import Service.Representation.Account.Representation.AccountValidationRepresentation;
import Service.Representation.Account.Request.BasicAccountRequest;
import Service.Representation.Order.Representation.OrderRepresentation;
import Service.Representation.Order.Representation.OrderRepresentationImpl;
import Service.Representation.Order.Representation.OrderStatusRepresentation;
import Service.Representation.Order.Request.OrderRequest;
import Service.Representation.Order.Request.OrderRequestImpl;
import Service.Representation.Product.Request.ProductRequest;
import Service.Representation.Product.Request.ProductRequestImpl;

@WebService
public interface OrderService {

	AccountValidationRepresentation placeOrder(Set<ProductRequestImpl>  orderRequest, String username);
	AccountValidationRepresentation cancelOrder(int orderID);
	OrderRepresentation getOrder(int orderID);
	OrderStatusRepresentation getOrderStatus(int orderID);
	Set<OrderRepresentationImpl> getMostRecentOrders(int numOrders);
	Set<OrderRepresentationImpl> getOrdersOfPartner(String partner_username);
	
	
	
	
}
