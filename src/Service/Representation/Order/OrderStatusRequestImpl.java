package Service.Representation.Order;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import Service.Representation.Product.ProductRepresentation;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class OrderStatusRequestImpl implements OrderStatusRequest{
	private int orderConfirmationNumber;
	
	void OrderStatusRequestImpl() {}
	
	public int getOrderConfirmationNumber() {
		return orderConfirmationNumber;
	}
	
	public void setOrderConfirmationNumber(int orderConfirmationNumber) {
		this.orderConfirmationNumber = orderConfirmationNumber;
	}
}
