package Service.Resource.Order;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import org.apache.cxf.rs.security.cors.CorsHeaderConstants;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.apache.cxf.rs.security.cors.LocalPreflight;

import Service.Representation.Account.Representation.*;

import Service.Representation.Account.Request.*;

import Service.Representation.Order.Representation.*;
import Service.Representation.Order.Request.OrderRequest;
import Service.Representation.Order.Request.OrderRequestImpl;
import Service.Representation.Product.Request.ProductRequestImpl;
import Service.Workflow.Order.OrderActivity;
import Service.Workflow.Order.OrderActivityImpl;

@CrossOriginResourceSharing(
        allowOrigins = {"http://localhost:63342"}, 
        allowCredentials = true,
        		allowHeaders = {
        				
                    "'Accept': 'application/json'",
                    "'Content-Type': 'application/json'"
                
        		        }
        		   
        
)
@Path("/")
public class OrderResource implements OrderService{
	
	@Context
	private HttpHeaders headers;
	
	@OPTIONS
    @Path("/{username}")
    @LocalPreflight
    public Response options(@PathParam("username") String username) {
        String origin = headers.getRequestHeader("Origin").get(0);
        
        if("http://localhost:63342".equals(origin)) {return Response.ok()
                           .header(CorsHeaderConstants.HEADER_AC_ALLOW_METHODS, "POST, PUT")
                           .header(CorsHeaderConstants.HEADER_AC_ALLOW_CREDENTIALS, "true")
                           .header(CorsHeaderConstants.HEADER_AC_ALLOW_ORIGIN, "http://localhost:63342")
                           .header(CorsHeaderConstants.HEADER_AC_ALLOW_HEADERS, "Content-Type")
                           .build();
        }else {
        	return Response.ok().build();
        }
        
    }
	
	@OPTIONS
    @Path("/")
    @LocalPreflight
    public Response options() {
        String origin = headers.getRequestHeader("Origin").get(0);
        
        if("http://localhost:63342".equals(origin)) {return Response.ok()
                           .header(CorsHeaderConstants.HEADER_AC_ALLOW_METHODS, "POST, PUT, DELETE, GET")
                           .header(CorsHeaderConstants.HEADER_AC_ALLOW_CREDENTIALS, "true")
                           .header(CorsHeaderConstants.HEADER_AC_ALLOW_ORIGIN, "http://localhost:63342")
                           .header(CorsHeaderConstants.HEADER_AC_ALLOW_HEADERS, "Content-Type")
                           .build();
        }else {
        	return Response.ok().build();
        }
        
    }
	
	@OPTIONS
    @Path("/{orderID}")
    @LocalPreflight
    public Response options(@PathParam("orderID") int orderID) {
        String origin = headers.getRequestHeader("Origin").get(0);
        
        if("http://localhost:63342".equals(origin)) {return Response.ok()
                           .header(CorsHeaderConstants.HEADER_AC_ALLOW_METHODS, "POST, PUT, GET, DELETE")
                           .header(CorsHeaderConstants.HEADER_AC_ALLOW_CREDENTIALS, "true")
                           .header(CorsHeaderConstants.HEADER_AC_ALLOW_ORIGIN, "http://localhost:63342")
                           .header(CorsHeaderConstants.HEADER_AC_ALLOW_HEADERS, "Content-Type")
                           .build();
        }else {
        	return Response.ok().build();
        }
        
    }

	@POST
	@Path("/{username}")
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml" , "application/json"})
	@Override
	public AccountValidationRepresentationImpl placeOrder(Set<ProductRequestImpl> orderRequest, @PathParam("username") String username) {
		// TODO Auto-generated method stub
		OrderActivity orderActivity = new OrderActivityImpl();
		return (AccountValidationRepresentationImpl) orderActivity.placeOrder(orderRequest,username);
	}

	@DELETE
	@Path("/{orderID}")
	@Produces({"application/xml" , "application/json"})
	@Override
	public AccountValidationRepresentationImpl cancelOrder(@PathParam("orderID") int orderID) {
		// TODO Auto-generated method stub
		OrderActivity orderActivity = new OrderActivityImpl();
		return (AccountValidationRepresentationImpl) orderActivity.cancelOrder(orderID);
	}

	@GET
	@Produces({"application/xml", "application/json"})
	@Path("/{orderID}")
	@Override
	public OrderRepresentationImpl getOrder(@PathParam("orderID") int orderID) {
		// TODO Auto-generated method stub
		OrderActivity orderActivity = new OrderActivityImpl();
		return (OrderRepresentationImpl) orderActivity.getOrder(orderID);
		
	}

	@GET
	@Produces({"application/xml", "application/json"})
	@Path("/status/{orderID}")
	@Override
	public OrderStatusRepresentationImpl getOrderStatus(@PathParam("orderID")int orderID) {
		// TODO Auto-generated method stub
		OrderActivity orderActivity = new OrderActivityImpl();
		return (OrderStatusRepresentationImpl) orderActivity.getOrderStatus(orderID);
		
	}

	@GET
	@Produces({"application/xml", "application/json"})
	@Path("/recentOrders/{num_order}")
	@Override
	public Set<OrderRepresentationImpl> getMostRecentOrders(@PathParam("num_order") int numOrders) {
		OrderActivity orderActivity = new OrderActivityImpl();
		
		return orderActivity.getMostRecentOrders(numOrders);
	}
	
	@GET
	@Produces({"application/xml", "application/json"})
	@Path("/partner/{partner_username}")
	@Override
	public Set<OrderRepresentationImpl> getOrdersOfPartner(@PathParam("partner_username") String partner_username) {
		OrderActivity orderActivity = new OrderActivityImpl();
		
		return orderActivity.getOrdersOfPartner(partner_username);
	}

	


	

}
