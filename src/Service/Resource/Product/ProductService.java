package Service.Resource.Product;

import java.util.Set;

import javax.jws.WebService;

import Service.Representation.Account.BasicAccountRequest;
import Service.Representation.Product.MinProductRepresentation;
import Service.Representation.Product.ProductRepresentation;
import Service.Representation.Product.ProductRequest;

@WebService
public interface ProductService {
	
	Set<MinProductRepresentation> getProducts();
	Set<ProductRepresentation> getProductByID(int productID);

	Set<ProductRepresentation> getProductsBySeller(String sellerName);

	Set<MinProductRepresentation> getProductsByType(String productType);

	Set<MinProductRepresentation> getProductsBySellerAndType(String sellerName, String productType);
	Set<MinProductRepresentation> getProductsByName(String productName);
	
	
	//CREATE
	void addProduct(Set<ProductRequest> products,String username);
	
	//DELETE
	void deleteProduct(int partner_id, int product_id);
	


	


}