package Service.Resource.Product;

import java.util.Set;

import Service.Representation.Product.ProductRepresentation;
import Service.Representation.Product.ProductRequest;

public interface ProductService {
	
	Set<ProductRepresentation> getProducts();
	Set<ProductRepresentation> getProductByID(int productID);

	Set<ProductRepresentation> getProductsBySeller(String sellerName);

	Set<ProductRepresentation> getProductsByType(String productType);

	Set<ProductRepresentation> getProductsBySellerAndType(String sellerName, String productType);
	Set<ProductRepresentation> getProductsByName(String productName);
	
	
	//CREATE
	void addProduct(int partner_id, Set<ProductRequest> products);
	
	//DELETE
	void deleteProduct(int partner_id, int product_id);
	


	


}
