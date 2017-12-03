package Service.Workflow.Order;

import java.util.*;

import Domain.Account.Account;
import Domain.Account.AccountFactory;
import Domain.Account.AccountFactoryImpl;
import Domain.Customer.Customer;
import Domain.Customer.CustomerFactory;
import Domain.Customer.CustomerFactoryImpl;
import Domain.Order.Order;
import Domain.Order.OrderFactory;
import Domain.Order.OrderFactoryImpl;
import Domain.Partner.PartnerFactory;
import Domain.Partner.PartnerFactoryImpl;
import Domain.Product.Product;
import Domain.Product.ProductImpl;
import Service.Common.MediaTypes;
import Service.Common.URIs;
import Service.Representation.Link;
import Service.Representation.LinkImpl;
import Service.Representation.Account.Representation.AccountValidationRepresentation;
import Service.Representation.Account.Representation.AccountValidationRepresentationImpl;
import Service.Representation.Order.Representation.OrderRepresentation;
import Service.Representation.Order.Representation.OrderRepresentationImpl;
import Service.Representation.Order.Representation.OrderStatusRepresentation;
import Service.Representation.Order.Representation.OrderStatusRepresentationImpl;
import Service.Representation.Product.Representation.ProductRepresentation;
import Service.Representation.Product.Representation.ProductRepresentationImpl;
import Service.Representation.Product.Request.ProductRequest;

public class OrderActivityImpl implements OrderActivity {

	private OrderFactory orderFactory;
	private CustomerFactory customerFactory;
	private PartnerFactory partnerFactory;
	private AccountFactory accountFactory;
	
	public OrderActivityImpl() {
		orderFactory = new OrderFactoryImpl();
		customerFactory = new CustomerFactoryImpl();
		partnerFactory = new PartnerFactoryImpl();
		accountFactory = new AccountFactoryImpl();
	}

	@Override
	public AccountValidationRepresentation placeOrder(Set<ProductRequest> products, String username) {

		AccountValidationRepresentation avr = new AccountValidationRepresentationImpl();
		List<Product> productList = new ArrayList<>();
		getProductList(products,productList);
		assert(productList.size() == products.size());
		Account account = accountFactory.getAccount(username);
		if(account != null) {
			int accountID = account.getAccountID();
			Customer c = customerFactory.getCustomer(accountID);
			
            orderFactory.createOrder(productList, c);
            avr.setIsSuccessful(true);
            
		}else {
			avr.setIsSuccessful(false);
			System.out.println("Account with username of "+username+" not found");
		}
		
		setPlacedOrderLinks(avr,username);
		return avr;
		
		
	}


	private void setPlacedOrderLinks(AccountValidationRepresentation avr,String username) {

		//ac
		List<Link> links = new ArrayList<>();
		
		//place order
		
		List<Order> mostRecentOrder = orderFactory.getMostRecentOrders(1);
		assert(mostRecentOrder.size() <= 1);
		int mostRecentOrderID = mostRecentOrder.get(0).getOrderID();
		
		Link cancelOrder = new LinkImpl("DELETE",URIs.ORDER+"/"+mostRecentOrderID,"Cancel order",MediaTypes.JSON);
		links.add(cancelOrder);
		
		

		//get order
		Link getOrder = new LinkImpl("GET",URIs.ORDER+"/"+mostRecentOrderID,"Get order",MediaTypes.JSON);
		links.add(getOrder);
		
		
		//view order Confirmation
		Link orderConfirmation = new LinkImpl("GET",URIs.ORDER+"/status/"+mostRecentOrderID,"Get order status",MediaTypes.JSON);
		links.add(orderConfirmation);
		
		//track order
		Link trackOrder = new LinkImpl("GET",URIs.DELIVERYSTATUS,"Order tracking",MediaTypes.JSON);
		links.add(trackOrder);
		
		Link[] linkArray = new Link[links.size()];
		avr.setLinks(links.toArray(linkArray));
	}

