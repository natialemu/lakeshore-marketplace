package Service.Resource.Product;

import java.util.Set;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import Service.Representation.Product.ProductRepresentation;
import Service.Workflow.Product.ProductAcitvity;
import Service.Workflow.Product.ProductActivityImpl;
@Path("/")
public class ProductSearchResource implements ProductSearchService{
	

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/products")
	@Override
	public Set<ProductRepresentation> getProducts() {
		// TODO Auto-generated method stub
		ProductAcitvity productActivity = new ProductActivityImpl();
		return productActivity.getAllProducts();
	}

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/product/{productID}")
	@Override
	public Set<ProductRepresentation> getProductByID(@PathParam("productID") int productID) {
		// TODO Auto-generated method stub
		ProductAcitvity productActivity = new ProductActivityImpl();
		return productActivity.getProductByID(productID);	}

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/products/{sellerName}")
	@Override
	public Set<ProductRepresentation> getProductsBySeller(@PathParam("sellerName") String sellerName) {
		// TODO Auto-generated method stub
		ProductAcitvity productActivity = new ProductActivityImpl();
		return productActivity.getProductBySeller(sellerName);
		
	}

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/products/{productType}")
	@Override
	public Set<ProductRepresentation> getProductsByType(@PathParam("productType") String productType) {
		// TODO Auto-generated method stub
		ProductAcitvity productActivity = new ProductActivityImpl();
		return productActivity.getProductByType(productType);	}

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/products")
	@Override
	public Set<ProductRepresentation> getProductsBySellerAndType(@QueryParam("employeeId") String sellerName, @QueryParam("productType") String productType) {
		// TODO Auto-generated method stub
		ProductAcitvity productActivity = new ProductActivityImpl();
		return productActivity.getProductsBySellerAndType(sellerName, productType);
	}

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/products/{productName}")
	@Override
	public Set<ProductRepresentation> getProductsByName(@PathParam("productName") String productName) {
		// TODO Auto-generated method stub
		ProductAcitvity productActivity = new ProductActivityImpl();
		return productActivity.getProductsByName(productName);
		
	}
	
	

}
