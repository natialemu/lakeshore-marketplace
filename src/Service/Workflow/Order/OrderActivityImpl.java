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
import Service.Representation.Product.Request.ProductRequestImpl;

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
	public AccountValidationRepresentationImpl placeOrder(Set<ProductRequestImpl> products, String username) {

		AccountValidationRepresentationImpl avr = new AccountValidationRepresentationImpl();
		List<Product> productList = new ArrayList<>();
		getProductList(products,productList);
		assert(productList.size() == products.size());
		Account account = accountFactory.getAccount(username);
		Order orderReturned = null;
		if(account != null) {
			int accountID = account.getAccountID();
			Customer c = customerFactory.getCustomer(accountID);
			
            orderReturned = orderFactory.createOrder(productList, c);
            avr.setIsSuccessful(true);
            
		}else {
			avr.setIsSuccessful(false);
			System.out.println("Account with username of "+username+" not found");
		}
		
		setPlacedOrderLinks(avr,orderReturned);
		return avr;
		
		
	}


	private void setPlacedOrderLinks(AccountValidationRepresentationImpl avr,Order orderReturned) {

		List<LinkImpl> links = new ArrayList<>();
		
		//place order
		
		
		int mostRecentOrderID = orderReturned.getOrderID();
		
		LinkImpl cancelOrder = new LinkImpl("DELETE",URIs.ORDER+"/"+mostRecentOrderID,"Cancel order",MediaTypes.JSON);
		links.add(cancelOrder);
		
		

		//get order
		LinkImpl getOrder = new LinkImpl("GET",URIs.ORDER+"/"+mostRecentOrderID,"Get order",MediaTypes.JSON);
		links.add(getOrder);
		
		
		//view order Confirmation
		LinkImpl orderConfirmation = new LinkImpl("GET",URIs.ORDER+"/status/"+mostRecentOrderID,"Get order status",MediaTypes.JSON);
		links.add(orderConfirmation);
		
		//track order
		LinkImpl trackOrder = new LinkImpl("GET",URIs.DELIVERYSTATUS,"Order tracking",MediaTypes.JSON);
		links.add(trackOrder);
		
		LinkImpl[] linkArray = new LinkImpl[links.size()];
		avr.setLinks(links.toArray(linkArray));
	}

	private void getProductList(Set<ProductRequestImpl> products,List<Product> productList) {
		
		for(ProductRequestImpl pr: products) {
			Product newProduct = new ProductImpl(pr.getProductCost(),pr.getProductName(),pr.getProductTag(),pr.getProductType());
			productList.add(newProduct);
		}
		
	}
	@Override
	public AccountValidationRepresentationImpl cancelOrder(int orderID) {
		AccountValidationRepresentationImpl avr = new AccountValidationRepresentationImpl();
		Order cancelledOrder = orderFactory.cancelOrder(orderID);
		if(cancelledOrder != null) {
			avr.setIsSuccessful(true);
		}else {
			avr.setIsSuccessful(false);
		}
		
		setLinksAfterCancellation(avr, cancelledOrder);
		return avr;
		
	}
	
	private void setLinksAfterCancellation(AccountValidationRepresentationImpl avr, Order cancelledOrder) {
		// TODO Auto-generated method stub
		List<LinkImpl> links = new ArrayList<>();
		LinkImpl viewCanecelledOrder = new LinkImpl("GET",URIs.ORDER+"/"+cancelledOrder.getConfirmationID(),"View cancelled order",MediaTypes.JSON);
		links.add(viewCanecelledOrder);
		
		LinkImpl searchNewProducts = new LinkImpl("GET",URIs.PRODUCTS+"/","Search for new products",MediaTypes.JSON);
		links.add(searchNewProducts);
		
		LinkImpl[] linkArray = new LinkImpl[links.size()];
		links.toArray(linkArray);
		avr.setLinks(linkArray);
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
	public OrderRepresentationImpl getOrder(int orderID) {
		Order order = orderFactory.getOrder(orderID);
		assert(order.getConfirmationID() == orderID);
		OrderRepresentationImpl orderRepresentation = new OrderRepresentationImpl();
		orderRepresentation.setCustomerName(order.getOrderDetail().getCustomer().getAccount().getAccountProfile().getContactInfo().getFullName());
		orderRepresentation.setOrderConfirmationNumber(order.getConfirmationID());
		orderRepresentation.setOrderCost(order.getOrderDetail().getTotalCost());
		orderRepresentation.setOrderDate(order.getOrderDetail().getOrderCreated().toString());
		
		Set<ProductRepresentation> productRepresentation  = new HashSet<>();
		
		convertToProductRepresentation(order.getOrderDetail().getAllProducts(),productRepresentation);
		orderRepresentation.setProductsInOrder(productRepresentation);
		setLinkAfterGettingOrder(orderRepresentation,order);
		
		
		return orderRepresentation;

		
	}

	private void setLinkAfterGettingOrder(OrderRepresentation orderRepresentation, Order order) {
		List<LinkImpl> links = new ArrayList<>();
		
		
		
		int orderID = order.getConfirmationID();
		if(!order.getStringOrderState().equals("CancelledOrder")) {
			LinkImpl cancelOrder = new LinkImpl("DELETE",URIs.ORDER+"/"+orderID,"Cancel order",MediaTypes.JSON);
			links.add(cancelOrder);
			
		}
		
		
		
		//view order Confirmation
		LinkImpl orderConfirmation = new LinkImpl("GET",URIs.ORDER+"/status/"+orderID,"Get order status",MediaTypes.JSON);
		links.add(orderConfirmation);
		
		//track order
		LinkImpl trackOrder = new LinkImpl("GET",URIs.DELIVERYSTATUS,"Order tracking",MediaTypes.JSON);
		links.add(trackOrder);
		
		LinkImpl[] linkArray = new LinkImpl[links.size()];
		orderRepresentation.setLinks(links.toArray(linkArray));
		
	}

	@Override
	public OrderStatusRepresentationImpl getOrderStatus(int orderID) {
		// TODO Auto-generated method stub
		String orderStatus = orderFactory.getOrderStatus(orderID);
		OrderStatusRepresentationImpl orderRepresentation = new OrderStatusRepresentationImpl();
		orderRepresentation.setOrderStatus(orderStatus);
		

		return orderRepresentation;
	}

	@Override
	public void notifyCancellation(int orderID) {
		partnerFactory.orderReturned(orderID);
		
		
	}

	@Override
	public Set<OrderRepresentationImpl> getMostRecentOrders(int numOrders) {
		Set<OrderRepresentationImpl> or = new HashSet<>();
		List<Order> orders = orderFactory.getMostRecentOrders(numOrders);
		convertToOrderRepresentations(orders,or);
		
		return or;
		
	}

	private void convertToOrderRepresentations(List<Order> orders, Set<OrderRepresentationImpl> or) {
		
		for(Order order:orders) {
			OrderRepresentationImpl orderRepresentation = new OrderRepresentationImpl();
			orderRepresentation.setCustomerName(order.getOrderDetail().getCustomer().getAccount().getAccountProfile().getContactInfo().getFullName());
			orderRepresentation.setOrderConfirmationNumber(order.getConfirmationID());
			orderRepresentation.setOrderCost(order.getOrderDetail().getTotalCost());
			orderRepresentation.setOrderDate(order.getOrderDetail().getOrderCreated().toString());
			or.add(orderRepresentation);
			
		}
		
	}

	@Override
	public Set<OrderRepresentationImpl> getOrdersOfPartner(String partner_username) {
		Set<OrderRepresentationImpl> or = new HashSet<>();

		List<Order> orders = orderFactory.getOrdersOfPartner(partner_username);
		convertToOrderRepresentations(orders,or);
		setLinksAfterOrderDisplay(or);
		return or;

	}

	private void setLinksAfterOrderDisplay(Set<OrderRepresentationImpl> or) {
	    //TODO: links for manupilating the orders
		
		
		//cancelling the order
		//update status of order
	}

}
