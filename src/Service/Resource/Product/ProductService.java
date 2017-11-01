package Service.Resource.Product;

import java.util.Set;

import javax.jws.WebService;

import Service.Representation.Account.BasicAccountRequest;
import Service.Representation.Product.ProductRepresentation;
import Service.Representation.Product.ProductRequest;

@WebService
public interface ProductService {
	
	Set<ProductRepresentation> getProducts();
	Set<ProductRepresentation> getProductByID(int productID);

	Set<ProductRepresentation> getProductsBySeller(String sellerName);

	Set<ProductRepresentation> getProductsByType(String productType);

	Set<ProductRepresentation> getProductsBySellerAndType(String sellerName, String productType);
	Set<ProductRepresentation> getProductsByName(String productName);
	
	
	//CREATE
	void addProduct(String username, Set<ProductRequest> products);
	
	//DELETE
	void deleteProduct(int partner_id, int product_id);
	


	


}
