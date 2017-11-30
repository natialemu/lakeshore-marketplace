package Service.Resource.Product;

import java.util.Set;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import Service.Representation.Product.Representation.ProductRepresentation;
import Service.Representation.Product.Request.ProductRequest;
import Service.Workflow.Product.ProductAcitvity;
import Service.Workflow.Product.ProductActivityImpl;

@Path("/filter/products/")
public class ProductFilterResource implements ProductFilterService {

	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/")
	@Override
	public Set<ProductRepresentation> filterProductByCost(Set<ProductRequest> products, @QueryParam("minimum_cost") double minCost,
			@QueryParam("maximum_cost") double maxCost) {
		ProductAcitvity productActivity = new ProductActivityImpl();
		return productActivity.filterProductByCost(products,minCost,maxCost);
		// TODO Auto-generated method stub
	}

	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/")
	@Override
	public Set<ProductRepresentation> filterProductByRating(Set<ProductRequest> products, @QueryParam("minimum_rating") int minRating,
			@QueryParam("maximum_rating") int maxRating) {
		// TODO Auto-generated method stub
		ProductAcitvity productActivity = new ProductActivityImpl();
		return productActivity.filterProductByRating(products,minRating,maxRating);

	}
	

	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/")
	@Override
	public Set<ProductRepresentation> sortOrders(Set<ProductRequest> products,@QueryParam("sorted_order") boolean isAscending) {
		// TODO Auto-generated method stub
		ProductAcitvity productActivity = new ProductActivityImpl();
		if(isAscending) {
			return productActivity.sortInAscendingOrder(products);
		}else {
			return productActivity.sortInDescendingOrder(products);
			
		}
	}

	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/")
	@Override
	public Set<ProductRepresentation> filterProductByDate(Set<ProductRequest> products, @QueryParam("minimum_date") String date1, @QueryParam("maximum_date") String date2) {
		// TODO Auto-generated method stub
		ProductAcitvity productActivity = new ProductActivityImpl();
		return productActivity.filterProductByDate(products,date1,date2);
		
	}

	@POST
	@Produces({"application/xml" , "application/json"})
	@Path("/")
	@Override
	public Set<ProductRepresentation> filterProductBySeller(Set<ProductRequest> products, @QueryParam("seller_name") String sellerName) {
		// TODO Auto-generated method stub
		ProductAcitvity productActivity = new ProductActivityImpl();
		return productActivity.filterProductBySeller(products,sellerName);
		
	}

}
