package Service.Representation;

import java.util.List;


public class OrderRepresentationImpl implements OrderRepresentation{
	
	private String customerName;
	private double orderCost;
	private String orderDate;
	private List<ProductRepresentation> productsInOrder;
	private int orderConfirmationNumber;
	
	public OrderRepresentationImpl() {}
	
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public int getOrderConfirmationNumber() {
		return orderConfirmationNumber;
	}
	
	public void setOrderConfirmationNumber(int orderConfirmationNumber) {
		this.orderConfirmationNumber = orderConfirmationNumber;
	}
	public double getOrderCost() {
		return orderCost;
	}
	public void setOrderCost(double orderCost) {
		this.orderCost = orderCost;
	}
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	public List<ProductRepresentation> getProductsInOrder() {
		return productsInOrder;
	}
	public void setProductsInOrder(List<ProductRepresentation> productsInOrder) {
		this.productsInOrder = productsInOrder;
	}
	
	

}
