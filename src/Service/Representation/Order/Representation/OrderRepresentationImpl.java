package Service.Representation.Order.Representation;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import Service.Representation.AbstractRepresentation;
import Service.Representation.Product.Representation.ProductRepresentation;

@XmlRootElement(name = "Order")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class OrderRepresentationImpl extends AbstractRepresentation implements OrderRepresentation{
	
	private String customerName;
	private double orderCost;
	private String orderDate;
	
	@XmlElement(name = "products")
	private Set<ProductRepresentation> productsInOrder;
	private int orderConfirmationNumber;
	
	public OrderRepresentationImpl() {
		productsInOrder = new HashSet<>();
	}
	
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
	public Set<ProductRepresentation> getProductsInOrder() {
		return productsInOrder;
	}
	public void setProductsInOrder(Set<ProductRepresentation> productsInOrder) {
		this.productsInOrder = productsInOrder;
	}
	
	

}
