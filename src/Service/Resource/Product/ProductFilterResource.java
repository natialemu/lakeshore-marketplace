package Service.Resource.Product;

import java.util.Set;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import Service.Representation.Product.ProductRepresentation;
import Service.Representation.Product.ProductRequest;
import Service.Workflow.Product.ProductAcitvity;
import Service.Workflow.Product.ProductActivityImpl;

@Path("/")
public class ProductFilterResource implements ProductFilterService {

	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/products")
	@Override
	public Set<ProductRepresentation> filterProductByCost(Set<ProductRequest> products, @QueryParam("minimum_cost") double minCost,
			@QueryParam("maximum_cost") double maxCost) {
		ProductAcitvity productActivity = new ProductActivityImpl();
		// TODO Auto-generated method stub
		return null;
	}

	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/products")
	@Override
	public Set<ProductRepresentation> filterProductByRating(Set<ProductRequest> products, @QueryParam("minimum_rating") int minRating,
			@QueryParam("maximum_rating") int maxRating) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/sortedProduct")
	@Override
	public Set<ProductRepresentation> sortInAscendingOrder(Set<ProductRequest> products) {
		// TODO Auto-generated method stub
		return null;
	}

	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/reverseSortedProduct")
	@Override
	public Set<ProductRepresentation> sortInDescendingOrder(Set<ProductRequest> products) {
		// TODO Auto-generated method stub
		return null;
	}

	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/products")
	@Override
	public Set<ProductRepresentation> filterProductByDate(Set<ProductRequest> products, @QueryParam("minimum_date") String date1, @QueryParam("maximum_date") String date2) {
		// TODO Auto-generated method stub
		return null;
	}

	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/products")
	@Override
	public Set<ProductRepresentation> filterProductBySeller(Set<ProductRequest> products, @QueryParam("seller_name") String sellerName) {
		// TODO Auto-generated method stub
		return null;
	}

}
