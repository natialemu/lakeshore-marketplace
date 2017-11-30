package Service.Resource.Product;

import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import Service.Representation.Account.Request.BasicAccountRequest;
import Service.Representation.Product.Representation.MinProductRepresentation;
import Service.Representation.Product.Representation.ProductRepresentation;
import Service.Representation.Product.Request.ProductRequest;
import Service.Workflow.Product.ProductAcitvity;
import Service.Workflow.Product.ProductActivityImpl;
@Path("/products/")
public class ProductResource implements ProductService{
	

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/")
	@Override
	public Set<MinProductRepresentation> getProducts() {

		ProductAcitvity productActivity = new ProductActivityImpl();
		return productActivity.getAllProducts();
	}

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/{productID}")
	@Override
	public Set<ProductRepresentation> getProductByID(@PathParam("productID") int productID) {

		ProductAcitvity productActivity = new ProductActivityImpl();
		return productActivity.getProductByID(productID);	}

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/{sellerName}")
	@Override
	public Set<ProductRepresentation> getProductsBySeller(@PathParam("sellerName") String sellerName) {

		ProductAcitvity productActivity = new ProductActivityImpl();
		return productActivity.getProductBySeller(sellerName);
		
	}

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/{productType}")
	@Override
	public Set<MinProductRepresentation> getProductsByType(@PathParam("productType") String productType) {

		ProductAcitvity productActivity = new ProductActivityImpl();
		return productActivity.getProductByType(productType);	}

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/")
	@Override
	public Set<MinProductRepresentation> getProductsBySellerAndType(@QueryParam("employeeId") String sellerName, @QueryParam("productType") String productType) {

		ProductAcitvity productActivity = new ProductActivityImpl();
		return productActivity.getProductsBySellerAndType(sellerName, productType);
	}

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/{productName}")
	@Override
	public Set<MinProductRepresentation> getProductsByName(@PathParam("productName") String productName) {

		ProductAcitvity productActivity = new ProductActivityImpl();
		return productActivity.getProductsByName(productName);
		
	}
	

	@POST
	@Consumes({"application/xml" , "application/json"})
	@Path("/{username}")
	@Override
	public void addProduct(Set<ProductRequest> products,@PathParam("username")String username ) {
		ProductAcitvity productActivity = new ProductActivityImpl();
		productActivity.addProduct(username,products);
		
		
	}

	@DELETE
	@Consumes({"application/xml" , "application/json"})
	@Path("/")
	@Override
	public void deleteProduct(int partner_id, int product_id) {
		
		ProductAcitvity productActivity = new ProductActivityImpl();
		productActivity.deleteProduct(partner_id,product_id);
	}
	
	

}
