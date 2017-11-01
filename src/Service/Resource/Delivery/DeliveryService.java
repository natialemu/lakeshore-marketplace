package Service.Resource.Delivery;

import javax.jws.WebService;

import Service.Representation.Delivery.DeliveryRequest;
import Service.Representation.Delivery.DeliveryStatusRepresentation;

@WebService
public interface DeliveryService {
	
	void provideDeliveryStatus(int orderID, DeliveryRequest deliveryRequest);

}
