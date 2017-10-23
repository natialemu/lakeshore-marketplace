package Service.Representation;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "Order")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
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
