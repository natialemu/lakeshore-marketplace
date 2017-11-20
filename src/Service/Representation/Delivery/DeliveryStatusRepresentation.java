package Service.Representation.Delivery;

import Service.Representation.AbstractRepresentationInterface;

public interface DeliveryStatusRepresentation extends AbstractRepresentationInterface {
	void setDeliveryConfirmationID(String deliveryConfirmationID);
	void setDeliveryMethod(String deliveryMethod);
	void setDeliveryCarrier(String deliveryCarrier);
	void setTracking_number(String tracking_number);
	
	String getDeliveryConfirmationID();
	String getDeliveryMethod();
	String getDeliveryCarrier();
	String getTracking_number();

}
