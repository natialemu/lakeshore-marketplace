package Service.Resource.Product;

import java.util.Set;

import javax.jws.WebService;

import Service.Representation.Account.Representation.AccountValidationRepresentation;
import Service.Representation.Account.Representation.AccountValidationRepresentationImpl;
import Service.Representation.Account.Request.BasicAccountRequest;
import Service.Representation.Order.Representation.OrderRepresentation;
import Service.Representation.Product.Representation.MinProductRepresentation;
import Service.Representation.Product.Representation.MinProductRepresentationImpl;
import Service.Representation.Product.Representation.ProductRepresentation;
import Service.Representation.Product.Representation.ProductRepresentationImpl;
import Service.Representation.Product.Request.ProductRequest;
import Service.Representation.Product.Request.ProductRequestImpl;

@WebService
public interface ProductService {
	
	Set<MinProductRepresentationImpl> getProducts();
	Set<ProductRepresentationImpl> getProductByID(int productID);

	Set<ProductRepresentationImpl> getProductsBySeller(String sellerName);

	Set<MinProductRepresentationImpl> getProductsByType(String productType);

	Set<MinProductRepresentationImpl> getProductsByName(String productName);
	
	
	//CREATE
	AccountValidationRepresentationImpl addProduct(Set<ProductRequestImpl> products,String username);
	
	//DELETE
	AccountValidationRepresentation deleteProduct(int partner_id, int product_id);
	
	Set<MinProductRepresentationImpl> getRecentlyAddedProducts(int numOrders);
	Set<MinProductRepresentationImpl> getInventory(String username);

	


	


}
