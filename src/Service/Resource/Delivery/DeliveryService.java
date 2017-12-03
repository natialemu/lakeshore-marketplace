package Service.Resource.Delivery;

import javax.jws.WebService;

import Service.Representation.Delivery.Representation.DeliveryStatusRepresentation;
import Service.Representation.Delivery.Request.DeliveryRequest;

@WebService
public interface DeliveryService {
	
	void provideDeliveryStatus(DeliveryRequest deliveryRequest);
	DeliveryStatusRepresentation getDeliveryStatus(int tracking_number);

}
