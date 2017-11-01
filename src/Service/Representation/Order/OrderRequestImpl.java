package Service.Representation.Order;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import Service.Representation.Product.ProductRepresentation;

@XmlRootElement(name = "Order")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class OrderRequestImpl implements OrderRequest{
	private int orderConfirmationNumber;
	
	public OrderRequestImpl() {}
	
	public int getOrderConfirmationNumber() {
		return orderConfirmationNumber;
	}
	
	public void setOrderConfirmationNumber(int orderConfirmationNumber) {
		this.orderConfirmationNumber = orderConfirmationNumber;
	}
}