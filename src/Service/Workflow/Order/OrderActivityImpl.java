package Service.Workflow.Order;

import java.util.Set;

import Domain.Order.OrderFactory;
import Domain.Order.OrderFactoryImpl;
import Service.Representation.Order.OrderRepresentation;
import Service.Representation.Order.OrderStatusRepresentation;
import Service.Representation.Product.ProductRequest;

public class OrderActivityImpl implements OrderActivity {

	private OrderFactory orderFactory;
	
	public OrderActivityImpl() {
		orderFactory = new OrderFactoryImpl();
	}

	@Override
	public void placeOrder(Set<ProductRequest> products, String username) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelOrder(int orderID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public OrderRepresentation getOrder(int orderID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderStatusRepresentation getOrderStatus(int orderID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void notifyCancellation() {
		// TODO Auto-generated method stub
		
	}

}
