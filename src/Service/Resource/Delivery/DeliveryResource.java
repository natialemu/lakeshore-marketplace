package Service.Resource.Delivery;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import org.apache.cxf.rs.security.cors.CorsHeaderConstants;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.apache.cxf.rs.security.cors.LocalPreflight;

import Service.Representation.Delivery.Representation.DeliveryStatusRepresentation;
import Service.Representation.Delivery.Request.DeliveryRequest;
import Service.Workflow.Delivery.DeliveryActivity;
import Service.Workflow.Delivery.DeliveryActivityImpl;

@CrossOriginResourceSharing(
        allowOrigins = {"http://localhost:63342"}, 
        allowCredentials = true,
        		allowHeaders = {
        				
                    "'Accept': 'application/json'",
                    "'Content-Type': 'application/json'"
                
        		        }
        		   
        
)
@Path("/")
public class DeliveryResource implements DeliveryService{

	@Context
	private HttpHeaders headers;

	@OPTIONS
    @Path("/")
    @LocalPreflight
    public Response options() {
        String origin = headers.getRequestHeader("Origin").get(0);
        
        if("http://localhost:63342".equals(origin)) {return Response.ok()
                           .header(CorsHeaderConstants.HEADER_AC_ALLOW_METHODS, "POST PUT")
                           .header(CorsHeaderConstants.HEADER_AC_ALLOW_CREDENTIALS, "true")
                           .header(CorsHeaderConstants.HEADER_AC_ALLOW_ORIGIN, "http://localhost:63342")
                           .header(CorsHeaderConstants.HEADER_AC_ALLOW_HEADERS, "Content-Type")
                           .build();
        }else {
        	return Response.ok().build();
        }
        
    }
	
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
