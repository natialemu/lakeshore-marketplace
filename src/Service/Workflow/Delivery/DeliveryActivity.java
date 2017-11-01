package Service.Workflow.Delivery;

import Service.Representation.Delivery.DeliveryRequest;
import Service.Representation.Delivery.DeliveryStatusRepresentation;

public interface DeliveryActivity {

	void provideStatus(int orderID, DeliveryRequest deliveryRequest);

}
