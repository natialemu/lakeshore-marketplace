package Service.Representation.Order;
import Service.Representation.Product.ProductRepresentation;

@XmlRootElement(name = "Order Status")
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