	private void getProductList(Set<ProductRequest> products,List<Product> productList) {
		
		for(ProductRequest pr: products) {
			Product newProduct = new ProductImpl(pr.getProductCost(),pr.getProductName(),pr.getProductTag(),pr.getProductType());
			productList.add(newProduct);
		}
		
	}
	@Override
	public AccountValidationRepresentation cancelOrder(int orderID) {
		AccountValidationRepresentation avr = new AccountValidationRepresentationImpl();
		if(orderFactory.cancelOrder(orderID)) {
			avr.setIsSuccessful(true);
		}else {
			avr.setIsSuccessful(false);
		}
		
		//setLinks(avr);
		return avr;
		
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
		assert(order.getOrderID() == orderID);
		OrderRepresentation orderRepresentation = new OrderRepresentationImpl();
		orderRepresentation.setCustomerName(order.getOrderDetail().getCustomer().getAccount().getAccountProfile().getContactInfo().getFullName());
		orderRepresentation.setOrderConfirmationNumber(order.getConfirmationID());
		orderRepresentation.setOrderCost(order.getOrderDetail().getTotalCost());
		orderRepresentation.setOrderDate(order.getOrderDetail().getOrderCreated().toString());
		
		Set<ProductRepresentation> productRepresentation  = new HashSet<>();
		
		convertToProductRepresentation(order.getOrderDetail().getAllProducts(),productRepresentation);
		orderRepresentation.setProductsInOrder(productRepresentation);
		setLinkAfterGettingOrder(orderRepresentation,order.getOrderID());
		
		
		return orderRepresentation;

		
	}

	private void setLinkAfterGettingOrder(OrderRepresentation orderRepresentation, int orderID) {
		List<Link> links = new ArrayList<>();
		
		
		
		
		Link cancelOrder = new LinkImpl("DELETE",URIs.ORDER+"/"+orderID,"Cancel order",MediaTypes.JSON);
		links.add(cancelOrder);
		
		
		//view order Confirmation
		Link orderConfirmation = new LinkImpl("GET",URIs.ORDER+"/status/"+orderID,"Get order status",MediaTypes.JSON);
		links.add(orderConfirmation);
		
		//track order
		Link trackOrder = new LinkImpl("GET",URIs.DELIVERYSTATUS,"Order tracking",MediaTypes.JSON);
		links.add(trackOrder);
		
		Link[] linkArray = new Link[links.size()];
		orderRepresentation.setLinks(links.toArray(linkArray));
		
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
		
		
	}

	@Override
	public Set<OrderRepresentation> getMostRecentOrders(int numOrders) {
		Set<OrderRepresentation> or = new HashSet<>();
		List<Order> orders = orderFactory.getMostRecentOrders(numOrders);
		convertToOrderRepresentations(orders,or);
		
		return or;
		
	}

	private void convertToOrderRepresentations(List<Order> orders, Set<OrderRepresentation> or) {
		
		for(Order order:orders) {
			OrderRepresentation orderRepresentation = new OrderRepresentationImpl();
			orderRepresentation.setCustomerName(order.getOrderDetail().getCustomer().getAccount().getAccountProfile().getContactInfo().getFullName());
			orderRepresentation.setOrderConfirmationNumber(order.getConfirmationID());
			orderRepresentation.setOrderCost(order.getOrderDetail().getTotalCost());
			orderRepresentation.setOrderDate(order.getOrderDetail().getOrderCreated().toString());
			or.add(orderRepresentation);
			
		}
		
	}

	@Override
	public Set<OrderRepresentation> getOrdersOfPartner(String partner_username) {
		Set<OrderRepresentation> or = new HashSet<>();

		List<Order> orders = orderFactory.getOrdersOfPartner(partner_username);
		convertToOrderRepresentations(orders,or);
		setLinksAfterOrderDisplay(or);
		return or;

	}

	private void setLinksAfterOrderDisplay(Set<OrderRepresentation> or) {
		
		//TODO
	}

}
