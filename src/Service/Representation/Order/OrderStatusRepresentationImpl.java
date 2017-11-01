package Service.Representation.Order;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "OrderStatus")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")
public class OrderStatusRepresentationImpl implements OrderStatusRepresentation {
	private String orderStatus;
	
	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public OrderStatusRepresentationImpl() {}
	
	

}
