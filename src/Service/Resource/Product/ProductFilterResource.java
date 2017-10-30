package Service.Resource.Product;

import java.util.Set;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import Service.Representation.Product.ProductRepresentation;
import Service.Representation.Product.ProductRequest;

@Path("/")
public class ProductFilterResource implements ProductFilterService {

	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/")
	@Override
	public Set<ProductRepresentation> filterProductByCost(Set<ProductRequest> products, @PathParam("minimum_cost") double minCost,
			@PathParam("maximum_cost") double maxCost) {
		// TODO Auto-generated method stub
		return null;
	}

	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/")
	@Override
	public Set<ProductRepresentation> filterProductByRating(Set<ProductRequest> products, @PathParam("minimum_rating") int minRating,
			@PathParam("maximum_rating") int maxRating) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/ascendingproduct")
	@Override
	public Set<ProductRepresentation> sortInAscendingOrder(Set<ProductRequest> products) {
		// TODO Auto-generated method stub
		return null;
	}

	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/descendingproduct")
	@Override
	public Set<ProductRepresentation> sortInDescendingOrder(Set<ProductRequest> products) {
		// TODO Auto-generated method stub
		return null;
	}

	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/")
	@Override
	public Set<ProductRepresentation> filterProductByDate(Set<ProductRequest> products, @PathParam("minimum_date") String date1, @PathParam("maximum_date") String date2) {
		// TODO Auto-generated method stub
		return null;
	}

	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/")
	@Override
	public Set<ProductRepresentation> filterProductBySeller(Set<ProductRequest> products, @PathParam("seller_name") String sellerName) {
		// TODO Auto-generated method stub
		return null;
	}

}
