package Service.Resource.Delivery;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import Service.Representation.Delivery.Representation.DeliveryStatusRepresentation;
import Service.Representation.Delivery.Request.DeliveryRequest;
import Service.Workflow.Delivery.DeliveryActivity;
import Service.Workflow.Delivery.DeliveryActivityImpl;

@Path("/")
public class DeliveryResource implements DeliveryService{

	@POST
	@Produces({"application/xml","application/json"})
	@Path("/delivery/{orderID}")
	@Override
	public void provideDeliveryStatus(@PathParam("orderID")int orderID, DeliveryRequest deliveryRequest) {
		// TODO Auto-generated method stub
		DeliveryActivity deliveryActivity = new DeliveryActivityImpl();
		deliveryActivity.provideStatus(orderID,deliveryRequest);
		
		
	}

	

}
