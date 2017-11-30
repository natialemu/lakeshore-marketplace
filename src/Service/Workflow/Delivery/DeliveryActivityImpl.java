package Service.Workflow.Delivery;

import Domain.Delivery.DeliveryFactory;
import Domain.Delivery.DeliveryFactoryImpl;
import Service.Representation.Delivery.Representation.DeliveryStatusRepresentation;
import Service.Representation.Delivery.Request.DeliveryRequest;

public class DeliveryActivityImpl implements DeliveryActivity{

	private DeliveryFactory deliveryFactory;
	
	public DeliveryActivityImpl() {
		deliveryFactory = new DeliveryFactoryImpl();
	}
	@Override
	public void provideStatus(int deliveryID, DeliveryRequest deliveryRequest) {

		deliveryFactory.acceptDeliveryStatus(deliveryID, Integer.parseInt(deliveryRequest.getTracking_number()), deliveryRequest.getDeliveryCarrier(), deliveryRequest.getDeliveryMethod());
		
	}

	

}
