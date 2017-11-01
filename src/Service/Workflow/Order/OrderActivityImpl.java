package Service.Workflow.Order;

import java.util.*;

import Domain.Customer.CustomerFactory;
import Domain.Customer.CustomerFactoryImpl;
import Domain.Order.Order;
import Domain.Order.OrderFactory;
import Domain.Order.OrderFactoryImpl;
import Domain.Partner.PartnerFactory;
import Domain.Partner.PartnerFactoryImpl;
import Domain.Product.Product;
import Domain.Product.ProductImpl;
import Service.Representation.Order.OrderRepresentation;
import Service.Representation.Order.OrderRepresentationImpl;
import Service.Representation.Order.OrderStatusRepresentation;
import Service.Representation.Order.OrderStatusRepresentationImpl;
import Service.Representation.Product.ProductRepresentation;
import Service.Representation.Product.ProductRepresentationImpl;
import Service.Representation.Product.ProductRequest;

public class OrderActivityImpl implements OrderActivity {

	private OrderFactory orderFactory;
	private CustomerFactory customerFactory;
	private PartnerFactory partnerFactory;
	
	public OrderActivityImpl() {
		orderFactory = new OrderFactoryImpl();
		customerFactory = new CustomerFactoryImpl();
		partnerFactory = new PartnerFactoryImpl();
	}

	@Override
	public void placeOrder(Set<ProductRequest> products, String username) {

		List<Product> productList = new ArrayList<>();
		getProductList(products,productList);
		orderFactory.createOrder(productList, customerFactory.createCustomer());
		
	}


	private void getProductList(Set<ProductRequest> products,List<Product> productList) {
		
		for(ProductRequest pr: products) {
			Product newProduct = new ProductImpl(pr.getProductCost(),pr.getProductName(),pr.getProductTag(),pr.getProductType());
			productList.add(newProduct);
		}
		
	}
	@Override
	public void cancelOrder(int orderID) {
		orderFactory.cancelOrder(orderID);
		
	}
	
	private void convertToProductRepresentation(List<Product> filteredProduct,
			Set<ProductRepresentation> productRepresentation) {
		// TODO Auto-generated method stub
		for(Product p: filteredProduct) {
			ProductRepresentation prep = new ProductRepresentationImpl();
			prep.setPartnerName(p.getParner().getAccount().getAccountProfile().getContactInfo().getFullName());
			prep.setProductCost(p.getProductCost());
			prep.setProductName(p.getProductName());
			prep.setProductTag(p.getProductTag());
			prep.setProductType(p.getProductType());
			
			productRepresentation.add(prep);
		}
		
	}

	@Override
	public OrderRepresentation getOrder(int orderID) {
		Order order = orderFactory.getOrder(orderID);
		OrderRepresentation orderRepresentation = new OrderRepresentationImpl();
		orderRepresentation.setCustomerName(order.getOrderDetail().getCustomer().getAccount().getAccountProfile().getContactInfo().getFullName());
		orderRepresentation.setOrderConfirmationNumber(order.getConfirmationID());
		orderRepresentation.setOrderCost(order.getOrderDetail().getTotalCost());
		orderRepresentation.setOrderDate(order.getOrderDetail().getOrderCreated().toString());
		
		Set<ProductRepresentation> productRepresentation  = new HashSet<>();
		
		convertToProductRepresentation(order.getOrderDetail().getAllProducts(),productRepresentation);
		orderRepresentation.setProductsInOrder(productRepresentation);
		
		return orderRepresentation;

		
	}

	@Override
	public OrderStatusRepresentation getOrderStatus(int orderID) {
		// TODO Auto-generated method stub
		String orderStatus = orderFactory.getOrderStatus(orderID);
		OrderStatusRepresentation orderRepresentation = new OrderStatusRepresentationImpl();
		orderRepresentation.setOrderStatus(orderStatus);
		

		return orderRepresentation;
	}

	@Override
	public void notifyCancellation(int orderID) {
		partnerFactory.orderReturned(orderID);
		
		// TODO Auto-generated method stub
		
	}

}
