package Service.Workflow.Delivery;

import Service.Representation.Delivery.Representation.DeliveryStatusRepresentation;
import Service.Representation.Delivery.Request.DeliveryRequest;

public interface DeliveryActivity {

	void provideStatus(int orderID, DeliveryRequest deliveryRequest);

	DeliveryStatusRepresentation getDeliveryStatus(int tracking_number);

}
