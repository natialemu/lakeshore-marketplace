package Service.Representation.Order;

import Service.Representation.AbstractRepresentationInterface;

public interface OrderStatusRepresentation extends AbstractRepresentationInterface{
	void setOrderStatus(String orderStatus);
	String getOrderStatus();

}
