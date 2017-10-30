package Service.Resource.Order;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import Service.Representation.Order.OrderRepresentation;
import Service.Representation.Order.OrderStatusRepresentation;
import Service.Representation.Product.ProductRequest;

@Path("/")
public class OrderResource implements OrderService{

	@POST
	@Path("/order/{orderID}")
	@Produces({"application/xml" , "application/json"})
	@Override
	public void placeOrder(Set<ProductRequest> products, @PathParam("username") String username) {
		// TODO Auto-generated method stub
		
	}

	@PUT
	@Path("/order/{orderID}")
	@Produces({"application/xml" , "application/json"})
	@Override
	public void cancelOrder(@PathParam("orderID") int orderID) {
		// TODO Auto-generated method stub
		
	}

	@GET
	@Produces({"application/xml", "application/json"})
	@Path("/order/{orderID}")
	@Override
	public OrderRepresentation getOrder(@PathParam("orderID") int orderID) {
		// TODO Auto-generated method stub
		return null;
	}

	@GET
	@Produces({"application/xml", "application/json"})
	@Path("/order_status/{orderID}")
	@Override
	public OrderStatusRepresentation getOrderStatus(@PathParam("orderID")int orderID) {
		// TODO Auto-generated method stub
		return null;
	}

}
