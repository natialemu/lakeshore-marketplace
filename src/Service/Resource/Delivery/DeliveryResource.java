package Service.Resource.Delivery;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import Service.Representation.Delivery.Representation.DeliveryStatusRepresentation;
import Service.Representation.Delivery.Request.DeliveryRequest;
import Service.Workflow.Delivery.DeliveryActivity;
import Service.Workflow.Delivery.DeliveryActivityImpl;

@Path("/delivery/")
public class DeliveryResource implements DeliveryService{

	@POST
	@Consumes({"application/xml","application/json"})
	@Path("/")
	@Override
	public void provideDeliveryStatus(DeliveryRequest deliveryRequest) {
		// TODO Auto-generated method stub
		DeliveryActivity deliveryActivity = new DeliveryActivityImpl();
		deliveryActivity.provideStatus(deliveryRequest.getOrderID(),deliveryRequest);
		
		
	}
	@GET
	@Produces({"application/xml","application/json"})
	@Path("/")
	@Override
	public DeliveryStatusRepresentation getDeliveryStatus(int tracking_number) {
		DeliveryActivity deliveryActivity = new DeliveryActivityImpl();
		return deliveryActivity.getDeliveryStatus(tracking_number);
	}

	

}
