package Service.Resource.Order;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.PUT;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import Service.Representation.Account.Representation.AccountValidationRepresentation;
import Service.Representation.Account.Request.BasicAccountRequest;
import Service.Representation.Order.Representation.OrderRepresentation;
import Service.Representation.Order.Representation.OrderStatusRepresentation;
import Service.Representation.Order.Request.OrderRequest;
import Service.Representation.Product.Request.ProductRequest;
import Service.Workflow.Order.OrderActivity;
import Service.Workflow.Order.OrderActivityImpl;

@Path("/order")
public class OrderResource implements OrderService{

	@POST
	@Path("/")
	@Produces({"application/xml" , "application/json"})
	@Consumes({"application/xml" , "application/json"})
	@Override
	public AccountValidationRepresentation placeOrder(OrderRequest orderRequest) {
		// TODO Auto-generated method stub
		OrderActivity orderActivity = new OrderActivityImpl();
		return orderActivity.placeOrder(orderRequest.getProductsInOrder(),orderRequest.getUsername());
	}

	@DELETE
	@Path("/{orderID}")
	@Produces({"application/xml" , "application/json"})
	@Override
	public AccountValidationRepresentation cancelOrder(@PathParam("orderID") int orderID) {
		// TODO Auto-generated method stub
		OrderActivity orderActivity = new OrderActivityImpl();
		return orderActivity.cancelOrder(orderID);
	}

	@GET
	@Produces({"application/xml", "application/json"})
	@Path("/{orderID}")
	@Override
	public OrderRepresentation getOrder(@PathParam("orderID") int orderID) {
		// TODO Auto-generated method stub
		OrderActivity orderActivity = new OrderActivityImpl();
		return orderActivity.getOrder(orderID);
		
	}

	@GET
	@Produces({"application/xml", "application/json"})
	@Path("/status/{orderID}")
	@Override
	public OrderStatusRepresentation getOrderStatus(@PathParam("orderID")int orderID) {
		// TODO Auto-generated method stub
		OrderActivity orderActivity = new OrderActivityImpl();
		return orderActivity.getOrderStatus(orderID);
		
	}

	@GET
	@Produces({"application/xml", "application/json"})
	@Path("/{num_order}")
	@Override
	public Set<OrderRepresentation> getMostRecentOrders(@PathParam("num_order") int numOrders) {
		OrderActivity orderActivity = new OrderActivityImpl();
		
		return orderActivity.getMostRecentOrders(numOrders);
	}
	
	@GET
	@Produces({"application/xml", "application/json"})
	@Path("/{partner_username}")
	@Override
	public Set<OrderRepresentation> getOrdersOfPartner(@PathParam("partner_username") String partner_username) {
		OrderActivity orderActivity = new OrderActivityImpl();
		
		return orderActivity.getOrdersOfPartner(partner_username);
	}


	

}
