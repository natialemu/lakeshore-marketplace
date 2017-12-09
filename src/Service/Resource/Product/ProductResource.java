package Service.Resource.Product;

import java.util.Set;


import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import org.apache.cxf.rs.security.cors.CorsHeaderConstants;
import org.apache.cxf.rs.security.cors.CrossOriginResourceSharing;
import org.apache.cxf.rs.security.cors.LocalPreflight;

import Service.Representation.Account.Representation.AccountValidationRepresentation;
import Service.Representation.Account.Representation.AccountValidationRepresentationImpl;
import Service.Representation.Account.Request.BasicAccountRequest;
import Service.Representation.Product.Representation.MinProductRepresentation;
import Service.Representation.Product.Representation.MinProductRepresentationImpl;
import Service.Representation.Product.Representation.ProductRepresentation;
import Service.Representation.Product.Representation.ProductRepresentationImpl;
import Service.Representation.Product.Request.ProductRequest;
import Service.Representation.Product.Request.ProductRequestImpl;
import Service.Workflow.Product.ProductAcitvity;
import Service.Workflow.Product.ProductActivityImpl;

@CrossOriginResourceSharing(
        allowOrigins = {"http://localhost:63342"}, 
        allowCredentials = true,
        		allowHeaders = {
        				
                    "'Accept': 'application/json'",
                    "'Content-Type': 'application/json'"
                
        		        }
        		   
        
)
@Path("/")
public class ProductResource implements ProductService{
	@Context
	private HttpHeaders headers;
	
	@OPTIONS
    @Path("/inventory/{partner_username}")
    @LocalPreflight
    public Response options(@PathParam("partner_username") String username) {
        String origin = headers.getRequestHeader("Origin").get(0);
        
        if("http://localhost:63342".equals(origin)) {return Response.ok()
                           .header(CorsHeaderConstants.HEADER_AC_ALLOW_METHODS, "POST PUT GET")
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
                           .header(CorsHeaderConstants.HEADER_AC_ALLOW_METHODS, "POST PUT")
                           .header(CorsHeaderConstants.HEADER_AC_ALLOW_CREDENTIALS, "true")
                           .header(CorsHeaderConstants.HEADER_AC_ALLOW_ORIGIN, "http://localhost:63342")
                           .header(CorsHeaderConstants.HEADER_AC_ALLOW_HEADERS, "Content-Type")
                           .build();
        }else {
        	return Response.ok().build();
        }
        
    }
	
	@OPTIONS
    @Path("/{username}")
    @LocalPreflight
    public Response options1(@PathParam("partner_username") String username) {
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
	

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/")
	@Override
	public Set<MinProductRepresentationImpl> getProducts() {

		ProductAcitvity productActivity = new ProductActivityImpl();
		return productActivity.getAllProducts();
	}

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/{productID}")
	@Override
	public Set<ProductRepresentationImpl> getProductByID(@PathParam("productID") int productID) {

		ProductAcitvity productActivity = new ProductActivityImpl();
		return productActivity.getProductByID(productID);	}

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/{sellerName}")
	@Override
	public Set<ProductRepresentationImpl> getProductsBySeller(@PathParam("sellerName") String sellerName) {

		ProductAcitvity productActivity = new ProductActivityImpl();
		return productActivity.getProductBySeller(sellerName);
		
	}

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/{productType}")
	@Override
	public Set<MinProductRepresentationImpl> getProductsByType(@PathParam("productType") String productType) {

		ProductAcitvity productActivity = new ProductActivityImpl();
		return productActivity.getProductByType(productType);	}

	

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/{productName}")
	@Override
	public Set<MinProductRepresentationImpl> getProductsByName(@PathParam("productName") String productName) {

		ProductAcitvity productActivity = new ProductActivityImpl();
		return productActivity.getProductsByName(productName);
		
	}
	

	@POST
	@Consumes({"application/xml" , "application/json"})
	@Produces({"application/xml" , "application/json"})
	@Path("/{username}")
	@Override
	public AccountValidationRepresentationImpl addProduct(Set<ProductRequestImpl> products,@PathParam("username")String username ) {
		ProductAcitvity productActivity = new ProductActivityImpl();
		return productActivity.addProduct(username,products);
		
		
	}

	@DELETE
	@Produces({"application/xml" , "application/json"})
	@Path("/")
	@Override
	public AccountValidationRepresentation deleteProduct(@QueryParam("partner_id") int partner_id, @QueryParam("product_id")int product_id) {
		//WRONG
		ProductAcitvity productActivity = new ProductActivityImpl();
		return productActivity.deleteProduct(partner_id,product_id);
	}

	@GET
	@Produces({"application/xml" , "application/json"})
	@Path("/{product_number}")
	@Override
	public Set<MinProductRepresentationImpl> getRecentlyAddedProducts(@PathParam("product_number")int numOrders) {
		
		ProductAcitvity productActivity = new ProductActivityImpl();
		return productActivity.getRecentlyAddedProducts(numOrders);
	} 
	
	@GET
	@Produces({"application/xml", "application/json"})
	@Path("/inventory/{partner_username}")
	@Override
	public Set<MinProductRepresentationImpl> getInventory(@PathParam("partner_username") String username){
		ProductAcitvity productActivity = new ProductActivityImpl();
		return productActivity.getInventory(username);
	}
	
	

}
