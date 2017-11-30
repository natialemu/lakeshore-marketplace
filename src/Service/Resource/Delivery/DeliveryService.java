package Service.Resource.Delivery;

import javax.jws.WebService;

import Service.Representation.Delivery.Representation.DeliveryStatusRepresentation;
import Service.Representation.Delivery.Request.DeliveryRequest;

@WebService
public interface DeliveryService {
	
	void provideDeliveryStatus(int orderID, DeliveryRequest deliveryRequest);

}
