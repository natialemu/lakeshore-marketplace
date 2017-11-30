package Service.Representation.Order.Representation;

import Service.Representation.AbstractRepresentationInterface;

public interface OrderStatusRepresentation extends AbstractRepresentationInterface{
	void setOrderStatus(String orderStatus);
	String getOrderStatus();

}
